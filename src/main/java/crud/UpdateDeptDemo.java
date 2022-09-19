package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dept;

public class UpdateDeptDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Dept.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		Dept dept = session.get(Dept.class, 50);
		dept.setName("DEVELOPMENT");
		dept.setLocation("JORDAN");
		session.getTransaction().commit();
		
		factory.close();

	}

}
