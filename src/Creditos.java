import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Creditos extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1546544984654987251L;
	private GridLayout MenuLayout = new GridLayout(9,0,0,0);
	private JButton MenuButton;
	private PMotor jogo;
	
	Creditos (String n,PMotor jogo){
		super(n);
		setSize(800,600);
		setResizable(false);
		this.jogo = jogo;
		playSound();
	}
	public void playSound(){
		jogo.playSound("Creditos",-10.0f);
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
	public void addComponentsToPane() {
		
		final JPanelTwo menu = new JPanelTwo(7);
		
		ImageIcon Voltar = new ImageIcon("botoes//VoltarMenu2.jpg"); // Imagem que sera utilizada no primeiro botao	
		ImageIcon VoltarS = new ImageIcon("botoes//VoltarMenu2S.jpg");
		
		int largura = 270;	// largura da imagem no botao
		int altura = 74;	// altura da imagem no botao
		
		Voltar.setImage(Voltar.getImage().getScaledInstance(largura, altura, 100));
		VoltarS.setImage(VoltarS.getImage().getScaledInstance(largura, altura, 100));
		
		menu.setLayout(MenuLayout); // adiciona o layout ao menu
		
		menu.setPreferredSize(new Dimension(800,600)); // define o tamanho do menu
		
		MenuButton = new JButton(Voltar); // adiciona o botao ao MenuButton
		
		MenuButton.setRolloverIcon(VoltarS);
		MenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playSoundE("Efeitos//BotaoEntered.wav", -5.0f,false);
			}
		});
			
		MenuButton.setRolloverIcon(new ImageIcon("Botoes//VoltarMenu2S.jpg"));
		MenuButton.addActionListener(this); // adiciona as acoes aos botoes
		MenuButton.setPreferredSize(new Dimension(10,10)); // define tamanho
		MenuButton.setMargin(new Insets(0, 0, 0, 0));
		MenuButton.setBorder(null);
		MenuButton.setOpaque(false);
		MenuButton.setContentAreaFilled(false);
		MenuButton.setBorderPainted(false);
		
		// adiciona coisas ao layout para enquadrar
		
		for(int i=0; i<26;i++) {
			menu.add(new JLabel(""));
		}
		menu.add(MenuButton); // adiciona o primeiro botao
		this.getContentPane().add(menu, BorderLayout.EAST); // joga td q foi adicionado para o centro
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		if(object == MenuButton){
			playSoundE("Efeitos//BotaoClick.wav",-6.0f,false);
			jogo.clipStop("Menu");
			jogo.clipStop("Creditos");
			this.dispose();
			jogo.createMenu();
		}
	}
	
}
	
	