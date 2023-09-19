package fr.istic.tpSpring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
@Entity
public class RDV implements Serializable {

    private Long id;

    private Timestamp date;

    private String libelle;

    private List<Professionnel> profs;

    private Organisateur organisateur;

    public RDV(){
    }

    public RDV(Timestamp date, String libelle, Organisateur organisateur){
        this.date = date;
        this.libelle = libelle;
        this.organisateur = organisateur;
    }

    public RDV(Timestamp date, String libelle, Organisateur organisateur, List<Professionnel> professionnels){
        this.date = date;
        this.libelle = libelle;
        this.organisateur = organisateur;
        this.profs = professionnels;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @ManyToOne
    @JsonIgnore
    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @ManyToMany
    @JsonIgnore
    public List<Professionnel> getProfs() {
        return profs;
    }

    public void setProfs(List<Professionnel> profs) {
        this.profs = profs;
    }
}
