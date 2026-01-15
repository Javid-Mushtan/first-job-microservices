package com.javid.company.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


//@ToString(exclude = "jobs")
//@EqualsAndHashCode(exclude = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
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