package ru.hh.career.solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "adviser")
public class Adviser {

    @Id
    @Column(name = "adviser_id" , nullable = false)
    private Integer id;

    @Id
    @Column(name = "adviser_name" , nullable = false)
    private String name;

    @Id
    @Column(name = "adviser_soname" , nullable = false)
    private String soname;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    public Adviser(Integer id, String name, String soname, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.soname = soname;
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

    public String getSoname() {
        return soname;
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

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
