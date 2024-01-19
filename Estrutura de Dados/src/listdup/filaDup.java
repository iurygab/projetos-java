package listdup;
public class filaDup{
	
    public tipoNoDup cabeca;
    filaDup(){
        System.out.println("Criando fila...(construtor fila)");
    }
	
    
    public void insereInicio(int info){
       tipoNoDup novo = new tipoNoDup();
       novo.setInfo(info);
       novo.setProx(cabeca);
       novo.setAnt(null);
       cabeca = novo;
    }
    public void insereFinal(int info){
        
        if(cabeca == null){ //lista vazia
            tipoNoDup novo = new tipoNoDup();
            novo.setInfo(info);
            novo.setProx(null);
            novo.setAnt(null);
            cabeca = novo;
        }else{
            tipoNoDup aux = cabeca;
            
            while(aux.getProx() != null){
                aux = aux.getProx();
            }
            
            tipoNoDup novo = new tipoNoDup();
            novo.setInfo(info);
            novo.setProx(null);
            novo.setAnt(aux);
            aux.setProx(novo);
        }
    }
	
    
	
    public void removeInicio(){
        if(cabeca != null){
            int valor = cabeca.getInfo();
            System.out.println("Elemento "+valor+" foi removido!");
            cabeca=cabeca.getProx();
        }
    }
    
    public void removeFinal(){
        
        
    }
	
    public void imprime(){
        tipoNoDup aux = cabeca;
        while(aux!=null){
            System.out.print(" "+aux.getInfo());
            aux = aux.getProx();
        }
    }
	
    public void divideLista(){
        
    }
    
    public void setCabeca(tipoNoDup aux){
        cabeca = aux;
    }
    public void menu(){
        int valor,opcao=0;
	System.out.print("\n------------ Menu ------------\n");
	while(opcao!=-1){
            opcao = Input.readInt("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n(3) Remove Inicio \n(4) Remove Fim \n(5) Imprime\n(6) Imprime Terceiro\n(7) Divide Lista\n(-1) Sair \nOpcao: ");
            switch(opcao){
			
                case 1: //insereInicio
                    valor = Input.readInt("Valor: ");
                    insereInicio(valor);
		break;
				
		case 2: //insereFinal
                    valor = Input.readInt("Valor: ");
                    insereFinal(valor);
		break;
				
		case 3: //removeInicio
                    removeInicio();
		break;
				
                case 4: //removeFinal
                    removeFinal();
		break;
				
		case 5: //imprime
                    imprime();
		break;
			
                case 7:
                    divideLista();
                break;
		case -1: //sair
                    System.out.println("Saindo!");
		break;
				
		default:
                    System.out.println("Opcao invalida!");
		break;
			
            }
		
	}
    }

    public static void main(String args[]){
        System.out.println("\n************ Lista Dup. Encadeada Din�mica ************\n");
	filaDup F = new filaDup();
	F.menu();
	System.out.println("\n************ Fim programa ************\n");
    }
}