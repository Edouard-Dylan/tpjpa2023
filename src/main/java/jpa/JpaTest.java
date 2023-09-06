package jpa;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			//test.createEmployees();
			//test.listDepartments();
			test.listEmployees();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listEmployees();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}
	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("java");
			manager.persist(department);
			manager.persist(new Employee("Jakab Gipsz", department));
			manager.persist(new Employee("Captain Nemo", department));
		}
	}
	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("Nombre d'employés:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("Employé suivant: " + next);
		}
	}

	private void createDepartment() {
		int numOfDepartment = manager.createQuery("Select d From Department d", Department.class).getResultList().size();
		if (numOfDepartment == 0) {
			manager.persist(new Department("Dep1"));
			manager.persist(new Department("Dep2"));
			manager.persist(new Department("Dep3"));
		}
	}

	private void listDepartments() {
		List<Department> resultList = manager.createQuery("Select a From Department a", Department.class).getResultList();
		System.out.println("Nombre de département:" + resultList.size());
		for (Department next : resultList) {
			System.out.println("Département suivant: " + next);
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
			manager.persist(new Employee("Jakab Gipsz", department));
			manager.persist(new Employee("Captain Nemo", department));
		}
	}

}
