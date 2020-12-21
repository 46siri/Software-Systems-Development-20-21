package business;

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
    /**
     * Método get para o username de um gestor.
     * @return user do gestor
     */
    public String getUserName(){
        return user;
    }
    /**
     * Método get para a password de um gestor.
     * @return password do gestor
     */
    public String getPassword(){
        return password;
    }
    /**
     * Método get para o nome de um gestor.
     * @return nome do gestor
     */
    public String getNome(){
        return nome;
    }
    /**
     * Método get para o email de um gestor.
     * @return Email do gestor
     */

    public String getEmail(){
        return this.email;
    }

    /**
     * Método set para o user de um gestor.
     */
    private void setUsr(String usr) {
        this.user = usr;
    }

    /**
     * Método set para a password de um gestor.
     */
    private void setPass(String pass) {
        this.password = pass;
    }
    /**
     * Método set para o mail de um gestor.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Método set para o nome de um gestor.
     */
    public void setNome (String nome){
        this.nome =  nome;
    }


    /**
     * Construtor com parametros de Gestor.
     */
    public Gestor(String user, String nome, String email){
        this.user = user;
        this.nome = nome;
        this.email = email;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o.getClass() != this.getClass()) return false;

        Gestor temp = (Gestor) o;

        return this.user == temp.getUserName() &&
                this.nome.equals(temp.getNome()) &&
                this.email.equals(temp.getEmail());
    }

    public void removeGestor(String username){
        this.lstGestores.remove(username);
    }

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
