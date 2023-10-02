package fr.istic.tpSpring.dto;

import fr.istic.tpSpring.domain.Organisateur;
import fr.istic.tpSpring.domain.Professionnel;

import java.util.List;

public class RDVDTO {

    private Long id;

    private Long idOrganisateur;

    public RDVDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOrganisateur() {
        return idOrganisateur;
    }

    public void setIdOrganisateur(Long idOrganisateur) {
        this.idOrganisateur = idOrganisateur;
    }
}
