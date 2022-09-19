package hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dept;
import entity.Emp;

public class DeleteDeptDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Dept.class).addAnnotatedClass(Emp.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		//List<Dept> deptTable = session.createQuery("from Dept order by id").getResultList();
		int rownum = session.createQuery("delete from Dept where id = 51").executeUpdate();
		System.out.println(rownum + " row deleted");
		session.getTransaction().commit();

	}

}
