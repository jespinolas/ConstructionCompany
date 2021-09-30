package py.com.ci.constructioncompany.presentation.web;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import py.com.ci.constructioncompany.user.SystemUser;

/**
 *
 * @author martin
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {
    
    private String user;
    private String password;
    private SystemUser loggedUser;
    
    public String login(){
        System.out.println("Logged User:" + user );
        //@TODO: Loggin Process
        return "home";
    }

    public String getUsername() {
        return user;
    }

    public void setUsername(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SystemUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(SystemUser loggedUser) {
        this.loggedUser = loggedUser;
    }
    
    
}

