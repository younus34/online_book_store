
package dao;

import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.Hibernate_Util;


public class AddDao {
    public boolean addCategory(Category cat){
        SessionFactory factory=Hibernate_Util.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(cat);
        
        session.getTransaction().commit();
        session.close();
      
        
    return true;
    }
    
}
