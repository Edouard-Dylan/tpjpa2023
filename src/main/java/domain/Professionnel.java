package domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
@XmlRootElement(name = "Professionnel")
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
    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "profs", cascade = CascadeType.PERSIST)
    @XmlElementWrapper(name = "rdvs")
    @XmlElement(name = "rdv")
    @JsonManagedReference
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
