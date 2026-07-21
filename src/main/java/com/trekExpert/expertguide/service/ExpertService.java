package com.trekExpert.expertguide.service;

import com.trekExpert.expertguide.model.Expert;
import com.trekExpert.expertguide.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExpertService {

    @Autowired
    private ExpertRepository expertRepository;

    public List<Expert> getAllExperts() {
        return expertRepository.findAll();
    }

    public Optional<Expert> getExpertById(Long id) {
        return expertRepository.findById(id);
    }

    public Optional<Expert> getExpertByEmail(String email) {
        return expertRepository.findByEmail(email);
    }

    public List<Expert> getExpertsByExpertise(String expertise) {
        return expertRepository.findByExpertise(expertise);
    }

    public List<Expert> getActiveExperts() {
        return expertRepository.findByIsActive(true);
    }

    public Expert createExpert(Expert expert) {
        return expertRepository.save(expert);
    }

    public Expert updateExpert(Long id, Expert expertDetails) {
        Optional<Expert> expert = expertRepository.findById(id);
        if (expert.isPresent()) {
            Expert existingExpert = expert.get();
            if (expertDetails.getName() != null) {
                existingExpert.setName(expertDetails.getName());
            }
            if (expertDetails.getEmail() != null) {
                existingExpert.setEmail(expertDetails.getEmail());
            }
            if (expertDetails.getExpertise() != null) {
                existingExpert.setExpertise(expertDetails.getExpertise());
            }
            if (expertDetails.getBio() != null) {
                existingExpert.setBio(expertDetails.getBio());
            }
            if (expertDetails.getYearsExperience() != null) {
                existingExpert.setYearsExperience(expertDetails.getYearsExperience());
            }
            if (expertDetails.getIsActive() != null) {
                existingExpert.setIsActive(expertDetails.getIsActive());
            }
            return expertRepository.save(existingExpert);
        }
        return null;
    }

    public boolean deleteExpert(Long id) {
        if (expertRepository.existsById(id)) {
            expertRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
