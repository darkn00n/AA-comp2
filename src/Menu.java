
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 154654984654987251L;
	private GridLayout MenuLayout = new GridLayout(8,0,3,1);
	private JButton MenuButton[];
	private PMotor jogo;
	
	Menu(String n,PMotor jogo){
		super(n);
		setSize(800,600);
		this.jogo=jogo;
		setResizable(false);
		
		playSound();
	}
	public void addComponentsToPane() {
		final JPanelTwo menu = new JPanelTwo(0);
		MenuButton = new JButton[2];
		ImageIcon BotaoPlay = new ImageIcon("botoes//Botao1.jpg"); // Imagem que sera utilizada no primeiro botao
		ImageIcon BotaoCredits = new ImageIcon("botoes//Botao2.jpg");				   // Aqui tera outra imagem que sera utilizada no segundo botao		
		
		int largura = 270;	// largura da imagem no botao
		int altura = 74;	// altura da imagem no botao
		
		BotaoPlay.setImage(BotaoPlay.getImage().getScaledInstance(largura, altura, 100)); // configura a imagem
		BotaoCredits.setImage(BotaoCredits.getImage().getScaledInstance(largura, altura, 100)); 
		
		menu.setLayout(MenuLayout); // adiciona o layout ao menu
		
		menu.setPreferredSize(new Dimension(800,600)); // define o tamanho do menu
		
		MenuButton[0] = new JButton(BotaoPlay); // adiciona o botao ao MenuButton
		MenuButton[1] = new JButton(BotaoCredits); // adiciona o botao ao MenuButton
		
		
		MenuButton[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playSoundE("Efeitos//BotaoEntered.wav", -5.0f, false);
			}
		});
		MenuButton[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playSoundE("Efeitos//BotaoEntered.wav", -5.0f, false);
			}
		});
			
		MenuButton[0].setRolloverIcon(new ImageIcon("Botoes//Botao1S.jpg"));
		MenuButton[1].setRolloverIcon(new ImageIcon("Botoes//Botao2S.jpg"));
		
		for(int i = 0; i<2; i++) {
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
		
		for(int i=0; i<6;i++) {
		menu.add(new JLabel("  "));
		}

		// fim da adicao de coisas para enquadramento
		this.getContentPane().add(menu, BorderLayout.EAST); // joga td q foi adicionado para o centro
	}
	public void playSound(){
		
		jogo.playSound("Menu",-10.0f);
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

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		if(object == MenuButton[0]){
			playSoundE("Efeitos//BotaoClick.wav",-6.0f,false);
			this.dispose();
			jogo.createHistoria();
		}
		if(object == MenuButton[1]) {
			playSoundE("Efeitos//BotaoClick.wav",-6.0f,false);
			jogo.clipStop("Menu");
			this.dispose();
			jogo.createCreditos();
		}
	}
}