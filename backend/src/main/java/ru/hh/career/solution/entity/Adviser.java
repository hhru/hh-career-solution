package ru.hh.career.solution.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@DynamicInsert
@Table(name = "adviser")
public class Adviser {

    @Id
    @Column(name = "id" , nullable = false)
    private Integer id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "surname" , nullable = false)
    private String surname;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    public Adviser(Integer id, String name, String surname, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.created = created;
        this.updated = updated;
    }

    public Adviser() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
