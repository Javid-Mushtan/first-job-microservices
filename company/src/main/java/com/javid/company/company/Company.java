package com.javid.company.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
@ToString(exclude = "jobs")
@EqualsAndHashCode(exclude = "jobs")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

//    @JsonIgnore
//    @OneToMany(
//            mappedBy = "company",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<Job> jobs = new ArrayList<>();
//
//    @OneToMany(mappedBy = "company")
//    private List<Review> reviews;
}