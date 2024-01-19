public class ex01 {
    public tipoNo cabeca;
    

    public void insereInicio(int info){
        if(cabeca == null){//fila vazia
            tipoNo novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);
            novo.setAnt(null);
            cabeca = novo;
        }else{//caso ja tenha algum numero
            tipoNo novo = new tipoNo();
            novo.setInfo(info);
            novo.setAnt(null);
            cabeca.setAnt(novo);
            novo.setProx(cabeca);
            cabeca = novo;
        }
    }

    public void insereFinal(int info){
        if(cabeca == null){
            tipoNo novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);
            novo.setAnt(null);
            cabeca = novo;
        }else{
            tipoNo aux = cabeca;
            while(aux.getProx()!=null){
                aux = aux.getProx();
            }
            tipoNo novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);
            novo.setAnt(aux);
            aux.setProx(novo);
        }
    }

    public void imprime(){
        tipoNo aux = cabeca;
        System.out.println("\nImpressao: ");
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println("");
    }

    

    public void removerPar(){
        tipoNo aux = cabeca;
        tipoNo aux2 = cabeca;
        int i, cont=1;
        while(aux2.getProx() != null){
            aux2 = aux2.getProx();
            cont++;
        }
        for(i=1;i<=cont;i++){
            if(aux.getInfo() %2 == 0){
                if(cabeca==null){
                System.out.println("Lista vazia!");
                }else if(aux.getAnt()==null && aux.getProx()==null){
                    cabeca=null;
                }else if(aux.getAnt()==null){
                    cabeca = aux.getProx();
                    cabeca.setAnt(null);
                    aux = aux.getProx();
                }else if(i==cont){
                    aux.getAnt().setProx(null);

                }else{
                    aux.getAnt().setProx(aux.getProx());
                    aux = aux.getProx();
                }
            
            }else{
                aux = aux.getProx();
            }     

        }

    
        
    }
    
    public void menu(){
        int valor,opcao=0;
	    System.out.print("\n------------ Menu ------------\n");
	    while(opcao!=-1){
            opcao = Input.readInt("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n(3) Remover Par \n(4) imprime \n(-1) Sair \nOpcao: ");
            switch(opcao){
			
                case 1: //insereInicio
                    valor = Input.readInt("Valor: ");
                    insereInicio(valor);
		        break;
				
		        case 2: //insereFinal
                    valor = Input.readInt("Valor: ");
                    insereFinal(valor);
		        break;

                case 3:
                    removerPar();
                break;

                case 4:
                    imprime();
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
    ex01 fila = new ex01();
	fila.menu();
	System.out.println("\n************ Fim programa ************\n");
    }
}



