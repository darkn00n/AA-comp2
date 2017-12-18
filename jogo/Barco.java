package jogo;
public class Barco {
	Coordenada partes[];
	int quando;
	boolean vivo;
	int direcao;
	int tam;
	
	public Barco(int qual,Coordenada inicial,int dire){
		this.quando=0;
		this.vivo=true;
		this.direcao=dire;
		if(qual==0){
			partes = new Coordenada[4];
			qual=4;
		}
		else if(qual==2){
			partes = new Coordenada[2];
		}
		else if(qual==3) {
			partes = new Coordenada[2];
			qual=2;
		}
		else if(qual==1) {
			partes = new Coordenada[3];
			qual=3;
		}
		this.tam=qual;
		partes[0]= inicial;
		for(int i=1;i<tam;i++){
			if(dire==1) partes[i]= new Coordenada(inicial.getX(),inicial.getY() - i);
			else if(dire==2) partes[i]= new Coordenada(inicial.getX() + i,inicial.getY());
			else if(dire==3) partes[i]= new Coordenada(inicial.getX(),inicial.getY() + i);
			else if(dire==4) partes[i]= new Coordenada(inicial.getX() - i,inicial.getY());
		}
	}

}
