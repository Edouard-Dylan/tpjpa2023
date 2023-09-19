package fr.istic.tpSpring.dao;

import fr.istic.tpSpring.domain.RDV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RDVDao extends JpaRepository<RDV, Long> {

    public RDV findByLibelle(String libelle);

}
