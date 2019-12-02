package com.update;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.ProductVer;


public class ClientForUpdate {
	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Object o=session.load(ProductVer.class,new Integer(105));
		ProductVer s=(ProductVer)o;

		Transaction tx = session.beginTransaction();	
		//s.setStno(105);   should not update, because we loaded with that number right..?
		s.setPrice(40000);   // implicitly update method will be called..

		tx.commit();

		System.out.println("Object Updated successfully.....!!");
		session.close();
		factory.close();
	}
}
