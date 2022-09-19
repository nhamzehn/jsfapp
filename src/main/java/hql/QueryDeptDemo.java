package hql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dept;
import entity.Emp;

public class QueryDeptDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Dept.class).addAnnotatedClass(Emp.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		//List<Dept> deptTable = session.createQuery("from Dept order by id").getResultList();
		List<Dept> deptTable = castList(Dept.class, session.createQuery("from Dept order by id").getResultList());
		
		for (Dept dept : deptTable) {
			System.out.println(dept);
		}
		
		session.getTransaction().commit();

	}
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}

}
