package com.delete;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.ProductVer;


public class ClientForDelete {
	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Object o=session.load(ProductVer.class,new Integer(103));
		ProductVer p=(ProductVer)o;

		Transaction tx = session.beginTransaction();
		session.delete(p);
		System.out.println("Object Deleted successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
	}
}
