package com.trekExpert.expertguide.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

@Entity
@Table(name = "experts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Expertise area is required")
    @Column(nullable = false)
    private String expertise;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(name = "years_experience")
    private Integer yearsExperience;

    @Column(name = "is_active")
    private Boolean isActive = true;
}
