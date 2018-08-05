
package addhndler;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class Login {
    
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String password;
    
    
    public String checkUser() {
      
            
             if(user_name.equals("younus") && password.equals("019")){
    return "Admin_page";
    }else{
    return "login";
    }
       

    
    }
    
    public String logout(){
        try {
            HttpSession session1 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//            session1.setAttribute("uname", "");
//            session1.setAttribute("uid", "");
            session1.invalidate();
            
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/login");
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    

    
    public Login(){
    
    
    }
    
}
