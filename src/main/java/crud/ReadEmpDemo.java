package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dept;
import entity.Emp;

public class ReadEmpDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Emp.class)
				.addAnnotatedClass(Dept.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Emp emp = session.get(Emp.class, 1113);
			System.out.println(emp);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
