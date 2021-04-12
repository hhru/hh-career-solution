package ru.hh.career.solution.professionalenvironmentandspecialization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "professional_environment")
public class ProfessionalEnvironmentEntity {

    @Id
    @OneToMany()
    @Column(name = "professional_environment_id")
    private Integer id;

    @Column(name = "professional_environment_name")
    private String professionalEnvironmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnvName() {
        return professionalEnvironmentName;
    }

    public void setEnvName(String envName) {
        this.professionalEnvironmentName = envName;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                ProfessionalEnvironmentEntity that = (ProfessionalEnvironmentEntity) o;
                return getId().equals(that.getId()) && getEnvName().equals(that.getEnvName());
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEnvName());
    }
}
