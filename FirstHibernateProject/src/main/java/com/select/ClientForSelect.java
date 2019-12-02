package com.select;
import org.hibernate.*;
import org.hibernate.cfg.*;

import com.model.ProductVer;
public class ClientForSelect {
	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Object o=session.load(ProductVer.class,new Integer(101));
		ProductVer s=(ProductVer)o;
		// For loading Transaction scope is not necessary...
		System.out.println("Loaded object product name is___"+s.getProName());

		System.out.println("Object Loaded successfully.....!!");
		session.close();
		factory.close();
	}
}
