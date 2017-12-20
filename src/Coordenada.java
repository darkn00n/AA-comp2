
public class Coordenada {
	private int X,Y;
	private boolean viva;
	
	Coordenada(int X,int Y){
		this.X = X;
		this.Y = Y;
		this.viva=true;
	}
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	public boolean getviva(){
		return viva;
	}
	public void setviva(boolean novo) {
		this.viva=novo;
	}
}