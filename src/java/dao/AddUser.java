
package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.Hibernate_Util;


public class AddUser {
    public boolean addUser(User us){
        SessionFactory factory= Hibernate_Util.getSessionFactory();
        Session session=factory.openSession();
        session.beginTransaction();
        session.save(us);
        session.getTransaction().commit();
        session.close();
        return true;
    
    }
    
}
