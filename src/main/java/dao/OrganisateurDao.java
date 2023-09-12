package dao;

import dao.generic.AbstractJpaDao;
import domain.Organisateur;

public class OrganisateurDao extends AbstractJpaDao {
    public OrganisateurDao() {
        super();
        setClazz(Organisateur.class);
    }
}
