
package addhndler;

import dao.AddPublish;
import dao.AddUser;
import entity.User;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserMB {
    User user= new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String addUser(){
    user.setUsername(user.getUsername());
    user.setPassword(user.getPassword());
   user.setEmail(user.getEmail());
   user.setDob(user.getDob());
   user.setAddress(user.getAddress());
   user.setMobile(user.getMobile());
   
   
   
   if(new AddUser().addUser(user)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration successfull", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
       
    
   
 
    
    return null;
    }
    
    
}
