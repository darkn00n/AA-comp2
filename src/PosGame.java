
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class PosGame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1546544984654987251L;
	private GridLayout MenuLayout = new GridLayout(8,0,3,1);
	private JButton MenuButton[];
	private PMotor jogo;
	private Tabuleiro table;
	
	PosGame(String n,PMotor jogo,Tabuleiro table){
		super(n);
		setSize(800,600);
		setResizable(false);
		this.jogo = jogo;
		this.table = table;
		
		
	}
	
	public void addComponentsToPane(Boolean v) {
		final JPanelTwo menu;
		MenuButton = new JButton[3];
		
		if(v) {
			playSound(true);
			menu = new JPanelTwo(5);
			
			MenuButton = new JButton[3];
			ImageIcon NewGame = new ImageIcon("botoes//NovoJogoV.jpg"); // Imagem que sera utilizada no primeiro botao
			ImageIcon Restart = new ImageIcon("botoes//RestartV.jpg");// Aqui tera outra imagem que sera utilizada no segundo botao		
			ImageIcon Exit = new ImageIcon("botoes//ExitV.jpg");
			
			int largura = 270;	// largura da imagem no botao
			int altura = 74;	// altura da imagem no botao
			
			NewGame.setImage(NewGame.getImage().getScaledInstance(largura, altura, 100)); // configura a imagem
			Restart.setImage(Restart.getImage().getScaledInstance(largura, altura, 100)); 
			Exit.setImage(Exit.getImage().getScaledInstance(largura, altura, 100)); 
			
			menu.setLayout(MenuLayout); // adiciona o layout ao menu
			
			menu.setPreferredSize(new Dimension(800,600)); // define o tamanho do menu
			
			MenuButton[0] = new JButton(NewGame); // adiciona o botao ao MenuButton
			MenuButton[1] = new JButton(Restart); // adiciona o botao ao MenuButton
			MenuButton[2] = new JButton(Exit); // adiciona o botao ao MenuButton
			
			for(int i=0;i<3;i++) {
				MenuButton[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						playSoundE("Efeitos//BotaoEntered.wav", -5.0f, false);
					}
				});
			}
			MenuButton[0].setRolloverIcon(new ImageIcon("Botoes//NovoJogoVS.jpg"));
			MenuButton[1].setRolloverIcon(new ImageIcon("Botoes//RestartVS.jpg"));
			MenuButton[2].setRolloverIcon(new ImageIcon("Botoes//ExitVS.jpg"));
		}
		else{
			playSound(false);
			menu = new JPanelTwo(6);
			
			ImageIcon NewGame = new ImageIcon("botoes//NovoJogoD.jpg"); // Imagem que sera utilizada no primeiro botao
			ImageIcon Restart = new ImageIcon("botoes//RestartD.jpg");// Aqui tera outra imagem que sera utilizada no segundo botao		
			ImageIcon Exit = new ImageIcon("botoes//ExitD.jpg");
			
			int largura = 270;	// largura da imagem no botao
			int altura = 74;	// altura da imagem no botao
			
			NewGame.setImage(NewGame.getImage().getScaledInstance(largura, altura, 100)); // configura a imagem
			Restart.setImage(Restart.getImage().getScaledInstance(largura, altura, 100)); 
			Exit.setImage(Exit.getImage().getScaledInstance(largura, altura, 100)); 
			
			menu.setLayout(MenuLayout); // adiciona o layout ao menu
			
			menu.setPreferredSize(new Dimension(800,600)); // define o tamanho do menu
			
			MenuButton[0] = new JButton(NewGame); // adiciona o botao ao MenuButton
			MenuButton[1] = new JButton(Restart); // adiciona o botao ao MenuButton
			MenuButton[2] = new JButton(Exit); // adiciona o botao ao MenuButton
			
			for(int i=0;i<3;i++) {
				MenuButton[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						playSoundE("Efeitos//BotaoEntered.wav", -5.0f, false);
					}
				});
			}
			MenuButton[0].setRolloverIcon(new ImageIcon("Botoes//NovoJogoDS.jpg"));
			MenuButton[1].setRolloverIcon(new ImageIcon("Botoes//RestartDS.jpg"));
			MenuButton[2].setRolloverIcon(new ImageIcon("Botoes//ExitDS.jpg"));
		}
		
		
		
		
		for(int i = 0; i<3; i++) {
			MenuButton[i].addActionListener(this); // adiciona as acoes aos botoes
			MenuButton[i].setPreferredSize(new Dimension(10,10)); // define tamanho
			MenuButton[i].setMargin(new Insets(0, 0, 0, 0));
			MenuButton[i].setBorder(null);
			MenuButton[i].setOpaque(false);
			MenuButton[i].setContentAreaFilled(false);
			MenuButton[i].setBorderPainted(false);
		}
		
		// adiciona coisas ao layout para enquadrar
		
		for(int i=0; i<13;i++) {
			menu.add(new JLabel("  "));
		}
		menu.add(MenuButton[0]); // adiciona o primeiro botao
		menu.add(new JLabel("  "));
		menu.add(new JLabel("  "));
		menu.add(MenuButton[1]); // adiciona o segundo botao
		menu.add(new JLabel("  "));
		menu.add(new JLabel("  "));
		menu.add(MenuButton[2]);
		
		for(int i=0; i<2;i++) {
		menu.add(new JLabel("  "));
		}

		// fim da adicao de coisas para enquadramento
		this.getContentPane().add(menu, BorderLayout.EAST); // joga td q foi adicionado para o centro
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		if(object == MenuButton[0]){
			playSoundE("Efeitos//BotaoClick.wav",-6.0f,false);
			this.dispose();
			table.dispose();
			jogo.clipStop("Victory");
			jogo.clipStop("Defeat");
			jogo.createGame();
		}
		if(object == MenuButton[1]){
			playSoundE("Efeitos//BotaoClick.wav",-6.0f,false);
			table.Reinicia();
			jogo.clipStop("Victory");
			jogo.clipStop("Defeat");
			table.setVisible(true);
			jogo.playSound("Jogo", -10.0f);
			this.dispose();
		}
		if(object == MenuButton[2]){
			playSoundE("Efeitos//BotaoClick.wav",-6.0f,false);
			jogo.clipStop("Victory");
			jogo.clipStop("Defeat");
			this.dispose();
			table.dispose();
		}
	}
	public void playSound(Boolean v){
		
		if(v) {
			jogo.playSound("Victory",-10.0f);
		}
		else {
			jogo.playSound("Defeat", -10.0f);
		}
	}
	public void playSoundE(String soundName,float f,boolean set)
	{
		//true == musica
		//false == efeito
		
		try 
	   {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
	    Clip clip = AudioSystem.getClip( );
	    clip.open(audioInputStream);
	    FloatControl gainControl = 
	    	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	    	gainControl.setValue(f); 
	    	
	    	if(set) {
	    		clip.start( );
	    	}
	    	else {
	    		clip.loop(0);
	    	} 
	   }
		catch(Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}
	}

}