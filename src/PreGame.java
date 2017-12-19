import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class PreGame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 154654984654987251L;
	private GridLayout LayoutBotoes = new GridLayout(1,4,1,2);
	private GridLayout LayoutTable = new GridLayout(13,12,1,1);
	private JButton buttons[];
	private JButton table[][];
	private JButton voltar;
	private Barco barcosali[];
	private int qualer[];
	private PMotor jogo;
	private Font font;
	private JLabel [] labelsFirst;
	private String [] letras = {"  A","  B","  C","  D","  E","  F","  G","  H","   I","   J",
								"   1","   2","   3","   4","   5","   6","   7","   8","   9","   10"};
	private int qual;
	private int escolheu;
	Coordenada inicial;
	
	PreGame(String n,PMotor jogo){
		super(n);
		setSize(750,680);
		setResizable(false);
		
		labelsFirst = new JLabel[20];
		for(int i=0;i<20;i++) {
			labelsFirst[i] = new JLabel(letras[i]);
		}
		font = new Font("Old English Text MT",Font.PLAIN,20);
		
		for(int i=0;i<20;i++) {
			labelsFirst[i].setFont(font);
			labelsFirst[i].setForeground(Color.white);
		}
		
		this.jogo=jogo;
		qual=0;
		escolheu=0;
		barcosali = new Barco[4];
		qualer= new int[4];
		qualer[0]=0;
		qualer[1]=0;
		qualer[2]=0;
		qualer[3]=0;
	}
	public void playSound(String soundName,float f,boolean set)
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
		final JPanelTwo navios = new JPanelTwo(1);
		final JPanelTwo tabela = new JPanelTwo(1);
		final JPanelTwo back = new JPanelTwo(4);
		
		// Cria os botoes de menu e tabuleiro
		buttons = new JButton[4];
		table = new JButton[10][10];
		
		//Imagens para utilizar no menu de navios
		ImageIcon Caca = new ImageIcon("Navios//caca2.jpg"); 	  
		ImageIcon Submarino = new ImageIcon("Navios//Submarino2.jpg"); 		
		ImageIcon NavioEscolta = new ImageIcon("Navios//Escolta2.jpg");
		ImageIcon PortaAvioes = new ImageIcon("Navios//PortaAvioes2.jpg");
		
		// Imagens para utilizar no tabuleiro
		ImageIcon AguaOff = new ImageIcon("Agua//WaterNoClick.jpg");
		
		ImageIcon VoltarMenu = new ImageIcon("Botoes//VoltarMenu2.jpg");
		ImageIcon VoltarMenuS = new ImageIcon("Botoes//VoltarMenu2S.jpg");
		
		//botão
		int largura = 148;	// largura da imagem no botao
		int altura = 125;	// altura da imagem no botao
		
		//Define o tamanho de cada Imagem a ser usada
		Caca.setImage(Caca.getImage().getScaledInstance(largura, altura, 100));
		Submarino.setImage(Submarino.getImage().getScaledInstance(largura, altura, 100)); 
		NavioEscolta.setImage(NavioEscolta.getImage().getScaledInstance(largura, altura, 100)); 
		PortaAvioes.setImage(PortaAvioes.getImage().getScaledInstance(largura, altura, 100));
		AguaOff.setImage(AguaOff.getImage().getScaledInstance(50,47,100));
		
		VoltarMenu.setImage(VoltarMenu.getImage().getScaledInstance(200,68,100));
		VoltarMenuS.setImage(VoltarMenuS.getImage().getScaledInstance(200,68,100));
		
		
		navios.setLayout(LayoutBotoes); // adiciona o layout ao menu
		tabela.setLayout(LayoutTable); // adiciona o layout ao tabuleiro
		back.setLayout(LayoutBotoes); //adiciona o layout 
		
		
		tabela.setPreferredSize(new Dimension(600,500)); // define o tamanho do tabuleiro
		navios.setPreferredSize(new Dimension(70,130)); // define o tamanho do menu
		
		back.setPreferredSize(new Dimension(70,70));
		voltar = new JButton(VoltarMenu);
		
		voltar.setMargin(new Insets(0, 0, 0, 0));
		voltar.setBorder(null);
		voltar.setOpaque(false);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setRolloverIcon(VoltarMenuS);
		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playSound("Efeitos//BotaoEntered.wav", -5.0f, false);
			}
		});
				
		voltar.addActionListener(this); // adiciona as acoes aos botoes
		voltar.setPreferredSize(new Dimension(10,10)); // define tamanho
		for(int i = 0;i<2;i++) {
			back.add(new JLabel(" "));

		}
		back.add(voltar);
		
		buttons[0] = new JButton(Caca); // adiciona o botao ao vetor de botoes
		buttons[1] = new JButton(Submarino); // adiciona o botao ao vetor de botoes
		buttons[2] = new JButton(NavioEscolta); // adiciona o botao ao vetor de botoes
		buttons[3] = new JButton(PortaAvioes); // adiciona o botao ao vetor de botoes
		
		for(int i = 0;i<4;i++) {
			buttons[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					playSound("Efeitos//BotaoEntered.wav", -5.0f, false);
				}
			});
		}
		for(int i = 0; i<4; i++) {
			buttons[i].addActionListener(this); // adiciona as acoes aos botoes
			buttons[i].setPreferredSize(new Dimension(10,10)); // define tamanho
			buttons[i].setMargin(new Insets(0, 0, 0, 0));
			buttons[i].setBorder(null);
			buttons[i].setOpaque(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setBorderPainted(false);
		}
		
		for(int i=0;i<4;i++) {
			navios.add(buttons[i]); // adiciona os botoes
		}
		// fim da parte dos navios
		
		// inicio tabuleiro
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++){
				table[i][j] = new JButton(AguaOff);
				table[i][j].setPreferredSize(new Dimension(10,10));
				table[i][j].addActionListener(this);
				table[i][j].setMargin(new Insets(0, 0, 0, 0));
				table[i][j].setBorder(null);
				table[i][j].setOpaque(false);
				table[i][j].setContentAreaFilled(false);
				table[i][j].setBorderPainted(false);
				
				table[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						playSound("Efeitos//Agua2.wav", -5.0f, false);
					}
				});
			}
		}	
		
		for(int i=0; i<14;i++){
			tabela.add(new JLabel(" "));
		}
			
		//primeira linha
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		for(int i=0;i<10;i++) {
			tabela.add(labelsFirst[i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		//segunda linha
		
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[10]);
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			tabela.add(table[0][i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		//terceira linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[11]);
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			tabela.add(table[1][i]);
		}
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		//quarta linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[12]);
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			tabela.add(table[2][i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		//quinta linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[13]);
		
		for(int i=0; i<10; i++){
			tabela.add(table[3][i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		//sexta linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[14]);
		
		for(int i=0; i<10; i++){
			tabela.add(table[4][i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		//setima linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[15]);
		
		for(int i=0; i<10; i++){
			tabela.add(table[5][i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		
		//oitava linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[16]);
		
		for(int i=0; i<10; i++){
			tabela.add(table[6][i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		
		//nona linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[17]);
		
		for(int i=0; i<10; i++){
			tabela.add(table[7][i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		
		//decima linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[18]);
		
		for(int i=0; i<10; i++){
			tabela.add(table[8][i]);
		}
		
		for(int i=0;i<2;i++) {
			tabela.add(new JLabel(" "));
		}
		
		//decima primeira linha
		tabela.add(new JLabel(" "));
		tabela.add(labelsFirst[19]);
		
		for(int i=0; i<10; i++){
			tabela.add(table[9][i]);
		}
		
		for(int i=0; i<10;i++){
			tabela.add(new JLabel(" "));
		}

		this.add(navios, BorderLayout.NORTH); // joga td q foi adicionado para o norte
		this.add(tabela, BorderLayout.CENTER); // joga td q foi adicionado para o centro
		this.add(back, BorderLayout.SOUTH);// joga td q foi adicionado para o sul
	}
	public void actionPerformed(ActionEvent e){		
		Object object = e.getSource();
		if(object == buttons[0] || object == buttons[1] || object == buttons[2] || object == buttons[3] || object == voltar) {
			playSound("Efeitos//BotaoClick.wav",-6.0f,false);
		}
		int largura=50;
		int altura=47;
		Barco barco;
		
		if(qual==0){
			if(object == buttons[0]) {
				qual=1;
				playSound("Efeitos//BotaoClick.wav",-8.0f,false);
			}
			if(object == buttons[1]) {
				qual=2;
				playSound("Efeitos//BotaoClick.wav",-8.0f,false);
			}
			if(object == buttons[2]) {
				qual=3;
				playSound("Efeitos//BotaoClick.wav",-8.0f,false);
			}
			if(object == buttons[3]){
				qual=4;
				playSound("Efeitos//BotaoClick.wav",-8.0f,false);
			}
		}

		for(int i = 0; i<10 ; i++){
			for(int j = 0; j<10 ; j++){
				if(object == table[i][j]){
					if(qual==0){
						JOptionPane.showMessageDialog(this,"Escolha um barco primeiro");
					}
					if(qual != 0 && escolheu==0){
						inicial = new Coordenada(j,i);
						ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
						minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
						table[i][j].setIcon(minhaImagem);
						table[i][j].removeActionListener(this);
						JOptionPane.showMessageDialog(this," Agora clique em outro botão para colocar o barco nessa direção.\n Veja se tem espaço, vc não vai bugar o jogo só vai perder tempo :D");
						escolheu=2;
					}
					if(escolheu==1){
						int dire=0;
						int hue=0;
						int deumerda=0;
						int aux=0;
						if(inicial.getY() > i && inicial.getX() == j){
							dire=1;
						}
						if(inicial.getY() < i && inicial.getX() == j){
							dire=3;		
						}
						if(inicial.getX() < j && inicial.getY() == i){
							dire=2;
						}
						if(inicial.getX() > j && inicial.getY() == i){
							dire=4;
						}
						if(inicial.getY() != i && inicial.getX() != j){
							JOptionPane.showMessageDialog(this," Não da pra colocar inclinado, escolhe de novo");
							hue=1;
							dire=0;
						}
						if(inicial.getY()==0){
							qualer[0]=1;
						}
						if(inicial.getY()==9){
							qualer[2]=1;
						}
						if(inicial.getX()==0){
							qualer[3]=1;
						}
						if(inicial.getX()==9){
							qualer[1]=1;
						}
						if(qual==1 && dire!=0){
							if(dire==1){
								if(inicial.getY()<1) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getX() == inicial.getX() && barcosali[0].partes[p].getY() <= inicial.getY() && barcosali[0].partes[p].getY() >= inicial.getY()-1) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getX() == inicial.getX() && barcosali[1].partes[p].getY() <= inicial.getY() && barcosali[1].partes[p].getY() >= inicial.getY()-1) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getX() == inicial.getX() && barcosali[2].partes[p].getY() <= inicial.getY() && barcosali[2].partes[p].getY() >= inicial.getY()-1) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[0]=1;
								}
							}
							if(dire==2){
								if(inicial.getX()>8) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getY() == inicial.getY() && barcosali[0].partes[p].getX() >= inicial.getX() && barcosali[0].partes[p].getX() <= inicial.getX()+1) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getY() == inicial.getY() && barcosali[1].partes[p].getX() >= inicial.getX() && barcosali[1].partes[p].getX() <= inicial.getX()+1) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getY() == inicial.getY() && barcosali[2].partes[p].getX() >= inicial.getX() && barcosali[2].partes[p].getX() <= inicial.getX()+1) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[1]=1;
								}
							}
							if(dire==3){
								if(inicial.getY()>8) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getX() == inicial.getX() && barcosali[0].partes[p].getY() >= inicial.getY() && barcosali[0].partes[p].getY() <= inicial.getY()+1) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getX() == inicial.getX() && barcosali[1].partes[p].getY() >= inicial.getY() && barcosali[1].partes[p].getY() <= inicial.getY()+1) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getX() == inicial.getX() && barcosali[2].partes[p].getY() >= inicial.getY() && barcosali[2].partes[p].getY() <= inicial.getY()+1) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[2]=1;
								}
							}
							if(dire==4){
								if(inicial.getX()<1) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getY() == inicial.getY() && barcosali[0].partes[p].getX() <= inicial.getX() && barcosali[0].partes[p].getX() >= inicial.getX()-1) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getY() == inicial.getY() && barcosali[1].partes[p].getX() <= inicial.getX() && barcosali[1].partes[p].getX() >= inicial.getX()-1) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getY() == inicial.getY() && barcosali[2].partes[p].getX() <= inicial.getX() && barcosali[2].partes[p].getX() >= inicial.getX()-1) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[3]=1;
								}
							}
							if(deumerda==0){
								barco=new Barco(3,inicial,dire);
								barcosali[3]=barco;
							}
							if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
								qual=0;
								escolheu=0;
								aux=1;
								qualer[0]=0;
								qualer[1]=0;
								qualer[2]=0;
								qualer[3]=0;
								JOptionPane.showMessageDialog(this,"Essa celula não cabe o navio que voce que, escolha outra");
							}
						}
						if(qual==2 && dire!=0){
							if(dire==1){
								if(inicial.getY()<1) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getX() == inicial.getX() && barcosali[0].partes[p].getY() <= inicial.getY() && barcosali[0].partes[p].getY() >= inicial.getY()-1) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getX() == inicial.getX() && barcosali[1].partes[p].getY() <= inicial.getY() && barcosali[1].partes[p].getY() >= inicial.getY()-1) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getX() == inicial.getX() && barcosali[3].partes[p].getY() <= inicial.getY() && barcosali[3].partes[p].getY() >= inicial.getY()-1) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[0]=1;
								}
							}
							if(dire==2){
								if(inicial.getX()>8) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getY() == inicial.getY() && barcosali[0].partes[p].getX() >= inicial.getX() && barcosali[0].partes[p].getX() <= inicial.getX()+1) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getY() == inicial.getY() && barcosali[1].partes[p].getX() >= inicial.getX() && barcosali[1].partes[p].getX() <= inicial.getX()+1) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getY() == inicial.getY() && barcosali[3].partes[p].getX() >= inicial.getX() && barcosali[3].partes[p].getX() <= inicial.getX()+1) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[1]=1;
								}
							}
							if(dire==3){
								if(inicial.getY()>8) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getX() == inicial.getX() && barcosali[0].partes[p].getY() >= inicial.getY() && barcosali[0].partes[p].getY() <= inicial.getY()+1) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getX() == inicial.getX() && barcosali[1].partes[p].getY() >= inicial.getY() && barcosali[1].partes[p].getY() <= inicial.getY()+1) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getX() == inicial.getX() && barcosali[3].partes[p].getY() >= inicial.getY() && barcosali[3].partes[p].getY() <= inicial.getY()+1) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[2]=1;
								}
							}
							if(dire==4){
								if(inicial.getX()<1) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getY() == inicial.getY() && barcosali[0].partes[p].getX() <= inicial.getX() && barcosali[0].partes[p].getX() >= inicial.getX()-1) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getY() == inicial.getY() && barcosali[1].partes[p].getX() <= inicial.getX() && barcosali[1].partes[p].getX() >= inicial.getX()-1) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getY() == inicial.getY() && barcosali[3].partes[p].getX() <= inicial.getX() && barcosali[3].partes[p].getX() >= inicial.getX()-1) deumerda=1;
										}
									}
								}if(deumerda==1){
									qualer[3]=1;
								}
							}
							if(deumerda==0){
								barco=new Barco(2,inicial,dire);
								barcosali[2]=barco;	
							}
							if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
								qual=0;
								escolheu=0;
								aux=1;
								qualer[0]=0;
								qualer[1]=0;
								qualer[2]=0;
								qualer[3]=0;
								JOptionPane.showMessageDialog(this,"Essa celula não cabe o navio que voce que, escolha outra");
							}
						}
						if(qual==3 && dire!=0){
							if(dire==1){
								if(inicial.getY()<2) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getX() == inicial.getX() && barcosali[0].partes[p].getY() <= inicial.getY() && barcosali[0].partes[p].getY() >= inicial.getY()-2) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getX() == inicial.getX() && barcosali[2].partes[p].getY() <= inicial.getY() && barcosali[2].partes[p].getY() >= inicial.getY()-2) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getX() == inicial.getX() && barcosali[3].partes[p].getY() <= inicial.getY() && barcosali[3].partes[p].getY() >= inicial.getY()-2) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[0]=1;
								}
							}
							if(dire==2){
								if(inicial.getX()>7) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getY() == inicial.getY() && barcosali[0].partes[p].getX() >= inicial.getX() && barcosali[0].partes[p].getX() <= inicial.getX()+2) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getY() == inicial.getY() && barcosali[2].partes[p].getX() >= inicial.getX() && barcosali[2].partes[p].getX() <= inicial.getX()+2) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getY() == inicial.getY() && barcosali[3].partes[p].getX() >= inicial.getX() && barcosali[3].partes[p].getX() <= inicial.getX()+2) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[1]=1;
								}
							}
							if(dire==3){
								if(inicial.getY()>7) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getX() == inicial.getX() && barcosali[0].partes[p].getY() >= inicial.getY() && barcosali[0].partes[p].getY() <= inicial.getY()+2) deumerda=1;
										}
									}
									if(barcosali[1]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getX() == inicial.getX() && barcosali[2].partes[p].getY() >= inicial.getY() && barcosali[2].partes[p].getY() <= inicial.getY()+2) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getX() == inicial.getX() && barcosali[3].partes[p].getY() >= inicial.getY() && barcosali[3].partes[p].getY() <= inicial.getY()+2) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[2]=1;
								}
							}
							if(dire==4){
								if(inicial.getX()<2) deumerda=1;
								else{
									if(barcosali[0]!=null){
										for(int p=0;p<4;p++){
											if(barcosali[0].partes[p].getY() == inicial.getY() && barcosali[0].partes[p].getX() <= inicial.getX() && barcosali[0].partes[p].getX() >= inicial.getX()-2) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getY() == inicial.getY() && barcosali[2].partes[p].getX() <= inicial.getX() && barcosali[2].partes[p].getX() >= inicial.getX()-2) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getY() == inicial.getY() && barcosali[3].partes[p].getX() <= inicial.getX() && barcosali[3].partes[p].getX() >= inicial.getX()-2) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[3]=1;
								}
							}
							if(deumerda==0){
								barco= new Barco(1,inicial,dire);
								barcosali[1]=barco;	
							}
							if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
								qual=0;
								escolheu=0;
								aux=1;
								qualer[0]=0;
								qualer[1]=0;
								qualer[2]=0;
								qualer[3]=0;
								JOptionPane.showMessageDialog(this,"Essa celula não cabe o navio que voce que, escolha outra");
							}
						}
						if(qual==4 && dire!=0){
							if(dire==1){
								if(inicial.getY()<3) deumerda=1;
								else{
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getX() == inicial.getX() && barcosali[1].partes[p].getY() <= inicial.getY() && barcosali[1].partes[p].getY() >= inicial.getY()-3) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getX() == inicial.getX() && barcosali[2].partes[p].getY() <= inicial.getY() && barcosali[2].partes[p].getY() >= inicial.getY()-3) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getX() == inicial.getX() && barcosali[3].partes[p].getY() <= inicial.getY() && barcosali[3].partes[p].getY() >= inicial.getY()-3) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[0]=1;
								}
							}
							if(dire==2){
								if(inicial.getX()>6) deumerda=1;
								else{
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getY() == inicial.getY() && barcosali[1].partes[p].getX() >= inicial.getX() && barcosali[1].partes[p].getX() <= inicial.getX()+3) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getY() == inicial.getY() && barcosali[2].partes[p].getX() >= inicial.getX() && barcosali[2].partes[p].getX() <= inicial.getX()+3) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getY() == inicial.getY() && barcosali[3].partes[p].getX() >= inicial.getX() && barcosali[3].partes[p].getX() <= inicial.getX()+3) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[1]=1;
								}
							}
							if(dire==3){
								if(inicial.getY()>6) deumerda=1;
								else{
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getX() == inicial.getX() && barcosali[1].partes[p].getY() >= inicial.getY() && barcosali[1].partes[p].getY() <= inicial.getY()+3) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getX() == inicial.getX() && barcosali[2].partes[p].getY() >= inicial.getY() && barcosali[2].partes[p].getY() <= inicial.getY()+3) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getX() == inicial.getX() && barcosali[3].partes[p].getY() >= inicial.getY() && barcosali[3].partes[p].getY() <= inicial.getY()+3) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[2]=1;
								}
							}
							if(dire==4){
								if(inicial.getX()<3) deumerda=1;
								else{
									if(barcosali[1]!=null){
										for(int p=0;p<3;p++){
											if(barcosali[1].partes[p].getY() == inicial.getY() && barcosali[1].partes[p].getX() <= inicial.getX() && barcosali[1].partes[p].getX() >= inicial.getX()-3) deumerda=1;
										}
									}
									if(barcosali[2]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[2].partes[p].getY() == inicial.getY() && barcosali[2].partes[p].getX() <= inicial.getX() && barcosali[2].partes[p].getX() >= inicial.getX()-3) deumerda=1;
										}
									}
									if(barcosali[3]!=null){
										for(int p=0;p<2;p++){
											if(barcosali[3].partes[p].getY() == inicial.getY() && barcosali[3].partes[p].getX() <= inicial.getX() && barcosali[3].partes[p].getX() >= inicial.getX()-3) deumerda=1;
										}
									}
								}
								if(deumerda==1){
									qualer[3]=1;
								}
							}
							if(deumerda==0){
								barco=new Barco(0,inicial,dire);
								barcosali[0]=barco;	
							}
							if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
								qual=0;
								escolheu=0;
								aux=1;
								qualer[0]=0;
								qualer[1]=0;
								qualer[2]=0;
								qualer[3]=0;
								JOptionPane.showMessageDialog(this,"Essa celula não cabe o navio que voce que, escolha outra");
							}
						}
						if(hue==0 && deumerda==0){
							escolheu=0;
							qual=0;
						}
						if(deumerda==1 && aux==0){
							JOptionPane.showMessageDialog(this,"Falei que ia perder tempo, não tem espaço nessa direção tenta outra ai");
						}
					}
				}
			}
		}
		if(escolheu==2) escolheu=1;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				for(int k = 0; k<4 ; k++){
					if(barcosali[k]!=null){
						for(int h = 0; h<barcosali[k].tam ; h++){
							if(barcosali[k].partes[h].getX() == j && barcosali[k].partes[h].getY() == i){
								if(k==0){
									if(h==0){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
									else if(h==1){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
									else if(h==2){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
									else if(h==3){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
								}
								else if(k==1){
									if(h==0){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
									else if(h==1){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
									else if(h==2){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
								}
								else if(k==2){
									if(h==0){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
									else if(h==1){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
								}
								else if(k==3){
									if(h==0){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
									else if(h==1){
										if(barcosali[k].direcao==1){
											ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==2){
											ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==3){
											ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
										if(barcosali[k].direcao==4){
											ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
											minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
											table[i][j].setIcon(minhaImagem);
											table[i][j].removeActionListener(this);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(barcosali[0]!=null){
			buttons[3].removeActionListener(this);
		}
		if(barcosali[1]!=null){
			buttons[2].removeActionListener(this);
		}
		if(barcosali[2]!=null){
			buttons[1].removeActionListener(this);
		}
		if(barcosali[3]!=null){
			buttons[0].removeActionListener(this);
		}
		if(barcosali[0]!=null && barcosali[1]!=null && barcosali[2]!=null && barcosali[3]!=null){
			jogo.Setbarcos(barcosali);
			JOptionPane.showMessageDialog(this,"Clique em qualquer botão da janela do jogo para começar o jogo");
			this.dispose();
		}
		if(object==voltar){
			boolean result = JOptionPane.showConfirmDialog(this, "Deseja voltar para o menu? todos os dados seram perdidos", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
			if(result == true) {
				jogo.Dispose(jogo.Gettabu());
				this.dispose();
				jogo.createMenu();
			}
		}
	}
	public Barco[] Getbarcosali() {
		return barcosali;
	}
}