
package dao;

import entity.Publisher;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.Hibernate_Util;

/**
 *
 * @author Younus
 */
public class AddPublish {
    
    
    public boolean addPublisher(Publisher publish){
      SessionFactory factory=Hibernate_Util.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(publish);
        
        session.getTransaction().commit();
        session.close();
      
        
    
    
    return true;
    
    }
    
    
    
    
     public boolean updatePublisher(Publisher p) {
        try {

            SessionFactory factory = Hibernate_Util.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.update(p);

            session.getTransaction().commit();
            session.close();

            return true;

        } catch (Exception e) {
            return false;
        }

    }
     
     
     
     
     public boolean deleteProduct(Publisher p) {
        try {

            SessionFactory factory = Hibernate_Util.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(p);

            session.getTransaction().commit();
            session.close();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
    
    
    
    public static List<Publisher> getAllPublisher() {
        SessionFactory factory = Hibernate_Util.getSessionFactory();
        Session session = factory.openSession();
        
        List<Publisher> list = session.createQuery("SELECT al FROM Publisher al").list();
        
        list.toString();
        
        session.close();
        
        return list;

    }
    
    
    
     public static List<Publisher> getPublisher(String id) {
        SessionFactory factory = Hibernate_Util.getSessionFactory();
        Session session = factory.openSession();
        
        List<Publisher> list = session.createQuery("SELECT from Publisher where lower(id)='"+id.toLowerCase()+"'").list();
        
        list.toString();
        
        session.close();
        
        return list;

    }
    
     
     
     
      public static Publisher findPublisher(int id){
        SessionFactory factory = Hibernate_Util.getSessionFactory();
        Session session = factory.openSession();
        
        Publisher p = (Publisher) session.get(Publisher.class, id);
        return p;
    }
    
}
