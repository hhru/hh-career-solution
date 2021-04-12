package ru.hh.career.solution.professionalenvironmentandspecialization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
