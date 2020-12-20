package business;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe que reprsenta um gestor
 *
 * @author Grupo 09
 * @version 202012
 */
public class Gestor implements Comparable<Gestor> {

    private String user;
    private String password;
    private String nome;
    private String email;
    private Collection<String> lstGestores;

    public Gestor(String user, String password,String nome,String mail){
        this.user = user;
        this.password = password;
        this.nome = nome;
        this.email = mail;
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

    @Override
    public String toString() {
        return "Gestor("+this.user +", "+this.nome+", "+this.email+")";
    }

    @Override
    public int compareTo(Gestor o) {
        return this.user.compareTo(o.getUserName());
    }

}
