package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private TreatmentType type;

    // Relacja dwustronna (MedicalTreatmentEntity i VisitEntity są współwłaścicielami relacji)
    @JsonIgnore
    @ManyToMany(mappedBy = "treatments")
    private List<VisitEntity> visits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }

    public List<VisitEntity> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitEntity> visits) {
        this.visits = visits;
    }

}
