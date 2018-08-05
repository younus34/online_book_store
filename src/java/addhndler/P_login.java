package addhndler;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@ManagedBean
@SessionScoped
@Entity
public class P_login implements Serializable {

    @Id
    private int id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkUser() {
        try {
            SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionfactory.openSession();
            Query query = session.createQuery("from Publisher where username=:username and password=:password");
            query.setString("username", username);
            query.setString("password", password);
            //query.executeUpdate();
            List list = query.list();

            if (list.size() >= 1) {
                return "publishers";
            } else {
                return "publisher_Login";
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public P_login() {

    }

}
