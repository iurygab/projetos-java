package buscaBinaria;

import java.util.Scanner;

public class binaria {
    
    public Arvore raiz;
    boolean test = true;
    Scanner leitor = new Scanner(System.in); 
    
 
    public void adicionar(int valor, Arvore atual){
        if(raiz==null){
            raiz = new Arvore(valor);
        }else{
            if(valor<atual.getInfo()){//se for menor
                if(atual.getEsq()!=null){
                    adicionar(valor,atual.getEsq());
                }else{
                    atual.setEsq(new Arvore(valor));
                }
            }else if(valor>atual.getInfo()){//se for maior
                if(atual.getDir()!=null){
                    adicionar(valor,atual.getDir());
                        
                }else{
                    atual.setDir(new Arvore(valor));
                }
            }else{//se o valor ja existe
                System.out.println("=== Valor já existente! ===");
            }
        }
    }        

    public void buscar(Arvore n, int valorBuscado){
        if(n!=null){
            if(valorBuscado == n.getInfo()){
                System.out.println("VALOR ENCONTRADO!!");
            }else if(valorBuscado < n.getInfo()){
                buscar(n.getEsq(), valorBuscado);
            }else if(valorBuscado > n.getInfo()){
                buscar(n.getDir(), valorBuscado);
            }
        }else{
            System.out.println("VALOR NÃO ENCONTRADO :(");
        }
    }

    public boolean remover(int valor){
        Arvore atual = this.raiz;
        Arvore paiAtual = null;;
        while(atual!=null){
            if(atual.getInfo()==valor){
                break;
            }else if(valor<atual.getInfo()){//valor menor que o atual
                paiAtual = atual;
                atual = atual.getEsq();
            }else{//valor maior que o atual
                paiAtual = atual;
                atual = atual.getDir();
            }
        }
        //verficica se existe o elemento
        if(atual!=null){
            
            if(atual.getDir()!=null){//tem 2 filhos ou filho só a direita
                Arvore sub = atual.getDir();
                Arvore paiSub = atual;
                while(sub.getEsq()!=null){
                    paiSub = sub;   
                    sub = sub.getEsq();
                }
                if(paiAtual!=null){
                    if(atual.getInfo()<paiAtual.getInfo()){
                        paiAtual.setEsq(sub);
                    }else{
                        paiAtual.setDir(sub);
                    } 
                }else{//se não tem paiAtual, logo é a raíz
                    this.raiz = sub;    
                } 
                
                //removeu o elemento da arvore
                if(sub.getInfo()<paiSub.getInfo()){
                    paiSub.setEsq(null);
                    System.out.println("---- Valor removido com sucesso! ----");
                }else if(sub.getInfo()>paiSub.getInfo()){
                    paiSub.setDir(null);
                    System.out.println("---- Valor removido com sucesso! ----");
                }else{
                    System.out.println("Valor inexistente.");
                }

            }else if(atual.getEsq()!=null){//tem filho só a esquerda
                Arvore sub = atual.getEsq();
                Arvore paiSub = atual;
                while(sub.getDir()!=null){
                    paiSub = sub;   
                    sub = sub.getDir();
                }
                if(paiAtual!=null){
                    if(atual.getInfo()<paiAtual.getInfo()){
                        paiAtual.setEsq(sub);
                    }else{
                        paiAtual.setDir(sub);
                    }   
                }else{//se for a raiz
                    this.raiz = sub;
                    
                }
                
                //removeu o elemento da arvore
                if(sub.getInfo()<paiSub.getInfo()){
                    paiSub.setEsq(null);
                    System.out.println("---- Valor removido com sucesso! ----");
                }else if(sub.getInfo()>paiSub.getInfo()){
                    paiSub.setDir(null);
                    System.out.println("---- Valor removido com sucesso! ----");
                }else{
                    System.out.println("Valor inexistente.");
                }

            }else{//não tem filho
                if(paiAtual !=null){
                    if(atual.getInfo()<paiAtual.getInfo()){
                        paiAtual.setEsq(null);
                        System.out.println("---- Valor removido com sucesso! ----");
                    }else{
                        paiAtual.setDir(null);
                        System.out.println("---- Valor removido com sucesso! ----");
                    }
                }else{//raiz
                    this.raiz = null;
                    System.out.println("---- Valor removido com sucesso! ----");   
                }
            }
            return true;
        }else{
            return false;

        }

    }

    public void imprime(Arvore atual){
        if(atual!=null){
            imprime(atual.getEsq());
            System.out.println(atual.getInfo()+" ");
            imprime(atual.getDir());
        }

    }

    public void menu(){
		int op=0, val;
		while(op!=-1){
			System.out.println("\n----------------------- MENU ---------------------");
            System.out.println("(1)Inserir \n(2)Buscar \n(3)Remover \n(4)Imprimir \n(-1) Sair");
            System.out.print("Digite a Opção: ");
			op = leitor.nextInt();
            switch(op){		
				//inserção
				case 1: 										
					System.out.print("\nDigite o valor a ser inserido na arvore: ");
					val = leitor.nextInt();
                    adicionar(val, raiz);
				break;

				//busca
				case 2:
                    System.out.print("\nDigite o valor a ser buscado: ");
                    val = leitor.nextInt();
                    buscar(raiz, val); 										
				break;
				
				//remoção
				case 3:	
                    System.out.print("Digite o valor para ser removido: ");	
                    val = leitor.nextInt();
                    remover(val);	
				break;

                case 4:
                    imprime(raiz);
                break;
				
				case -1:
					System.out.println("Saindo...");
				break;
				
				default:				
					System.out.println("Opcao invalida!");
					
			}
		}
	}


    
    public static void main(String args[]){
        binaria arvore;
        arvore = new binaria();
        arvore.menu();
    }
}
