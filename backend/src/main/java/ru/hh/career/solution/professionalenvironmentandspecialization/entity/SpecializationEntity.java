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

    public SpecializationEntity(Integer id, String name, Boolean laboring, Integer environmentId) {
        this.environmentId = environmentId;
        this.specializationId = id;
        this.specializationName = name;
        this.laboring = laboring;
    }

    public SpecializationEntity(){}

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

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public Boolean getLaboring() {
        return laboring;
    }

    public void setLaboring(Boolean laboring) {
        this.laboring = laboring;
    }

    public Integer getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(Integer environmentId) {
        this.environmentId = environmentId;
    }
}
