package ui;

import business.*;
import java.util.Scanner;


/**
 * Interface em modo texto.
 * Comunicação com o leitor e os robots
 *
 * @author Grupo 09
 * @version 202012
 */
public class TextUI {

    // model tem a 'lógica de negócio'.
    private ArmazemFacade model;

    //menus da aplicação
    private Menu menu;

    //Scanner para leitura
    private Scanner scin;

    /**
     * Construtor.
     *
     * Cria os menus e a camada de negócio.
     */

    public TextUI(){
        this.model = new ArmazemFacade();
        scin = new Scanner(System.in);
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */

    public void run(){
        System.out.println("Bem vindo ao Sistema e estão do Armazém!");
        this.menuPrincipal();
        System.out.println("Até breve :P");
    }

    //métodos auxiliares - Estados da UI

    /**
     * Estado - Menu Principal
     */

    private void menuPrincipal(){
        Menu menu = new Menu(new String[]{
            "Registo",
            "Descarga",
            "Requisição"
        });

        // Registar pré-condições das transições
        // Registar os handlers
        // Falta handler para opção 2 - "Operações sobre Turmas"

        menu.run();
    }
}
