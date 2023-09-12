package dao;

import dao.generic.AbstractJpaDao;
import domain.RDV;

public class RDVDao extends AbstractJpaDao {
    public RDVDao() {
        super();
        setClazz(RDV.class);
    }
}
