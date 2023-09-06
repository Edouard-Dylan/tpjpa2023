package domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Organisateur extends Professionnel{

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
    public List<RDV> getRdvOrganise() {
        return rdvOrganise;
    }

    public void setRdvOrganise(List<RDV> rdvOrganise) {
        this.rdvOrganise = rdvOrganise;
    }
}
