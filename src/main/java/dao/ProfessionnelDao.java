package dao;

import dao.generic.AbstractJpaDao;
import domain.Professionnel;

public class ProfessionnelDao extends AbstractJpaDao {
    public ProfessionnelDao() {
        super();
        setClazz(Professionnel.class);
    }
}
