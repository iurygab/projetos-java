package listdup;
public class tipoNoDup{
	public int info;
	public tipoNoDup prox;
	public tipoNoDup ant;
        
	public tipoNoDup(){}
	
	public void setInfo(int info){
		this.info=info;
	}

	public void setProx(tipoNoDup prox){
		this.prox=prox;
	}
	
        public void setAnt(tipoNoDup ant){
		this.ant=ant;
	}
        
	public int getInfo(){
		return info;
	}
	public tipoNoDup getProx(){
		return prox;
	}
        public tipoNoDup getAnt(){
		return ant;
	}
	
}