package fr.istic.tpSpring.dto;

import fr.istic.tpSpring.domain.RDV;

import java.util.List;

public class OrganisateurDTO {

    private long id;
    private List<Long> rdvs;

    public OrganisateurDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Long> rdvs) {
        this.rdvs = rdvs;
    }
}
