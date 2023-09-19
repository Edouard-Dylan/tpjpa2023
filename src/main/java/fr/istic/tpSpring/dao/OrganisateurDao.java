package fr.istic.tpSpring.dao;

import fr.istic.tpSpring.domain.Organisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrganisateurDao extends JpaRepository<Organisateur, Long> {

    //public Organisateur findByName(Long orgaID);

}
