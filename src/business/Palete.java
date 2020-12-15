package business;

import java.util.ArrayList;
import java.util.List;


public class Palete {
    private int id;
    private String produto;
    private int altura;


    /**
     * Construtor sem parâmetros para a classe palete
      */

    public Palete (){
        this.id = -1;
        this.produto = "";
        this.altura = -1;
    }

    /**
     * Construtor com parâmetros para a classe Palete.
     * @param id Id da palete.
     * @param produto Produto que a palete contem.
     * @param altura Altura da palete.
     */

    public Palete (int id, String produto, int altura){
        this.id = id;
        this.produto = produto;
        this.altura = altura;
    }

    /**
     * Método get para o id da palete.
     * @param id Novo id para a palete.
     */

    public int getId(){
        return id;
    }
    /**
     * Método set para o id da palete.
     * @param id Novo id para a palete.
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * Método get para o produto que a palete contem.
     * @param produto produto que a palete contem.
     */
    public String getProduto() {
        return produto;
    }
    /**
     * Método set para o produto que a palete contem.
     * @param produto produto que a palete contem.
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }
    /**
     * Método get para a altura da palete.
     * @param altura altura da palete.
     */
    public int getAltura() {
        return altura;
    }
    /**
     * Método set para a altura da palete.
     * @param altura altura da palete.
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }


}