package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dept;
import entity.Emp;

public class ReadDeptDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Dept.class).addAnnotatedClass(Emp.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Dept dept = session.get(Dept.class, 10);
		System.out.println(dept);

		session.getTransaction().commit();

	}

}
