package pe.edu.cibertec.proyemp.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pe.edu.cibertec.proyemp.jpa.domain.Departamento;

public class JpaTest {
	
	private EntityManager manager;
	
	// Inyeccion de dependencias con Constructor
	public JpaTest(EntityManager manager){
		this.manager = manager;
	}
	
	public static void main(String[] args) {
		
		// Utilizamos patron factory
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("MyPersistenceUnit1");
	
		// Obtenemos el EntityManager
		EntityManager em = factory.createEntityManager();
		
		
		JpaTest test = new JpaTest(em);
		
		// definimos la transaccion
		EntityTransaction tx = em.getTransaction();
		
		
		tx.begin();
		
			// insert, update y delete
			test.crearEmpleados();
			
		tx.commit();
		
	}

	private void crearEmpleados() {
		Departamento lima = new Departamento();
		lima.setNombre("Lima");
		
		manager.persist(lima);
	}
	

}
