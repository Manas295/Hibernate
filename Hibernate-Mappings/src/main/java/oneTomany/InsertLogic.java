package oneTomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertLogic {

	public static void main(String args[])
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		//parent object
		Vendor v =new Vendor();

		v.setVendorId(101);
		v.setVendorName("java4s");

		//creating 3 child objects
		Customer c1=new Customer();

		c1.setCustomerId(504);
		c1.setCustomerName("customer4");

		Customer c2=new Customer();

		c2.setCustomerId(505);
		c2.setCustomerName("customer5");

		Customer c3=new Customer();

		c3.setCustomerId(506);
		c3.setCustomerName("customer6");

		// adding child objects to set, as we taken 3rd property set in parent
		Set s=new HashSet();

		s.add(c1);
		s.add(c2);
		s.add(c3);

		v.setChildren(s);

		
		//2nd Vendor
		Vendor v2 =new Vendor();

		v2.setVendorId(100);
		v2.setVendorName("java8");

		//creating 3 child objects
		Customer c4=new Customer();

		c4.setCustomerId(502);
		c4.setCustomerName("customer4");

		Customer c5=new Customer();

		c5.setCustomerId(503);
		c5.setCustomerName("customer5");

		Customer c6=new Customer();

		c6.setCustomerId(501);
		c6.setCustomerName("customer6");

		// adding child objects to set, as we taken 3rd property set in parent
		Set s2=new HashSet();

		s2.add(c4);
		s2.add(c5);
		s2.add(c6);

		v2.setChildren(s2);

		
		
		Transaction tx = session.beginTransaction();

		session.save(v);
		session.save(v2);
		tx.commit();
		session.close();
		System.out.println("One To Many is Done..!!");
		factory.close();

	}
}
