package com.versioning;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class ClientForUpdate_2 {
	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate_Ver.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Object o=session.load(ProductVer.class,new Integer(103));
		ProductVer s=(ProductVer)o;

		Transaction tx = session.beginTransaction();	

		s.setPrice(4000); // implicitly update method will be call

		tx.commit();

		System.out.println("Object Updated successfully.....!!");
		session.close();
		factory.close();
	}
}
