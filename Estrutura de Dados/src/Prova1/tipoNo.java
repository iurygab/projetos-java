package encadeamento;
public class tipoNo{
	public int info;
	public tipoNo prox, ant;
	
	public tipoNo(){}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public tipoNo getProx() {
		return prox;
	}

	public void setProx(tipoNo prox) {
		this.prox = prox;
	}

	public tipoNo getAnt() {
		return ant;
	}

	public void setAnt(tipoNo ant) {
		this.ant = ant;
	}
	
	public void LimpTela(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}