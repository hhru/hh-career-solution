package ru.hh.career.solution.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adviser")
public class Adviser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String surname;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "area_id", referencedColumnName = "id")
  private Area area;

  @Cascade(CascadeType.ALL)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "adviserId")
  private Set<AdviserToEducational> educationalSet = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "adviser_to_professional_skill",
    joinColumns = @JoinColumn(name = "adviser_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "professional_skill_id", referencedColumnName = "id"))
  private Set<ProfessionalSkill> professionalSkillSet = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "adviser_to_professional_association",
    joinColumns = @JoinColumn(name = "adviser_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "professional_association_id", referencedColumnName = "id"))
  private Set<ProfessionalAssociation> professionalAssociationSet = new HashSet<>();

  public enum Consultation {
    OFFLINE("OFFLINE"), ONLINE("ONLINE"), ALL("ALL");

    private final String description;

    private Consultation(String description) {
      this.description = description;
    }

    public String getDescription() {
      return this.description;
    }
  }

  @Enumerated(EnumType.STRING)
  private Consultation consultation;

  public enum Experience {
    UP_TO_ONE_YEAR("UP_TO_ONE_YEAR"),
    UP_TO_THREE_YEARS("UP_TO_THREE_YEARS"),
    UP_TO_SIX_YEARS("UP_TO_SIX_YEARS"),
    MORE_THAN_SIX_YEARS("MORE_THAN_SIX_YEARS");

    private final String description;

    private Experience(String description) {
      this.description = description;
    }

    public String getDescription() {
      return this.description;
    }
  }

  @Enumerated(EnumType.STRING)
  private Experience experience;

  public enum CareerPractice {
    CONSULTATION("CONSULTATION"),
    COACHING("COACHING"),
    ALL("ALL");

    private final String description;

    private CareerPractice(String description) {
      this.description = description;
    }

    public String getDescription() {
      return this.description;
    }
  }

  @Enumerated(EnumType.STRING)
  @Column(name = "career_practice")
  private CareerPractice careerPractice;

  public enum CustomerType {
    NO_EXPERIENCE("NO_EXPERIENCE"),
    SPECIALISTS_AND_EXPERTS("SPECIALISTS_AND_EXPERTS"),
    MIDDLE_MANAGEMENT("MIDDLE_MANAGEMENT"),
    TOP_MANAGEMENT("TOP_MANAGEMENT");

    private final String description;

    private CustomerType(String description) {
      this.description = description;
    }

    public String getDescription() {
      return this.description;
    }
  }

  @Column(name = "customer_type")
  @Enumerated(EnumType.STRING)
  private CustomerType customerType;

  public enum ProblemType {
    ANY_PROBLEM("ANY_PROBLEM");

    private final String description;

    private ProblemType(String description) {
      this.description = description;
    }

    public String getDescription() {
      return this.description;
    }
  }

  @Column(name = "problem_type")
  @Enumerated(EnumType.STRING)
  private ProblemType problemType;

  private LocalDateTime created;

  private LocalDateTime updated;

  public Adviser() {
  }

  public Adviser(Integer id, String name, String surname, Area area, Set<AdviserToEducational> educationalSet,
                 Set<ProfessionalSkill> professionalSkillSet, Set<ProfessionalAssociation> professionalAssociationSet,
                 Consultation consultation, Experience experience, CareerPractice careerPractice, CustomerType customerType,
                 ProblemType problemType, LocalDateTime created, LocalDateTime updated) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.area = area;
    this.educationalSet = educationalSet;
    this.professionalSkillSet = professionalSkillSet;
    this.professionalAssociationSet = professionalAssociationSet;
    this.consultation = consultation;
    this.experience = experience;
    this.careerPractice = careerPractice;
    this.customerType = customerType;
    this.problemType = problemType;
    this.created = created;
    this.updated = updated;
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

  public Consultation getConsultation() {
    return consultation;
  }

  public Experience getExperience() {
    return experience;
  }

  public CareerPractice getCareerPractice() {
    return careerPractice;
  }

  public CustomerType getCustomerType() {
    return customerType;
  }

  public ProblemType getProblemType() {
    return problemType;
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

  public void setConsultation(Consultation consultation) {
    this.consultation = consultation;
  }

  public void setExperience(Experience experience) {
    this.experience = experience;
  }

  public void setCareerPractice(CareerPractice careerPractice) {
    this.careerPractice = careerPractice;
  }

  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }

  public void setProblemType(ProblemType problemType) {
    this.problemType = problemType;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public Set<ProfessionalSkill> getProfessionalSkillSet() {
    return professionalSkillSet;
  }

  public void setProfessionalSkillSet(Set<ProfessionalSkill> professionalSkillSet) {
    this.professionalSkillSet = professionalSkillSet;
  }

  public Set<ProfessionalAssociation> getProfessionalAssociationSet() {
    return professionalAssociationSet;
  }

  public void setProfessionalAssociationSet(Set<ProfessionalAssociation> professionalAssociationSet) {
    this.professionalAssociationSet = professionalAssociationSet;
  }

  public Set<AdviserToEducational> getEducationalSet() {
    return educationalSet;
  }

  public void setEducationalSet(Set<AdviserToEducational> educationalSet) {
    this.educationalSet = educationalSet;
  }
}
