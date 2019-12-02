package com.versioning;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class ClientForSave_1 {
	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate_Ver.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		ProductVer p=new ProductVer(); 

		p.setProductId(103);
		p.setProName("AC");
		p.setPrice(14000);

		Transaction tx = session.beginTransaction();
		session.save(p);
		System.out.println("Object saved successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
	}

}
