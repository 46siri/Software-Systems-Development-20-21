package business.gConta;
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

    /**
     * Construtor sem parametros da class Gestor
     */
    public Gestor(){
        this.user = "";
        this.password = "";
        this.nome = "";
        this.email = "";
    }

    /**
     * Construtor com parametros da class Gestor
     * @param user  UserName do Gestor.
     * @param nome Nome do Gestor.
     * @param password Password do Gestor.
     * @param email Email do Gestor.
     */
    public Gestor(String user, String nome, String password, String email){
        this.user = user;
        this.nome = nome;
        this.password = password;
        this.email= email;
    }

    public String getUserName(){return user;}
    public String getPassword(){return password;}
    public String getNome(){return nome;}
    public String getEmail(){return email;}

    private void setUsr(String usr) {
        this.user = usr;
    }
    private void setPass(String pass) {
        this.password = pass;
    }

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
