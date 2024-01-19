
import java.util.Scanner;

public class ex03 {

    int op;
    Scanner leitor = new Scanner(System.in);
    public Lista cabecaRo, cabecaCi, cabecaRodovCid;

    public void rodCidade(String nomeCid) {
        Lista auxRo, auxCi;
        cabecaRodovCid = null;
        auxRo = cabecaRo;

        int quantRo, quantCi;
        quantRo = getTamanhoNo(cabecaRo);

        for (int i = 0; i < quantRo; i++) {

            quantCi = getTamanhoNo(auxRo.getCidades());
            auxCi = auxRo.getCidades();
            if (getTamanhoNo(auxRo.getCidades()) == 0) {
                auxRo = auxRo.getProx();

            } else {
                for (int cont = 0; cont < quantCi; cont++) {

                    if (auxCi.getCidade().equalsIgnoreCase(nomeCid)) {

                        if (cabecaRodovCid == null) {
                            cabecaRodovCid = new Lista();

                            cabecaRodovCid.setRodovia(auxRo.getRodovia());
                            cabecaRodovCid.setProx(null);

                            auxCi = auxCi.getProx();
                        } else {

                            Lista novaCid = new Lista(), aux3;

                            novaCid.setRodovia(auxRo.getRodovia());
                            novaCid.setProx(null);
                            aux3 = cabecaRodovCid;

                            while (aux3.getProx() != null) {

                                aux3 = aux3.getProx();
                            }
                            aux3.setProx(novaCid);
                            auxCi = auxCi.getProx();
                        }
                    } else {

                        auxCi = auxCi.getProx();
                    }

                }
                auxRo = auxRo.getProx();
            }

        }

        imprimeRod();

    }

    public void inCidade(String nomeRod, String nomeCid) {

        Lista aux = cabecaRo, auxCi;

        while (!aux.getRodovia().equalsIgnoreCase(nomeRod)) {
            aux = aux.getProx();

        }
        if (aux.getCidades() == null) {
            Lista cabecaCi = new Lista();
            cabecaCi.setCidade(nomeCid);
            cabecaCi.setAnt(null);
            cabecaCi.setProx(null);
            aux.setCidades(cabecaCi);

        } else {
            auxCi = aux.getCidades();

            while (auxCi.getProx() != null) {
                auxCi = auxCi.getProx();
            }
            Lista novaCi = new Lista();
            novaCi.setCidade(nomeCid);
            novaCi.setProx(null);
            novaCi.setAnt(auxCi);
            auxCi.setProx(novaCi);
        }

    }

    private int getTamanhoNo(Lista cabeca) {
        if (cabeca != null) {
            Lista aux;
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

    public void criaRodovia(String rodovia) {
        if (cabecaRo == null) {
            cabecaRo = new Lista();
            cabecaRo.setRodovia(rodovia);
            cabecaRo.setProx(null);
            cabecaRo.setCidades(null);
            cabecaRo.setAnt(null);

        } else {
            Lista aux, novaRodovia;
            aux = cabecaRo;

            novaRodovia = new Lista();
            novaRodovia.setRodovia(rodovia);
            novaRodovia.setCidades(null);

            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novaRodovia);
            novaRodovia.setProx(null);

        }
        System.out.println("Rodovia " + rodovia + " inserida com sucesso! ");

    }

    public void imprimeRod() {
        Lista aux = cabecaRodovCid;
        int i;

        if (cabecaRodovCid == null) {
            System.out.println("SEM RODOVIAS NESSE CidaDE");
        } else {
            if (cabecaRodovCid != null) {
                System.out.print("rodovias: ");
                for (i = 0; i < getTamanhoNo(cabecaRodovCid); i++) {
                    System.out.print(aux.getRodovia() + " ");
                    aux = aux.getProx();
                }
                System.out.println("");
            }
        }
    }

    public boolean Cruzamento(String nomeRod1, String nomeRod2) {

        Lista aux = cabecaRo, aux2 = cabecaRo;
        boolean teste = false;

        while (!aux.getRodovia().equalsIgnoreCase(nomeRod1)) {
            aux = aux.getProx();
        }

        while (!aux2.getRodovia().equalsIgnoreCase(nomeRod2)) {
            aux2 = aux2.getProx();
        }

        Lista auxCi1 = aux.getCidades(), auxCi2;
        int tama1 = getTamanhoNo(auxCi1);
        for (int i = 0; i < tama1; i++) {
            auxCi2 = aux2.getCidades();
            int tama2 = getTamanhoNo(auxCi2);
            for (int cont = 0; cont < tama2; cont++) {
                if (auxCi1.getCidade().equalsIgnoreCase(auxCi2.getCidade())) {
                    teste = true;
                }
                auxCi2 = auxCi2.getProx();
            }
            auxCi1 = auxCi1.getProx();
        }

        return teste;

    }

    public void menu() {
        while (op != -1) {
            System.out.print("\nMENU");
            System.out.println(
                    "\n1 - COLOCAR RODOVIA\t 2- COLOCAR CidaDE \n 3 - RETORNAR RODOVIAS EM CidaDES\t 4 - VER CRUZAMENTOS\n-1 -SAIR");
            System.out.print("\nOPÇÃO: ");
            op = leitor.nextInt();

            switch (op) {
                case 1:
                    System.out.print("\nINSIRA A RODOVIA-> ");
                    String rod = leitor.next();
                    criaRodovia(rod);

                    break;

                case 2:
                    System.out.println("INSERIR CidaDES: ");

                    System.out.print("\nDigite a RodoviA: ");
                    String rodo = leitor.next();
                    leitor.nextLine();
                    System.out.print("\nDigite a Cidade: ");
                    String cid = leitor.nextLine();

                    inCidade(rodo, cid);
                    break;

                case 3:
                    leitor.nextLine();
                    System.out.print("\nInsira a Cidade");
                    cid = leitor.nextLine();
                    rodCidade(cid);
                    break;

                case 4:
                    System.out.print("\nDigite a Rodovia 1 ->");
                    String rodo1 = leitor.next();
                    leitor.nextLine();
                    System.out.print("\nDigite a Rodovia 2 ->");
                    String rodo2 = leitor.nextLine();

                    boolean ver = Cruzamento(rodo1, rodo2);

                    if (ver) {
                        System.out.println("AS RODOVIAS SE CRUZAM");
                    } else {
                        System.out.println("AS RODOVIAS NÃO SE CRUZAM");
                    }
                    break;

                case -1:
                    System.out.println("Saindo... ");
                    break;

                default:
                    System.out.println("OPCÃO ERRADA!!!!");
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        ex03 clas = new ex03();

        clas.menu();
    }

}
