package domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Entity
@XmlRootElement(name = "RDV")
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
    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @ManyToOne
    @XmlElement(name = "organisateur")
    @JsonBackReference
    @XmlTransient
    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

    @XmlElement(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @ManyToMany
    @XmlElementWrapper(name = "pros")
    @XmlElement(name = "pro")
    @JsonBackReference
    @XmlTransient
    public List<Professionnel> getProfs() {
        return profs;
    }

    public void setProfs(List<Professionnel> profs) {
        this.profs = profs;
    }
}
