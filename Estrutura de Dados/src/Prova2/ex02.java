public class ex02 {
    tipoNo cabeca, cabeca2;

    public void insereInicio(int info) {
        if (cabeca == null) {// fila vazia
            tipoNo novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);
            novo.setAnt(null);
            cabeca = novo;
        } else {// caso ja tenha algum numero
            tipoNo novo = new tipoNo();
            novo.setInfo(info);
            novo.setAnt(null);
            cabeca.setAnt(novo);
            novo.setProx(cabeca);
            cabeca = novo;
        }

    }

    public void insereFinal(int info) {
        if (cabeca == null) {
            tipoNo novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);
            novo.setAnt(null);
            cabeca = novo;
        } else {
            tipoNo aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            tipoNo novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);
            novo.setAnt(aux);
            aux.setProx(novo);
        }

    }

    private int getTamanhoNo(tipoNo cabeca) {
        if (cabeca != null) {
            tipoNo aux;
            int cont = 0;
            aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
                cont++;
            }
            cont++;
            return cont;
        } else {
            return 0;
        }
    }

    private boolean veri(tipoNo cabeca){
        boolean verificador = false;
        tipoNo aux = cabeca;
        int tamanho1 = getTamanhoNo(cabeca);
        for (int i = 0; i < tamanho1; i++) {
            for(int j = i+1; j<tamanho1; j++){
                if(aux.getInfo()>aux.getProx().getInfo()){
                    verificador = true;
                }
            }
                
        }
        return verificador;

    }

    private boolean veri2(tipoNo cabeca2){
        
        boolean verificador = false;
        tipoNo aux2 = cabeca2;
        int tamanho2 = getTamanhoNo(cabeca2);
        for (int i = 0; i < tamanho2; i++) {
            for(int j = i+1; j<tamanho2; j++){
                if(aux2.getInfo()>aux2.getProx().getInfo()){
                    verificador = true;
                }
            }
                
        }
        return verificador;

    }

    
    
 

    private void ordenarN() {
       
        tipoNo aux = cabeca;
        int temp, tamanho1 = getTamanhoNo(cabeca);
        for (int i = 0; i < tamanho1; i++) {
            aux = cabeca;
            for(int j = 0; j<tamanho1; j++){
               if(aux.getProx() != null){

                   if(aux.getInfo()>aux.getProx().getInfo()){
                       temp = aux.getInfo();
                       aux.setInfo(aux.getProx().getInfo());
                       aux.getProx().setInfo(temp);
                       aux = aux.getProx();
                   }else{
                       aux = aux.getProx();
                   }
               }
            }
                
        }
    }

    private void ordenarN2() {
        tipoNo aux2 = cabeca2;
        int temp, tamanho2 = getTamanhoNo(cabeca2);
        for (int i = 0; i <tamanho2; i++) {
            aux2 = cabeca2;
            for(int j = 0; j<tamanho2; j++){
                if(aux2.getProx()!= null){
                    if(aux2.getInfo()>aux2.getProx().getInfo()){
                        temp = aux2.getInfo();
                        aux2.setInfo(aux2.getProx().getInfo());
                        aux2.getProx().setInfo(temp);
                        aux2 = aux2.getProx();
                    }else{
                        aux2 = aux2.getProx();
                    }

                } 
            }
        }
    }   

    public void insereInicio2(int info2) {
        if (cabeca2 == null) {// fila vazia
            tipoNo novo2 = new tipoNo();
            novo2.setInfo(info2);
            novo2.setProx(null);
            novo2.setAnt(null);
            cabeca2 = novo2;
        } else {// caso ja tenha algum numero
            tipoNo novo2 = new tipoNo();
            novo2.setInfo(info2);
            novo2.setAnt(null);
            cabeca.setAnt(novo2);
            novo2.setProx(cabeca2);
            cabeca2 = novo2;
        }
    }

    public void insereFinal2(int info2) {
        if (cabeca2 == null) {
            tipoNo novo2 = new tipoNo();
            novo2.setInfo(info2);
            novo2.setProx(null);
            novo2.setAnt(null);
            cabeca2 = novo2;
        } else {
            tipoNo aux2 = cabeca2;
            while (aux2.getProx() != null) {
                aux2 = aux2.getProx();
            }
            tipoNo novo2 = new tipoNo();
            novo2.setInfo(info2);
            novo2.setProx(null);
            novo2.setAnt(aux2);
            aux2.setProx(novo2);
        }
    }

    public void imprime() {
        tipoNo aux = cabeca;
        System.out.println("\n----- Impressao Lista 1 -----");
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        if(veri(cabeca)){
            System.out.println("\nA LISTA NÃO ESTÁ ORDENADA");
        }
        System.out.println("");
        
        tipoNo aux2 = cabeca2;
        System.out.println("\n----- Impressao Lista 2 ------");
        while (aux2 != null) {
            System.out.print(aux2.getInfo() + " ");
            aux2 = aux2.getProx();
        }
        if(veri2(cabeca2)){
            System.out.println("\nA LISTA NÃO ESTÁ ORDENADA");
        }
        System.out.println("");
    }

    public void menu() {
        int valor, valor2, opcao = 0;
        System.out.print("\n------------ Menu ------------\n");
        while (opcao != -1) {
            opcao = Input.readInt(
                    "\nDigite a opcao: \n(1) Insere Inicio - Lista 1 \t(2) Insere Inicio - Lista 2\n(3) Insere fim - Lista 1 \t(4) Insere Fim - Lista 2 \n(5) Ordenar - Lista 1 \t        (6) Ordenar - Lista 2\n\n(7) imprime \n(-1) Sair \n\nOpcao: ");
            switch (opcao) {

                case 1: // insereInicio
                    valor = Input.readInt("Valor Lista 1: ");
                    insereInicio(valor);
                    break;

                case 2:
                    valor2 = Input.readInt("Valor lista 2: ");
                    insereInicio2(valor2);
                    break;

                case 3: // insereFinal
                    valor = Input.readInt("Valor Lista 1: ");
                    insereFinal(valor);
                    break;

                case 4: // insereFinal
                    valor2 = Input.readInt("Valor Lista 2: ");
                    insereFinal2(valor2);
                    break;

                case 5: 
                    ordenarN();
                    break;

                case 6:
                    ordenarN2();
                    break;

                case 7:
                    imprime();
                    break;

                case -1: // sair
                    System.out.println("Saindo!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;

            }

        }
    }


    public static void main(String args[]) {
        System.out.println("\n************ Lista Encadeada Din�mica ************\n");
        ex02 fila1 = new ex02();
        ex02 fila2 = new ex02();
        fila1.menu();
        fila2.menu();
        System.out.println("\n************ Fim programa ************\n");
    }
}


