package business;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe que reprsenta um gestor
 *
 * @author Grupo 09
 * @version 202012
 */
public class Gestor {

    private String user;
    private String password;
    private Collection<String> lstGestores;

    public Gestor(String user, String password){
        this.user = user;
        this.password = password;
    }

    private void setUsr(String usr) {
        this.user = usr;
    }
    private void setPass(String pass) {
        this.password = pass;
    }

    public String getUserName(){return user;}
    public String getPassword(){return password;}

    public void removeGestor(String username){this.lstGestores.remove(username);}

    public void solicitaListadeLocalizações(){

    }


}
