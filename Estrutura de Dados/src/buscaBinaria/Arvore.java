package buscaBinaria;

public class Arvore {
    public int info;
    public Arvore dir, esq;
    
    public Arvore(int valor){
		info = valor;
	}
    
    public int getInfo() {
        return info;
    }
    public void setInfo(int info) {
        this.info = info;
    }
    public Arvore getDir() {
        return dir;
    }
    public void setDir(Arvore dir) {
        this.dir = dir;
    }
    public Arvore getEsq() {
        return esq;
    }
    public void setEsq(Arvore esq) {
        this.esq = esq;
    }
    
    

    
}
