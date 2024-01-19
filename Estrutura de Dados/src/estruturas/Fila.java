/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package estruturas;
/**
 *
 * @author pericles.lopes
 */
public class Fila {
    public Pessoa vPessoa[];
    public int qtdPessoa;
    public Fila(){
        int tam = Input.readInt("Digite o tamanho do vetor: ");
        vPessoa = new Pessoa[tam];
    }
    
    public void insere(){
        if(qtdPessoa<vPessoa.length){
            vPessoa[qtdPessoa++]= new Pessoa();            
            System.out.println("Inserção concluída");
        }
        else
            System.out.println("Vetor sem espaço!");
    }
    
    public void remove(){
        if(qtdPessoa>0){
            for(int i=1;i<qtdPessoa;i++)
                vPessoa[i-1]=vPessoa[i];
            qtdPessoa--;
            System.out.println("Remoção concluída");
        }else{
            System.out.println("Vetor vazio!");
        }
    }
    
    public void removeFinal(){
        if(qtdPessoa>0){            
            qtdPessoa--;
            System.out.println("Remoção concluída");
        }else{
            System.out.println("Vetor vazio!");
        }
    }
    
    public void removePosicao(){
        int pos = Input.readInt("Remover em qual pos? ");
        if(qtdPessoa>0){
            for(int i=pos;i<qtdPessoa;i++)
                vPessoa[i-1]=vPessoa[i];
            qtdPessoa--;
            System.out.println("Remoção concluída");
        }else{
            System.out.println("Vetor vazio!");
        }
    }
    
    public void imprime(){
        for(int i=0;i<qtdPessoa;i++){
            vPessoa[i].imprime();
        }            
    }
}
