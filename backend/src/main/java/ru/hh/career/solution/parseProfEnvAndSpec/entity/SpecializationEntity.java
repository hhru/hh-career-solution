package ru.hh.career.solution.parseProfEnvAndSpec.entity;

import javax.persistence.*;

@Entity
@Table
public class SpecializationEntity {

    @Id
    @Column(name = "specialization_id")
    private Integer specializationId;

    @Column(name = "specialization_name")
    private String specializationName;

    @Column(name = "laboring")
    private Boolean laboring;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professional_environment_id")
    private Integer environmentId;

}
