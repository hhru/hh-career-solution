package ru.hh.career.solution.parseProfEnvAndSpec.entity;

import javax.persistence.*;

@Entity
@Table
public class SpecializationEntity {

    @Id
    @Column(name = "spec_id")
    private Integer specializationID;

    @Column(name = "spec_name")
    private String specializationName;

    @Column(name = "laboring")
    private Boolean laboring;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "env_id")
    private Integer environmentID;

}
