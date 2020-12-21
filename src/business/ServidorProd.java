package business;

public class ServidorProd {
    private int id;
    private String nome;
    private int telemovel;
    private String email;

    /**
     * Método get para o id de um Servidor de Produção.
     * @return Id do Servidor de Produção.
     */

    public int getID(){
        return this.id;
    }

    /**
     * Método get para o nome de um Servidor de Produção.
     * @return Nome do Servidor de Produção.
     */

    public String getNome(){
        return this.nome;
    }

    /**
     * Método get para número de telemóvel de um Servidor de Produção.
     * @return Número de telemóvel do Servidor de Produção.
     */

    public int getTelemovel() {
        return this.telemovel;
    }

    /**
     * Método get para o email de um Servidor de Produção.
     * @return Email do Servidor de Produção.
     */

    public String getEmail(){
        return this.email;
    }

    /**
     * Método set para o id de um Servidor de Produção.
     */

    public void setID(int id){
        this.id = id;
    }

    /**
     * Método set para o nome de um Servidor de Produção.
     */

    public void setNome(String n){
        this.nome = n;
    }

    /**
     * Método set para o número de telemóvel de um Servidor de Produção.
     */


    public void setTelemovel(int t){
        this.telemovel = t;
    }

    /**
     * Método set para o email de um Servidor de Produção.
     */

    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Construtor sem parametros de Servidor de Produção.
     */

    public ServidorProd(){
        this.id = -1;
        this.nome = "";
        this.telemovel = -1;
        this.email = "";
    }

    /**
     * Construtor com parametros de Servidor de Produção.
     */

    public Cliente(int id, String nome, int telemovel, String email){
        this.id = id;
        this.nome = nome;
        this.telemovel = telemovel;
        this.email = email;
    }


    public boolean equals(Object o) {
        if(this == o) return true;
        if(o.getClass() != this.getClass()) return false;

        ServidorProd temp = (ServidorProd)o;

        return this.id == temp.getID() &&
                this.nome.equals(temp.getNome()) &&
                this.telemovel == temp.getTelemovel() &&
                this.email.equals(temp.getEmail());
    }

}
