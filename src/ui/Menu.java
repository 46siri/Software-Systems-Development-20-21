package ui;

import javax.swing.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    //variavel para sopurtar leitura
    private static Scanner is = new Scanner(System.in);
    //variaveis de instancia
    private List<String> opcoes;
    private int op;

    //Constutor para os objetos da classe Menu

    public Menu(String[] opcoes){
        this.opcoes = Arrays.asList(opcoes);
        this.op = 0;
    }

    public void executa(){
        do{
            showMenu();
            this.op = lerOpcao();
        }while(this.op == -1);
    }

    private void showMenu() {
        System.out.println("\n********** MENU **********");
        for(int i = 0; i<this.opcoes.size(); i++){
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.print(this.opcoes.get(i));
        }
        System.out.println("0 - Sair");
    }

    private int lerOpcao(){
        int op;

        System.out.print("Opcao: ");
        try{
            op = is.nextInt();
        }catch(InputMismatchException e){ //nao é incrito nenhum int
            op = -1;
        }
        if(op < 0 || op > this.opcoes.size()){
            System.out.println("Opcao Invalida");
            op = -1;
        }
        return op;
    }

    // Métodod para ober a ultima opcao lida

    public int getOpcao(){
        return this.op;
    }
}
