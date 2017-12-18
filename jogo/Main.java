package jogo;

public class Main{
	public static void main(String[] args) {
		PMotor jogo = new PMotor();
		
		jogo.createMenu();

		jogo.playSound("Playback.wav",-22.4f);
	}
}