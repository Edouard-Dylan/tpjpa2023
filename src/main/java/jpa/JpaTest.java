package jpa;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.OrganisateurDao;
import dao.ProfessionnelDao;
import dao.RDVDao;
import dao.generic.EntityManagerHelper;
import domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class JpaTest {
	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction t = manager.getTransaction();
		JpaTest test = new JpaTest(manager);
		t.begin();
		try {
			test.createRDV();
		} catch (Exception e) {
			e.printStackTrace();
		}
		t.commit();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}


	private void listProfessionnels() {
		List<Professionnel> resultList = manager.createQuery("Select a From Professionnel a", Professionnel.class).getResultList();
		System.out.println("Nombre de professionnel:" + resultList.size());
		for (Professionnel next : resultList) {
			System.out.println("Professionnel suivant: " + next);
		}
	}

	private void createRDV(){
		int numOfRDV = manager.createQuery("Select a From RDV a", RDV.class).getResultList().size();
		if (numOfRDV == 0) {
			Professionnel pro1 = new Professionnel("Pro1");
			Professionnel pro2 = new Professionnel("Pro2");
			ArrayList<Professionnel> pros = new ArrayList<Professionnel>();
			pros.add(pro1);
			pros.add(pro2);
			Organisateur orga1 = new Organisateur("Orga1");
			RDV rdv = new RDV(new Timestamp(2023),"Rdv1", orga1, pros);

			manager.persist(pro1);
			manager.persist(pro2);
			manager.persist(orga1);
			manager.persist(rdv);
		}
	}
}
