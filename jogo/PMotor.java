package jogo;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PMotor {
	private Barco barcosali[];
	private Menu menu;
	private PreGame pregame;
	private Tabuleiro frame;
	
	public void createMenu(){
		// criando e configurando a janela
		menu = new Menu("qe",this);
		
		//fecha a janela e termina a execucao
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Configurando ContentPane
		menu.addComponentsToPane();
		
		//mostrando a janela
		menu.pack();
		menu.setVisible(true);
		
	}
	public void createPreGame(){
		// criando e configurando a janela
		pregame = new PreGame("Helou",this);
		barcosali=new Barco[4];
		for(int i =0;i<4;i++) {
			barcosali[i]=null;
		}
		//fecha a janela e termina a execucao
		pregame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Configurando ContentPane
		pregame.addComponentsToPane();
		
		//mostrando a janela
		pregame.pack();
		pregame.setVisible(true);
	}
	public void createGame() {
		//Criando e configurando a janela
		frame = new Tabuleiro("Batalha Naval",this);
		//Fecha a janela e termina a execução
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Configurando ContentPane.
		frame.addComponentsToPane();
		//Mostrando a janela
		frame.pack();
		frame.setVisible(true);
		
		String qual = JOptionPane.showInputDialog("Deseja que os barcos sejam colocados de maneira aleatoria ou manual?");
		if(qual == null) {
			frame.dispose();
			createMenu();
		}
		else{
			try{
				frame.setNavios(qual);
			}catch(Exception e){
				
			}
		}
	}
	public void playSound(String soundName,float f)
	{
		try 
	   {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
	    Clip clip = AudioSystem.getClip( );
	    clip.open(audioInputStream);
	    FloatControl gainControl = 
	    	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	    	gainControl.setValue(f); 
	    	
	    clip.start( );
	    
	    
	   }
		catch(Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}
	}

	public void Dispose(Object qualquer){
		if(qualquer instanceof Menu ){
			((Menu)qualquer).dispose();
		}
		if(qualquer instanceof Tabuleiro) {
			((Tabuleiro)qualquer).dispose();
		}
		if(qualquer instanceof PreGame) {
			((PreGame)qualquer).dispose();
		}
	}
	public Barco[] Getbarcos() {
		return barcosali;
	}
	public Tabuleiro Gettabu() {
		return frame;
	}
	public void Setbarcos(Barco[] barcosali) {
		this.barcosali=barcosali;
	}
	
}