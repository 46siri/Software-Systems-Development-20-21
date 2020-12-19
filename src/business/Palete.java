package business;

import java.util.Comparator;

public class Palete implements Comparable<Palete> {
    public static Comparator<Palete> NumComparator = Comparator.comparing(Palete::getId);

    private String id;
    private String produto;
    private int altura;
    private Localizacao local;

    /**
     * Construtor com parâmetros para a classe Palete.
     * @param id Id da palete.
     * @param produto Produto que a palete contem.
     * @param altura Altura da palete.
     **/

    public Palete (String id, String produto, int altura, Localizacao local) {
        this.id = id;
        this.produto = produto;
        this.altura = altura;
        this.local = local;
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
     * Método get para a altura da palete.
     */
    public int getAltura(){return altura ;}

    /**
     * Método get para o local da palete.
     */
    public Localizacao getLocalização(){return local;}

    //setters
    /**
     * Método set para o id da palete.
     * @param id Novo id para a palete.
     */
    private void setID(String id){this.id = id;}

    /**
     * Método set para o produto que a palete contem.
     * @param produto produto que a palete contem.
     */
    private void setProduto(String produto){this.produto = produto;}

    /**
     * Método set para a altura da palete.
     * @param altura altura da palete.
     */
    private void setAltura(int altura){this.altura = altura;}

    /**
     * Método set para a altura da palete.
     * @param local local da palete.
     */
    private void setAltura(Localizacao local){this.local = local;}

    /* Seria util na requisicao
    @Override
    public String toString(){return "Palete(" + this.id + ", " + this.produto + ", " + this.altura + ")"; }
     */

    @Override
    public int compareTo(Palete p){return this.id.compareTo(p.getId());}
}