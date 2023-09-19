package fr.istic.tpSpring.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
public class Professionnel implements Serializable {
    private Long id;

    private String name;

    private List<RDV> rdv = new ArrayList<RDV>();

    public Professionnel() {
    }

    public Professionnel(String name, List<RDV> rdv) {
        this.name = name;
        this.rdv = rdv;
    }

    public Professionnel(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "profs", cascade = CascadeType.PERSIST)
    public List<RDV> getRDV() {
        return rdv;
    }

    public void setRDV(List<RDV> rdv) {
        this.rdv = rdv;
    }

    @Override
    public String toString() {
        return "Professionnel [id=" + id + ", name=" + name + "]";
    }
}
