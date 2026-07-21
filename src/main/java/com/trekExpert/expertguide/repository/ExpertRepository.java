package com.trekExpert.expertguide.repository;

import com.trekExpert.expertguide.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {
    Optional<Expert> findByEmail(String email);
    List<Expert> findByExpertise(String expertise);
    List<Expert> findByIsActive(Boolean isActive);
}
