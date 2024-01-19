/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturas;

/**
 *
 * @author pericles.lopes
 */



public class Programa {
    public static void menu(){    
        System.out.println("\n*** Menu ***");
        System.out.println("1 - Inserir na Fila");
        System.out.println("2 - Remover da Fila");
        System.out.println("3 - Imprimir");
        System.out.println("4 - Remover do final");
        System.out.println("5 - Remover da posicao");
        System.out.println("-1 - Sair\n");
    }
    
    public static void main(String[] args) {
        int opcao=0;
        Fila F = new Fila();
                
        while(opcao != -1){
            menu();
            opcao = Input.readInt("Digite a opcao: ");
            
            switch(opcao){
                case 1: F.insere();
                
                case 2: F.remove();
                
                case 3: F.imprime();
                
                case 4: F.removeFinal();
                
                case 5: F.removePosicao();
                
                case -1: System.out.println("\nSaindo...\n");            
            }            
        }
    }    
    
}
