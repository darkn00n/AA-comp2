import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;


public class PMotor {
	private Barco barcosali[];
	private Menu menu;
	private PreGame pregame;
	private Tabuleiro frame;
	private PosGame posgame;
	private Creditos creditos;
	private Tutorial tutorial;
	private Historia historia;
	private Clip clipMenu,clipJogo,clipDefeat,clipVictory,clipTiro,clipBotaoClick,clipBotaoEntered,clipAgua,clipCreditos;
	
	public Menu getMenu() {
		return menu;
	}
	public void createHistoria() {
		// criando e configurando a janela
				historia = new Historia("Batalha Naval",this);
				
				//fecha a janela e termina a execucao
				historia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//Configurando ContentPane
				historia.addComponentsToPane();
				
				//mostrando a janela
				historia.pack();
				historia.setVisible(true);
	}
	public void createTutorial() {
		// criando e configurando a janela
				tutorial = new Tutorial("Batalha Naval",this);
				
				//fecha a janela e termina a execucao
				tutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//Configurando ContentPane
				tutorial.addComponentsToPane();
				
				//mostrando a janela
				tutorial.pack();
				tutorial.setVisible(true);
	}
	public void createCreditos() {
		// criando e configurando a janela
		creditos = new Creditos("Batalha Naval",this);
		
		//fecha a janela e termina a execucao
		creditos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Configurando ContentPane
		creditos.addComponentsToPane();
		
		//mostrando a janela
		creditos.pack();
		creditos.setVisible(true);
				
	}
	public void createMenu(){
		
		// criando e configurando a janela
		menu = new Menu("Batalha Naval",this);
		
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
		pregame = new PreGame("Batalha Naval",this);
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
		
		String qual = JOptionPane.showInputDialog(null,"Deseja que os barcos sejam colocados de maneira aleatoria ou manual?","",JOptionPane.QUESTION_MESSAGE);
		if(qual == null) {
			frame.dispose();
			this.clipStop("Jogo");
			createMenu();
		}
		else{
			try{
				frame.setNavios(qual);
			}catch(Exception e){
				
			}
		}
	}
	public void createPosGame(Boolean v){
		
		// criando e configurando a janela
		posgame = new PosGame("Batalha Naval",this,frame);
		
		//fecha a janela e termina a execucao
		posgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Configurando ContentPane
		posgame.addComponentsToPane(v);
		
		//mostrando a janela
		posgame.pack();
		posgame.setVisible(true);
	}
	public void clipStop(String qual) {
		switch(qual) {
			case "Menu":	clipMenu.stop();
					break;
			case "Jogo":	clipJogo.stop();
					break;
			case "Tiro":	clipTiro.stop();
					break;
			case "Agua":	clipAgua.stop();
					break;
			case "Victory":	clipVictory.stop();
					break;
			case "Defeat":	clipDefeat.stop();
					break;
			case "Creditos": clipCreditos.stop();
					break;
			case "Click":	clipBotaoClick.stop();
					break;
			case "Entered":	clipBotaoEntered.stop();
					break;
					}
	}
	public void playSound(String qual,float f)
	{
		try 
	   {
			switch(qual) {
			case "Menu":	FloatControl gainControl = (FloatControl)clipMenu.getControl(FloatControl.Type.MASTER_GAIN);
			    			gainControl.setValue(f); 
			    			clipMenu.open();
			    			clipMenu.setFramePosition(0);
			    			clipMenu.loop(50);
			    			break;
			case "Jogo":	FloatControl gainControl1 = (FloatControl)clipJogo.getControl(FloatControl.Type.MASTER_GAIN);
							gainControl1.setValue(f); 
							clipJogo.open();
			    			clipJogo.setFramePosition(0);
							clipJogo.loop(50);
							break;
			case "Victory":	FloatControl gainControl4 = (FloatControl)clipVictory.getControl(FloatControl.Type.MASTER_GAIN);
							gainControl4.setValue(f); 
							clipVictory.open();
			    			clipVictory.setFramePosition(0);
							clipVictory.loop(50);
							break;
			case "Defeat":	FloatControl gainControl5 = (FloatControl)clipDefeat.getControl(FloatControl.Type.MASTER_GAIN);
							gainControl5.setValue(f); 
							clipDefeat.open();
							clipDefeat.setFramePosition(0);
							clipDefeat.loop(50);
							break;
			case "Creditos":	FloatControl gainControl6 = (FloatControl)clipCreditos.getControl(FloatControl.Type.MASTER_GAIN);
							gainControl6.setValue(f); 
							clipCreditos.open();
							clipCreditos.setFramePosition(0);
							clipCreditos.loop(50);
							break;			
			}
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
	public void setConfiguration() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		ImageIcon icon = new ImageIcon("Icones//gothic.png");
		icon.setImage(icon.getImage().getScaledInstance(100, 90, 100));
		UIManager.getDefaults().put("OptionPane.background",new Color(0,0,0));
		UIManager.put("Panel.background", new Color(0,0,0));
		UIManager.put("TextField.background", new Color(192,192,192));
		UIManager.put("OptionPane.questionIcon", icon);
		UIManager.put("OptionPane.warningIcon", new ImageIcon(""));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Old English Text MT",Font.PLAIN,20)));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Old English Text MT",Font.PLAIN,15)));
		UIManager.put("OptionPane.font", new FontUIResource(new Font("Old English Text MT",Font.PLAIN,15)));
		UIManager.put("OptionPane.messageForeground", Color.gray);
		UIManager.put("TextField.font", new FontUIResource(new Font("Old English Text MT",Font.PLAIN,20)));
		UIManager.put("font", new FontUIResource(new Font("Old English Text MT",Font.PLAIN,20)));
		try {
			
		AudioInputStream menu = AudioSystem.getAudioInputStream(new File("Efeitos//Menu.wav").getAbsoluteFile( ));
		AudioInputStream jogo = AudioSystem.getAudioInputStream(new File("Efeitos//InGameF.wav").getAbsoluteFile( ));
		AudioInputStream tiro = AudioSystem.getAudioInputStream(new File("Efeitos//Tiro.wav").getAbsoluteFile( ));
		AudioInputStream click = AudioSystem.getAudioInputStream(new File("Efeitos//BotaoClick.wav").getAbsoluteFile( ));
		AudioInputStream entered = AudioSystem.getAudioInputStream(new File("Efeitos//BotaoEntered.wav").getAbsoluteFile( ));
		AudioInputStream agua = AudioSystem.getAudioInputStream(new File("Efeitos//Agua2.wav").getAbsoluteFile( ));
		AudioInputStream victory = AudioSystem.getAudioInputStream(new File("Efeitos//Vitoria.wav").getAbsoluteFile( ));
		AudioInputStream defeat = AudioSystem.getAudioInputStream(new File("Efeitos//Derrota.wav").getAbsoluteFile( ));
		AudioInputStream creditos = AudioSystem.getAudioInputStream(new File("Efeitos//Creditos.wav").getAbsoluteFile( ));
		
		
	    clipMenu = AudioSystem.getClip( );
	    clipJogo = AudioSystem.getClip( );
	    clipDefeat = AudioSystem.getClip( );
	    clipVictory = AudioSystem.getClip( );
	    clipTiro = AudioSystem.getClip( );
	    clipBotaoClick = AudioSystem.getClip( );
	    clipBotaoEntered = AudioSystem.getClip( );
	    clipCreditos = AudioSystem.getClip( );
	    clipAgua = AudioSystem.getClip( );
	    
	    clipMenu.open(menu);
	    clipJogo.open(jogo);
	    clipDefeat.open(defeat);
	    clipVictory.open(victory);
	    clipTiro.open(tiro);
	    clipBotaoClick.open(click);
	    clipBotaoEntered.open(entered);
	    clipCreditos.open(creditos);
	    clipAgua.open(agua);
		}
		catch(Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}
	}
}