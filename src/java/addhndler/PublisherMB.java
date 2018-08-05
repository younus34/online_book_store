
package addhndler;

import dao.AddPublish;
import entity.Publisher;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class PublisherMB {
    Publisher publisher = new Publisher();

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    
    
         public String addPublisher(){
 publisher.setUsername(publisher.getUsername());
 publisher.setPassword(publisher.getPassword());
 publisher.setEmail(publisher.getEmail());
 publisher.setDob(publisher.getDob());
 publisher.setAddress(publisher.getAddress());
 publisher.setMobile(publisher.getMobile());
    
 
            
        if(new AddPublish().addPublisher(publisher)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration successfull", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
       
    
   
    return null;
    
}
     
          public List<Publisher> getAllPublisher(){
        List<Publisher> list = new AddPublish().getAllPublisher();
        return list;
    }
          
          
          
           public void editPublisher(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        int id = Integer.parseInt(request.getParameter("id"));
        
        List<Publisher> list = getAllPublisher();
        for(Publisher p : list){
            if(p.getId() == id){
                publisher.setId(p.getId());
               publisher.setUsername(p.getUsername());
               publisher.setPassword(p.getPassword());
               publisher.setEmail(p.getEmail());
               publisher.setDob(p.getDob());
               publisher.setMobile(p.getMobile());
               publisher.setAddress(p.getAddress());
              
            }
        }
        
    }
           
           
            public void updatePublisher(){
                
                  publisher.setId(publisher.getId());
               publisher.setUsername(publisher.getUsername());
               publisher.setPassword(publisher.getPassword());
               publisher.setEmail(publisher.getEmail());
               publisher.setDob(publisher.getDob());
               publisher.setMobile(publisher.getMobile());
               publisher.setAddress(publisher.getAddress());
       
        
        
        
        
          if(new AddPublish().updatePublisher(publisher)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Update  successfull", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
      
    }
            
             public void deletePublisher(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        int id = Integer.parseInt(request.getParameter("id"));
        
        publisher.setId(id);
        
       
        
          if(new AddPublish().deleteProduct(publisher)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "delete  successfull", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        
        
    }
            
         
         
    
    
    
}

   
