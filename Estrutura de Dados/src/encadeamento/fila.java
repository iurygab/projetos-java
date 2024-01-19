package encadeamento;
public class fila{
	
    public tipoNo cabeca;
    fila(){
        System.out.println("Criando fila...(construtor fila)");
    }
	
    
    public void insereInicio(int info){
        tipoNo novo;
        novo = new tipoNo();
        novo.setInfo(info);
        novo.setProx(cabeca);
        cabeca=novo;
    }
    public void insereFinal(int info){
        if(cabeca == null){
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(null);
        }else{
            tipoNo aux,novo;
			
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);

            aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novo);
	}
		
		System.out.println("Elemento "+info+" inserido com sucesso! ");
    }
	
    public void InsereEnesima(){
        int pos, elem;
        pos = Input.readInt("Digite a posicao: ");
        elem = Input.readInt("Digite o valor: ");
        
        //caso em que nao existe elemento na lista
        if(pos==1){
            insereInicio(elem);
        }else{
            int cont=1;
            tipoNo aux=cabeca;
            while(cont != pos-1){
                aux=aux.getProx();
                cont++;
            }
            
            tipoNo novo;
            novo = new tipoNo();
            novo.setInfo(elem);
            novo.setProx(aux.getProx());
            aux.setProx(novo);
        
        } 
    }
	
    public void removeInicio(){
        if(cabeca!=null){
            int valor=cabeca.getInfo();
            System.out.println("Elemento "+valor+" removido com sucesso! ");
            cabeca=cabeca.getProx();
	}
    }
    
    public void removeFinal(){
        tipoNo aux=cabeca;
        
        if(aux==null){ //nao ha elemento
            System.out.println("Fila Vazia!");
        }else if(aux.getProx()==null){//um elemento
            cabeca=null; 
        }else{//mais de um elemento na fila
            while (aux.getProx().getProx() != null) 
                aux = aux.getProx();
            
            aux.setProx(null);
        }
        
    }
	
    public void imprime(){
        tipoNo aux = cabeca;
        System.out.println("Impressao: ");
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println("");
    }
    
    public void removeEnesima(){
        
        int pos;
        pos = Input.readInt("Digite a posicao: ");
        
        //caso 1: lista vazia
        if(cabeca == null){
            System.out.println("Não há elemento a ser removido!");
        }else{ //eu sei que a lista n esta vazia!
            
            //caso 2: remover o primeiro elemento
            if(pos == 1){
                removeInicio();
            }else{ //caso 3: remover pra frente do primeiro
                int cont=1;
                tipoNo aux=cabeca;
                while(cont != pos-1){
                    aux=aux.getProx();
                    cont++;
                }
                aux.setProx(aux.getProx().getProx());
            }
        }
    }

    public void divideLista(){
        int pos, cont = 1;
        tipoNo aux;
        pos = Input.readInt("A partir de qual posicao");
        
        aux = cabeca;
        while(cont != pos){
            cont++;
            aux=aux.getProx();
        }
        
        fila F2 = new fila();
        F2.setCabeca(aux.getProx());
        aux.setProx(null);
        this.imprime();
        F2.imprime();
    }
    
    public void setCabeca(tipoNo aux){
        cabeca = aux;
    }
    
    public void concatenarLista(){
        
    }
    public void menu(){
        int valor,opcao=0;
	System.out.print("\n------------ Menu ------------\n");
	while(opcao!=-1){
            opcao = Input.readInt("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n(3) Remove Inicio \n(4) Remove Fim \n(5) Imprime\n(6) Insere n-esima posicao\n (7) Remove n-esima posicao \n(-1) Sair \nOpcao: ");
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
                
                case 6:
                    InsereEnesima();
                break;
                
                case 7:
                    removeEnesima();
                break;
                
                case 8:
                    divideLista();
                break;
                
                case 9:
                    concatenarLista();
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
        System.out.println("\n************ Lista Encadeada Din�mica ************\n");
	fila F = new fila();
	F.menu();
	System.out.println("\n************ Fim programa ************\n");
    }
}