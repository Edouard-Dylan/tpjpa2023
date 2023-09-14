package domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement(name = "Organisateur")
public class Organisateur extends Professionnel implements Serializable {

    private List<RDV> rdvOrganise = new ArrayList<RDV>();

    public Organisateur() {
    }

    public Organisateur(String name, List<RDV> rdv) {
        super(name, rdv);
    }

    public Organisateur(String name) {
        super(name);
    }

    @OneToMany(mappedBy = "organisateur", cascade = CascadeType.PERSIST)
    @XmlElementWrapper(name = "rdvsOrganise")
    @XmlElement(name = "rdv")
    //@JsonManagedReference(value = "organisateur-rdv")
    public List<RDV> getRdvOrganise() {
        return rdvOrganise;
    }

    public void setRdvOrganise(List<RDV> rdvOrganise) {
        this.rdvOrganise = rdvOrganise;
    }
}
