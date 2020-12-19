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
            "Operações sobre Robots",
            "Operações sobre Gestores",
            "Descarga",
            "Requisição"
        });

        // Registar pré-condições das transições
        menu.setPreCondition(4,()->this.model.haPrateleirasLivres());
        menu.setPreCondition(5,()->this.model.haPaletes() && this.model.haPrateleriasOcupadas);


        // Registar os handlers
        menu.setHandler(1,()->gestaoDeRobots());
        menu.setHandler(2,()->gestaoDeGestores());
        menu.setHandler(3,()->gestaoDeDescargas());
        menu.setHandler(4,()->gestaoDeRequisicoes());

        // Falta handler para opção 2 - "Operações sobre Turmas"

        menu.run();
    }

    /**
     *  Estado - Gestão de Robots
     */
    private void gestaoDeRobots(){
        Menu menu = new Menu(new String[]{
                "Adicionar Robot",
                "Consultar Robot",
                "Listar Robots",
                "Remover Robot"
        });

        menu.setHandler(1,()->adicionarRobot());
        menu.setHandler(2,()->consultarRobot());
        menu.setHandler(3,()->listarRobots());
        menu.setHandler(3,()->removerRobot());
        menu.run();
    }

    /**
     *  Estado - Adicionar Robot
     */
    private void adicionarRobot() {
        try {
            System.out.println("Id do Robot: ");
            String id = scin.nextLine();
            if (!this.model.existeRobot(id)) {
                this.model.adicionaRobot(new Robot(id,true));
                System.out.println("Robot adicionado");
            } else {
                System.out.println("Esse id de robot já existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Estado - Consultar Robot
     */
    private void consultarRobot() {
        try {
            System.out.println("Id a consultar: ");
            String id = scin.nextLine();
            if (this.model.existeRobot(id)) {
                System.out.println(this.model.procuraRobot(id).toString());
            } else {
                System.out.println("Esse id de Robot não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Estado - Listar Robots
     */
    private void listarRobots() {
        try {
            System.out.println(this.model.getRobots().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerRobot(){
        try {
            System.out.println("Id do robot: ");
            String rid = scin.nextLine();
            if (this.model.existeRobot(rid)) {
                this.model.removeRobot(rid);
                System.out.println("Robot removido da turma");
            } else {
                System.out.println("Esse id de robot não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     *  Estado - Gestão de Gestores
     */
    private void gestaoDeGestores(){
        Menu menu = new Menu(new String[]{
                "Adicionar Gestor",
                "Consultar Gestor",
                "Listar Gestor",
                "Remover Gestor"
        });

        menu.setHandler(1,()->adicionarGestor());
        menu.setHandler(2,()->consultarGestor());
        menu.setHandler(3,()->listarGestores());

        menu.run();
    }


}
