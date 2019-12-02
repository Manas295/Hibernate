package oneTomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteLogic {

public static void main(String args[])
{

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory = cfg.buildSessionFactory();
Session session = factory.openSession();

Object o = session.get(Vendor.class, new Integer(101));
Vendor v = (Vendor)o;

Transaction tx = session.beginTransaction();
session.delete(v);
tx.commit();

session.close();
System.out.println("One To Many is Done for deleting..!!");
factory.close();

}
}