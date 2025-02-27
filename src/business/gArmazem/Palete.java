package business.gArmazem;

import java.util.*;

public class Palete implements Comparable<Palete> {
    public static Comparator<Palete> NumComparator = Comparator.comparing(Palete::getId);

    private String id;
    private String produto;
    private int localizacao;

    /**
     * Construtor com parâmetros para a classe Palete.
     * @param id Id da palete.
     * @param produto Produto que a palete contem.
     * @param localizacao Localizacao da palete.
     **/

    public Palete (String id, String produto, int localizacao) {
        this.id = id;
        this.produto = produto;
        this.localizacao = localizacao;
    }

    //getters
    /**
     * Método get para o id da palete.
     * */
    public String getId(){return id;}
    /**
     * Método get para o produto que a palete contem.
     */
    public String getProduto(){return produto;}

    /**
     * Método get para o local da palete.
     */
    public int getLocalizacao(){return localizacao;}

    //setters
    /**
     * Método set para o id da palete.
     * @param id Novo id para a palete.
     */
    public void setId(String id){this.id = id;}

    /**
     * Método set para o produto que a palete contem.
     * @param produto produto que a palete contem.
     */
    public void setProduto(String produto){this.produto = produto;}

    /**
     * Método set para a localizacao da palete.
     * @param localizacao da palete.
     */
    public void setLocalizacao(int localizacao){this.localizacao = localizacao;}

    @Override
    public int compareTo(Palete p) { return this.id.compareTo(p.getId());}

    /* Seria util na requisicao
    @Override
    public String toString(){return "Palete(" + this.id + ", " + this.produto + ", " + this.localizacao + ")"; }
     */

    }