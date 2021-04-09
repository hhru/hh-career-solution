package ru.hh.career.solution.parseProfEnvAndSpec.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessionalEnvironmentEntity)) return false;
        ProfessionalEnvironmentEntity that = (ProfessionalEnvironmentEntity) o;
        return getId().equals(that.getId()) && getEnvName().equals(that.getEnvName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEnvName());
    }
}
