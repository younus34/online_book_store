
package dao;

import entity.UploadBook;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.Hibernate_Util;


public class Upload {
    
    public boolean uploadbookbs(UploadBook upload){
        SessionFactory factory=Hibernate_Util.getSessionFactory();
        Session session=factory.openSession();
       
        session.beginTransaction();
         session.save(upload);
         session.getTransaction().commit();
        session.close();
    
    return true;
    }
    
    
    
      public boolean updateBook(UploadBook b) {
        try {

            SessionFactory factory = Hibernate_Util.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.update(b);

            session.getTransaction().commit();
            session.close();

            return true;

        } catch (Exception e) {
            return false;
        }

    }
    
      
      
       public boolean deleteBook(UploadBook b) {
        try {

            SessionFactory factory = Hibernate_Util.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(b);

            session.getTransaction().commit();
            session.close();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
      
       
        public static List<UploadBook> getAllBook() {
        SessionFactory factory = Hibernate_Util.getSessionFactory();
        Session session = factory.openSession();
        
        List<UploadBook> list = session.createQuery("SELECT al FROM UploadBook al").list();
        
        list.toString();
        
        session.close();
        
        return list;

    }
    
        
         public static List<UploadBook> getBook(String id) {
        SessionFactory factory = Hibernate_Util.getSessionFactory();
        Session session = factory.openSession();
        
        List<UploadBook> list = session.createQuery("SELECT from UploadBook where lower(id)='"+id.toLowerCase()+"'").list();
        
        list.toString();
        
        session.close();
        
        return list;

    }
       
         
          public static UploadBook findBook(int id){
        SessionFactory factory = Hibernate_Util.getSessionFactory();
        Session session = factory.openSession();
        
        UploadBook b = (UploadBook) session.get(UploadBook.class, id);
        return b;
    }
       
      
      
}
