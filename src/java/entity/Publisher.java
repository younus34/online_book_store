package entity;
// Generated Mar 25, 2018 10:53:42 PM by Hibernate Tools 4.3.1





public class Publisher  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;
     private String email;
     private String dob;
     private String address;
     private String mobile;

    public Publisher() {
    }

    public Publisher(String username, String password, String email, String dob, String address, String mobile) {
       this.username = username;
       this.password = password;
       this.email = email;
       this.dob = dob;
       this.address = address;
       this.mobile = mobile;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDob() {
        return this.dob;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }




}


