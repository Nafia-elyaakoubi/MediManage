package com.digitechbb.smsv1.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String reference;
    private String name;
    @ManyToOne
    @JoinColumn(name = "scholarLevelId")
    private ScholarLevel scholarLevel;

}
