package crud;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Emp;

public class CreateEmpDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Emp.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		Emp emp = new Emp("HAMZEH", "ANALYST", 1000);
		emp.setManager(7839);
		emp.setCommission(new Double(10));
		emp.setHiredate(new Date());
		//emp.setDeptNumber(20);

		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();

		factory.close();

	}

}
