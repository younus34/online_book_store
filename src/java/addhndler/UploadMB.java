
package addhndler;


import dao.Upload;
import entity.UploadBook;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;


import org.primefaces.model.UploadedFile;


@ManagedBean
@SessionScoped
public class UploadMB {
    UploadBook uploadbook=new UploadBook();
    UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadBook getUploadbook() {
        return uploadbook;
    }

    public void setUploadbook(UploadBook uploadbook) {
        this.uploadbook = uploadbook;
    }
    
    public String addbook(){
        
        upload();
        uploadbook.setBookname(uploadbook.getBookname());
        uploadbook.setDescription(uploadbook.getDescription());
        uploadbook.setPublishername(uploadbook.getPublishername());
        uploadbook.setPublishdate(uploadbook.getPublishdate());
       
        uploadbook.setSelectbook(uploadbook.getSelectbook());
        
         boolean status = new Upload().uploadbookbs(uploadbook);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data saved", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data NOT saved", ""));
        }
        return null;
        
       
        
        
    
    }
    
    
     public void upload() {
        if (file != null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletcontext = (ServletContext) context.getExternalContext().getContext();
                String dbpath = servletcontext.getRealPath("/");
                String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
                String mainURLPath = buildcut.substring(0, buildcut.lastIndexOf("\\"));
                InputStream inputStrim = file.getInputstream();
                String path = mainURLPath + "\\exam_book_56\\web\\resources\\images\\" + file.getFileName();
                System.out.println(file.getFileName());
                File destFile = new File(path);
                if (!destFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputStrim, destFile);

                }
                uploadbook.setSelectbook(file.getFileName().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    
     
     
      public List<UploadBook> getAllBook(){
        List<UploadBook> list = new Upload().getAllBook();
        return list;
    }
          
      public void editBook(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        int id = Integer.parseInt(request.getParameter("id"));
        
        List<UploadBook> list = getAllBook();
        for(UploadBook b : list){
            if(b.getId() == id){
               uploadbook.setId(b.getId());
               uploadbook.setBookname(b.getBookname());
               uploadbook.setDescription(b.getDescription());
               uploadbook.setPublishername(b.getPublishername());
               uploadbook.setPublishdate(b.getPublishdate());
               uploadbook.setSelectbook(b.getSelectbook());
              
            }
        }
        
    }
     
      
      
      
      
       public void updateBook(){
                
                   uploadbook.setId(uploadbook.getId());
               uploadbook.setBookname(uploadbook.getBookname());
               uploadbook.setDescription(uploadbook.getDescription());
               uploadbook.setPublishername(uploadbook.getPublishername());
               uploadbook.setPublishdate(uploadbook.getPublishdate());
               uploadbook.setSelectbook(uploadbook.getSelectbook());
        
        
        
        
          if(new Upload().updateBook(uploadbook)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Update  successfull", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
      
    }
       
       
       
       
        public void deleteBook(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        int id = Integer.parseInt(request.getParameter("id"));
        
        uploadbook.setId(id);
        
       
        
          if(new Upload().deleteBook(uploadbook)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "delete  successfull", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        
        
    }
     
     
    
    
    
}
