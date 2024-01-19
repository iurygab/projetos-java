package encadeamento;
public class fila{
	
    public tipoNo cabeca, cabeca2, cabeca3;
    int teste = 0;
    
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
        if(cabeca2==null){
            System.out.println("-------- Lista 2 Vazia --------");
        }else{
            tipoNo aux;
            aux = cabeca;

            while(aux.getProx()!=null){
                aux = aux.getProx();
            }

            aux.setProx(cabeca2);
            cabeca2=null;
            System.out.println("--------- Lista Concatenada ---------");
        }
    }

    public void insereAuto(int info, tipoNo cabeca3){
        tipoNo aux,novo;
        novo = new tipoNo();
        novo.setInfo(info);
        novo.setProx(null);

        aux = cabeca3;
        while(aux.getProx()!=null){
            aux = aux.getProx();
        }
        aux.setProx(novo);
    }

    public void criarLista3(){
        tipoNo aux, aux2;
        aux = cabeca;
        aux2 = cabeca2;
        
        cabeca3 = new tipoNo();
        cabeca3.setInfo(aux.getInfo());
        aux = aux.getProx();

        if(cabeca == null || cabeca2 == null){
            if(cabeca == null && cabeca2 == null){
                System.out.println("---------- Listas Vazias ---------");
            }else if(cabeca == null){
                System.out.println("---------- Lista 1 Vazia ---------");
            }else{
                System.out.println("---------- Lista 2 Vazia ---------");
            }
        }

        teste=1;

        while(aux!=null){
            insereAuto(aux.getInfo(), cabeca3);
            aux = aux.getProx();
        }

        while(aux2!=null){
            insereAuto(aux2.getInfo(),cabeca3);
            aux2 = aux2.getProx();
        }

        System.out.println("---------- Lista 3 Criada ---------");
    }

    


    public void menu(){
        int valor,opcao=0;
	System.out.print("\n------------ Menu ------------\n");
	while(opcao!=-1){
            opcao = Input.readInt("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n(3) Remove Inicio \n(4) Remove Fim \n(5) Imprime\n(6) Insere n-esima posicao\n (7) Remove n-esima posicao \n(8) Dividir Lista \n(9) Concatenar Lista \n(10) Criar Lista 3 \n(-1) Sair \nOpcao: ");
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
                
                case 6: //Inserir algum valor escolhido.
                    InsereEnesima();
                break;
                
                case 7: //Remover valor escolhido
                    removeEnesima();
                break;
                
                case 8: // Dividir lista
                    divideLista();
                break;
                
                case 9: //Concatenar as duas listas
                    concatenarLista();
                break;

                case 10: //Criar lista 3
                    criarLista3();

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