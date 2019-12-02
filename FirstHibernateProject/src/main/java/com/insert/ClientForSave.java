package com.insert;
import org.hibernate.*;
import org.hibernate.cfg.*;

import com.model.ProductVer;

public class ClientForSave { 

	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
        // Transient state_____start
		ProductVer p1=new ProductVer();

		p1.setProductId(101);
		p1.setProName("iPhone");
		p1.setPrice(25000);
        // Transient state_____end
		
		// Transient state_____start
		ProductVer p2=new ProductVer();

		p2.setProductId(102);
		p2.setProName("iPad");
		p2.setPrice(45000);
		// Transient state_____end
		
		// Transient state_____start
		ProductVer p3=new ProductVer();

		p3.setProductId(103);
		p3.setProName("MacBook");
		p3.setPrice(125000);
		// Transient state_____end
		
		// Transient state_____start
		ProductVer p4=new ProductVer();

		p4.setProductId(104);
		p4.setProName("AirPods");
		p4.setPrice(25000);
		// Transient state_____end

		// Transient state_____start
		ProductVer p5=new ProductVer();

		p5.setProductId(105);
		p5.setProName("iPadPro");
		p5.setPrice(65000);
		// Transient state_____end
		
		Transaction tx = session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		
		System.out.println("Object saved successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
	}

}