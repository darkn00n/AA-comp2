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

public class Tutorial extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1546544984654987251L;
	private GridLayout MenuLayout = new GridLayout(9,0,0,0);
	private JButton MenuButton;
	private Clip clip;
	private PMotor jogo;
	
	Tutorial(String n,PMotor jogo,Clip clip){
		super(n);
		setSize(800,600);
		setResizable(false);
		this.jogo = jogo;
		this.clip = clip;
	}
	public void playSound(String soundName,float f,boolean set)
	{
		//true == musica
		//false == efeito
		try{
		   if(set){
		    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
			    clip = AudioSystem.getClip( );
			    clip.open(audioInputStream);
			    
			    FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			    gainControl.setValue(f);
	    		clip.loop(50);
	    	}
	    	else{
	    		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
			    Clip clip = AudioSystem.getClip( );
			    clip.open(audioInputStream);
			    
			    FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			    gainControl.setValue(f);
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
		
		final JPanelTwo menu = new JPanelTwo(8);
		
		ImageIcon Voltar = new ImageIcon("botoes//Next.jpg"); // Imagem que sera utilizada no primeiro botao	
		ImageIcon VoltarS = new ImageIcon("botoes//NextS.jpg");
		
		int largura = 270;	// largura da imagem no botao
		int altura = 74;	// altura da imagem no botao
		
		Voltar.setImage(Voltar.getImage().getScaledInstance(largura, altura, 100));
		VoltarS.setImage(VoltarS.getImage().getScaledInstance(largura, altura, 100));
		
		menu.setLayout(MenuLayout); // adiciona o layout ao menu
		
		menu.setPreferredSize(new Dimension(780,600)); // define o tamanho do menu
		
		MenuButton = new JButton(Voltar); // adiciona o botao ao MenuButton
		
		MenuButton.setRolloverIcon(VoltarS);
		MenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playSound("Efeitos//BotaoEntered.wav", -5.0f, false);
			}
		});
			
		MenuButton.setRolloverIcon(VoltarS);
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
		this.getContentPane().add(menu, BorderLayout.SOUTH); // joga td q foi adicionado para o centro
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		if(object == MenuButton){
			this.dispose();
			clip.stop();
			jogo.createGame();
		}
	}
	
}
	
	