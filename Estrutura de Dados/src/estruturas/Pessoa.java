/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturas;

/**
 *
 * @author pericles.lopes
 */
public class Pessoa {
    public String nome;
    public int idade;
    public int dia,mes,ano;
    
    public Pessoa(){
        nome  = Input.readString("Digite o nome: ");
        /*idade = Input.readInt("Digite a idade: ");
        dia   = Input.readInt("Digite a dia: ");
        mes   = Input.readInt("Digite a mes: ");
        ano   = Input.readInt("Digite a ano: ");*/
    }
    
    public Pessoa(String nome,int idade, int dia,int mes, int ano){
        this.nome=nome;
        this.idade=idade;
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }
    
    public void imprime(){
        System.out.println("\nNome: "+nome);
        System.out.println("Idade: "+idade);
        System.out.println("Nasc: "+dia+"/"+mes+"/"+ano+"\n");        
    }
    
    public static void main(String args[]){
    
        Pessoa p = new Pessoa();
        p.imprime();
    }
}
