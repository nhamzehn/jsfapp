package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dept;
import entity.Emp;

public class CreateDeptDemo {

	public static void main(String[] args) {

		Configuration configuration = new Configuration()
														.configure("hibernate.cfg.xml")
														.addAnnotatedClass(Dept.class)
														.addAnnotatedClass(Emp.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
														
		
		// Create a dept object
		Dept dept = new Dept("TEST", "AMMAN");
		
		// Start transaction
		session.beginTransaction();
		
		// Save the dept
		session.save(dept);
		
		// Commit the transaction
		session.getTransaction().commit();
		
		factory.close();
												
	}

}
