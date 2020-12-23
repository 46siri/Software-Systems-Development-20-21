package ui;

import business.*;
import business.gArmazem.Palete;
import business.gConta.Gestor;
import business.gConta.Robot;

import java.sql.SQLException;
import java.util.Scanner;


/**
 * Interface em modo texto.
 * Comunicação com o leitor e os robots
 *
 * @author Grupo09
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

    public TextUI() throws SQLException {
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
        //menu.setPreCondition(4,()->this.model.haPrateleirasLivres());
        //menu.setPreCondition(5,()->this.model.haPaletes() && this.model.haPrateleriasOcupadas);


        // Registar os handlers
        menu.setHandler(1,()->gestaoDeRobots());
        menu.setHandler(2,()->gestaoDeGestores());
        menu.setHandler(3,()->gestaoDeDescargas());
        //menu.setHandler(4,()->gestaoDeRequisicoes());

        // Falta handler para opção 2 - "Operações sobre Turmas"

        menu.run();
    }

    /**
     *  Estado - Gestão de Robots
     */
    private void gestaoDeRobots(){
        Menu menu = new Menu(new String[]{
                "Adicionar Robot",
                "Listar Robots",
                "Remover Robot"
        });

        menu.setHandler(1,()->adicionarRobot());
        menu.setHandler(2,()->listarRobots());
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
            if (!this.model.existeRobot(id)){
                this.model.adicionaRobot(new Robot());
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
     *  Estado - Listar Robots
     */
    private void listarRobots() {
        try {
            ;
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
                System.out.println("Robot removido");
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
        menu.setHandler(4,()->removerGestor());

        menu.run();
    }

    /**
     *  Estado - Adicionar Gestor
     */
    private void adicionarGestor() {
        try {
            int i=0;
            while(i!=1) {
                System.out.println("Username: ");
                String username = scin.nextLine();
                if (!this.model.existeGestor(username)) {
                    System.out.println("Nome pŕopiro: ");
                    String nome = scin.nextLine();
                    System.out.println("email: ");
                    String email = scin.nextLine();
                    System.out.println("Password: ");
                    String password = scin.nextLine();
                    this.model.adicionaGestor(new Gestor(username, password,nome,email));
                    System.out.println("Gestor adicionado");
                    i=1;
                } else {
                    System.out.println("Esse username já existe!");
                }
            }
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Estado - Consultar Gestor
     */
    private void consultarGestor() {
        try {
            System.out.println("Username a consultar: ");
            String username = scin.nextLine();
            if (this.model.existeGestor(username)) {
                System.out.println(this.model.procuraGestor(username).toString());
            } else {
                System.out.println("Esse username de gestor não existe!");
            }
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Estado - Listar Gestores
     */
    private void listarGestores() {
        try {
            System.out.println(this.model.getGestores().toString());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerGestor(){
        try {
            System.out.println("Username do gestor ");
            String rid = scin.nextLine();
            if (this.model.existeRobot(rid)) {
                this.model.removeRobot(rid);
                System.out.println("Gestor removido");
            } else {
                System.out.println("Esse id de robot não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }


    private void gestaoDeDescargas() {
        Menu menu = new Menu(new String[]{
                "Adicionar Palete",
                "Consultar lista de localizações"
        });

        // Registar os handlers
        menu.setHandler(1, () -> adicionarPalete());
        menu.setHandler(2, () -> consultarLstLocalizacoes());

        menu.run();
    }

    /**
     *  Estado - Adicionar Palete
     */
    private void adicionarPalete(){
        try {
            System.out.println("Id da palete: ");
            String id = scin.nextLine();
            if (!this.model.existePalete(id)) {
                System.out.println("Produto da palete: ");
                String produto = scin.nextLine();
                this.model.adicionaPalete(new Palete(id, produto,0));
                System.out.println("Palete adicionada e colocada a armazenar");
                this.model.armazenarPalete(id);
            } else {
                System.out.println("Esse id de palete já existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Estado - Consultar Gestor
     */
    private void consultarLstLocalizacoes() {
        try {
            System.out.println("Para consultar a Lista precisa de se autenticar.");
            System.out.println("Username: ");
            String username = scin.nextLine();
            if (this.model.existeGestor(username)) {
                int i=1;
                while(i==1) {
                    System.out.println("Password: ");
                    String password = scin.nextLine();
                    if (this.model.passwordCerta(username,password)) {
                        this.model.listarLocalizacoes();
                        i = 0;
                    } else {
                        System.out.println("Password errada");
                    }
                }
            } else {
                System.out.println("Esse username de gestor não existe!");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
