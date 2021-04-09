package ru.hh.career.solution.parseProfEnvAndSpec.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professional_environment")
public class ProfessionalEnvironmentEntity {

    @Id
    @Column(name = "env_id")
    private Integer id;

    @Column(name = "env_name")
    private String envName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }


}
