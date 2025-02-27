package ui;


import java.util.*;

/**
 * Esta classe implementa um menu em modo texto
 *
 * @author GRupo 09
 * @version (202012)
 */

public class Menu {

    //Interfaces auxiliares

    /** Functional interface para handlers. */
    public interface MenuHandler {
        void execute();
    }

    /** Functional interface para pré-condições. */
    public interface MenuPreCondition {
        boolean validate();
    }

    //variavel para sopurtar leitura
    private static Scanner is = new Scanner(System.in);

    //variaveis de instancia
    private List<String> opcoes;
    private List<MenuPreCondition> disponivel;  // Lista de pré-condições
    private List<MenuHandler> handlers;         // Lista de handlers


    /**
     * Constutor para os objetos da classe Menu
     */

    public Menu(String[] opcoes){
        this.opcoes = Arrays.asList(opcoes);
        this.disponivel = new ArrayList<>();
        this.handlers = new ArrayList<>();
        this.opcoes.forEach(s-> {
                        this.disponivel.add(()->true);
                        this.handlers.add(()->System.out.println("\nATENÇÃO: Opção não implementada!"));
        });
    }

    public void run(){
        int op;
        do{
            show();
            op = lerOpcao();
            //testar pré condição
            if(op>0 && !this.disponivel.get(op-1).validate()) {
                System.out.println("Opção indisponivel! Tente novamente");
            }else if(op>0){
                //executar handler
                this.handlers.get(op-1).execute();
            }
        }while(op!=0);

    }

    /**
     * Método que regista uma uma pré-condição numa opção do menu.
     *
     * @param i índice da opção (começa em 1)
     * @param b pré-condição a registar
     */
    public void setPreCondition(int i, MenuPreCondition b) {
        this.disponivel.set(i-1,b);
    }

    /**
     * Método para registar um handler numa opção do menu.
     *
     * @param i indice da opção  (começa em 1)
     * @param h handlers a registar
     */
    public void setHandler(int i, MenuHandler h) {
        this.handlers.set(i-1, h);
    }

    // Métodos auxiliares

    /** Apresentar o menu */
    private void show() {
        System.out.println("\n********** MENU **********");
        System.out.println("\nSelecione o número corresponde à operação que deseja realizar");
        for(int i = 0; i<this.opcoes.size(); i++){
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.println(this.disponivel.get(i).validate()?this.opcoes.get(i):"indisponível");
        }
        System.out.println("0 - Sair");
    }

    private int lerOpcao(){
        int op;
        //Scanner is = new Scanner(System.in);
        System.out.print("Opcao: ");
        try{
            String line = is.nextLine();
            op = Integer.parseInt(line);
        }catch(InputMismatchException e){ //nao é incrito nenhum int
            op = -1;
        }
        if(op < 0 || op > this.opcoes.size()){
            System.out.println("Opção Inválida");
            op = -1;
        }
        return op;
    }
}
