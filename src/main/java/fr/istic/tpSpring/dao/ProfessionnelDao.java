package fr.istic.tpSpring.dao;

import fr.istic.tpSpring.domain.Professionnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionnelDao extends JpaRepository<Professionnel, Long> {

    public Professionnel findByName(String name);

}
