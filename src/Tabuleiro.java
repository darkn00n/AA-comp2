import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

import java.util.Scanner;
import java.io.FileNotFoundException;

public class Tabuleiro extends JFrame implements ActionListener{
	private static final long serialVersionUID = 7526472295622776147L;
	private GridLayout experimentLayout = new GridLayout(13,12,1,1);
	private GridLayout layout = new GridLayout(1,3,1,1);
	private JButton table[][],table2[][],tiros[];
	private Barco barcos[],barcosali[];
	private int tiro,hue,dica,proximo;
	private int quais[][];
	private int debug[][];
	private Coordenada[] prox;
	private PMotor jogo;
	private Font font;
	private JLabel [] labelsFirst,labelsSecond;
	private String [] letras = {"  A","  B","  C","  D","  E","  F","  G","  H","   I","   J",
								"   1","   2","   3","   4","   5","   6","   7","   8","   9","   10"};
	private ImageIcon SubmarinoS,EscoltaS,CacaS,Submarino,Escolta,Caca;
	
	public Tabuleiro(String n,PMotor jogo){
		super(n);

		labelsFirst = new JLabel[20];
		labelsSecond = new JLabel[20];
		
		for(int i=0;i<20;i++) {
			labelsFirst[i] = new JLabel(letras[i]);
			labelsSecond[i] = new JLabel(letras[i]);
		}
		
		font = new Font("Old English Text MT",Font.PLAIN,20);
		
		
		for(int i=0;i<20;i++) {
			labelsFirst[i].setFont(font);
			labelsFirst[i].setForeground(Color.white);
			
			labelsSecond[i].setFont(font);
			labelsSecond[i].setForeground(Color.white);
		}
		
		setResizable(false);
		this.jogo=jogo;
		barcos=new Barco[4];
		barcosali=new Barco[4];
		tiro=0;
		hue=0;
		dica=3;
		proximo=0;
		quais=new int[10][10];
		debug=new int[10][10];
		prox=new Coordenada[4];
		for(int i=0;i<10;i++) {
			if(i<4){
				prox[i]=null;
				barcosali[i]=null;
			}
			for(int j=0;j<10;j++) {
				quais[i][j]=0;
				debug[i][j]=0;
			}
		}
		playSound();
	}

	public void playSound(){
		
		jogo.playSound("Jogo",-10.0f);
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

	public void actionPerformed(ActionEvent e){
		Object object = e.getSource();
		if(object == tiros[0] || object == tiros[1] || object == tiros[2] || object == tiros[3] || object == tiros[4] || object == tiros[5] || object == tiros[6]) {
			playSoundE("Efeitos//BotaoClick.wav",-6.0f,false);
		}
		
		int cont=0;
		int cont2=0;
		int cont3=0;
		int cont4=0;
		int cont5=0;
		int aux=0,aux2=0;
		
		for(int i = 0; i<10 ; i++){
			for(int j = 0; j<10 ; j++){
				if (object == table2[i][j]){
					if(hue==0){
						if(tiro != 0) playSoundE("Efeitos//tiro.wav",-6.0f,false);
						if(tiro==0){
							JOptionPane.showMessageDialog(this,"Escolha um tipo de tiro ou a dica para realizar uma ação","",JOptionPane.WARNING_MESSAGE);
						}
						if(tiro == 1  || tiro==2 || tiro == 3){
							for(int k = 0; k<4 ; k++){
								for(int h = 0; h<barcos[k].tam ; h++){
									if(barcos[k].partes[h].getX() == j && barcos[k].partes[h].getY() == i){
										if(k==0){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
											else if(h==3){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
											barcos[k].quando++;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
										}
										else if(k==1){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
										}
										else if(k==2){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
										}
										else if(k==3){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j].setIcon(minhaImagem);
													table2[i][j].removeActionListener(this);
													
												}
											}
										}
										if(barcos[k].partes[h].getviva()==true){
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
											aux=1;
										}
										barcos[k].partes[h].setviva(false);
									}
									else{
										cont++;
									}
								}
							}
							if(cont==11){
								aux2=1;
								ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
								int largura = 50;
								int altura = 47;
								minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
								table2[i][j].setIcon(minhaImagem);
								table2[i][j].removeActionListener(this);
								
							}
						}
						if((tiro==3 || tiro == 2) && j<=8){
							for(int k = 0; k<4 ; k++){
								for(int h = 0; h<barcos[k].tam ; h++){
									if(barcos[k].partes[h].getX() == j+1 && barcos[k].partes[h].getY() == i){
										if(k==0){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
											else if(h==3){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
										}
										else if(k==1){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
										}
										else if(k==2){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
										}
										else if(k==3){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j+1].setIcon(minhaImagem);
													table2[i][j+1].removeActionListener(this);
													
												}
											}
										}
										if(barcos[k].partes[h].getviva()==true) {
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
											aux=1;
										}
										barcos[k].partes[h].setviva(false);
									}
									else{
										cont2++;
									}
								}
							}
							if(cont2==11){
								aux2=1;
								ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
								int largura = 50;
								int altura = 47;
								minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
								table2[i][j+1].setIcon(minhaImagem);
								table2[i][j+1].removeActionListener(this);
							}
						}
						if(tiro==3 && j>=1){
							for(int k = 0; k<4 ; k++){
								for(int h = 0; h<barcos[k].tam ; h++){
									if(barcos[k].partes[h].getX() == j-1 && barcos[k].partes[h].getY() == i){
										if(k==0){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
											else if(h==3){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
										}
										else if(k==1){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
										}
										else if(k==2){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
										}
										else if(k==3){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i][j-1].setIcon(minhaImagem);
													table2[i][j-1].removeActionListener(this);
													
												}
											}
										}
										if(barcos[k].partes[h].getviva()==true) {
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
											aux=1;
										}
										barcos[k].partes[h].setviva(false);
									}
									else{
										cont3++;
									}
								}
							}
							if(cont3==11){
								aux2=1;
								ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
								int largura = 50;
								int altura = 47;
								minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
								table2[i][j-1].setIcon(minhaImagem);
								table2[i][j-1].removeActionListener(this);
							}
						}
						if(tiro==3 && i>=1){
							for(int k = 0; k<4 ; k++){
								for(int h = 0; h<barcos[k].tam ; h++){
									if(barcos[k].partes[h].getX() == j && barcos[k].partes[h].getY() == i-1){
										if(k==0){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
											else if(h==3){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
										}
										else if(k==1){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
										}
										else if(k==2){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
										}
										else if(k==3){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i-1][j].setIcon(minhaImagem);
													table2[i-1][j].removeActionListener(this);
													
												}
											}
										}
										if(barcos[k].partes[h].getviva()==true) {
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
											aux=1;
										}
										barcos[k].partes[h].setviva(false);
									}
									else{
										cont4++;
									}
								}
							}
							if(cont4==11){
								aux2=1;
								ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
								int largura = 50;
								int altura = 47;
								minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
								table2[i-1][j].setIcon(minhaImagem);
								table2[i-1][j].removeActionListener(this);
							}
						}
						if(tiro==3 && i<=8){
							for(int k = 0; k<4 ; k++){
								for(int h = 0; h<barcos[k].tam ; h++){
									if(barcos[k].partes[h].getX() == j && barcos[k].partes[h].getY() == i+1){
										if(k==0){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
											else if(h==3){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
										}
										else if(k==1){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
											else if(h==2){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
										}
										else if(k==2){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
										}
										else if(k==3){
											if(h==0){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
											else if(h==1){
												if(barcos[k].direcao==1){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==2){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==3){
													ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
												if(barcos[k].direcao==4){
													ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
													int largura = 50;
													int altura = 47;
													minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
													table2[i+1][j].setIcon(minhaImagem);
													table2[i+1][j].removeActionListener(this);
													
												}
											}
										}
										if(barcos[k].partes[h].getviva()==true) {
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
											aux=1;
										}
										barcos[k].partes[h].setviva(false);
									}
									else{
										cont5++;
									}
								}
							}
							if(cont5==11){
								aux2=1;
								ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
								int largura = 50;
								int altura = 47;
								minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
								table2[i+1][j].setIcon(minhaImagem);
								table2[i+1][j].removeActionListener(this);
								
							}
						}
						if(tiro==4){
							int deubom=0,deubom2=0;
							for(int k = 0; k<4 ; k++){
								if(barcos[k].vivo==true){
									for(int h = 0; h<barcos[k].tam ; h++){
										if(barcos[k].partes[h].getX() == j){
											deubom=1;
										}
										if(barcos[k].partes[h].getY() == i){
											deubom2=1;
										}
									}
								}
							}
							if(deubom2==1){
								JOptionPane.showMessageDialog(this,"Tem um barco nessa linha","",JOptionPane.WARNING_MESSAGE);
								tiro=0;
							}
							else{
								JOptionPane.showMessageDialog(this,"Não tem um barco nessa linha","",JOptionPane.WARNING_MESSAGE);
								tiro=0;
							}
							if(deubom==1){
								JOptionPane.showMessageDialog(this,"Tem um barco nessa coluna","",JOptionPane.WARNING_MESSAGE);
								tiro=0;
							}
							else{
								JOptionPane.showMessageDialog(this,"Não tem um barco nessa coluna","",JOptionPane.WARNING_MESSAGE);
								tiro=0;
							}
							dica--;
						}
					}
					if(hue==1){
						barcosali=jogo.Getbarcos();
						if(barcosali[0]!=null && barcosali[1]!=null && barcosali[2]!=null && barcosali[3]!=null){
							hue=0;
							this.Mostra();
						}
						else {
							JOptionPane.showMessageDialog(this,"Você não terminou de preencher os barcos,por favor termine","",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		}
		if(aux2==1 && aux==0) {
			JOptionPane.showMessageDialog(this,"Você não encontrou nada","",JOptionPane.WARNING_MESSAGE);
			this.PCjoga();
		}
		if(aux==1) {
			JOptionPane.showMessageDialog(this,"Parabéns você achou um navio","",JOptionPane.WARNING_MESSAGE);
			this.PCjoga();
		}
		tiro=0;
		for(int i=0;i<7;i++){
			if (object == tiros[i]){
				if(hue==0){
					if(i==0){
						if(barcosali[2].vivo == true) tiro=1;
						else {
							JOptionPane.showMessageDialog(this,"Você não tem mais esse barco","",JOptionPane.WARNING_MESSAGE); 
							ImageIcon minhaImagem = new ImageIcon("navios//Submarino2M.jpg");
							int largura = 135;
							int altura = 127;
							minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
							tiros[0].setIcon(minhaImagem);
							tiros[0].removeActionListener(this);
							tiros[0].setRolloverIcon(minhaImagem);
						}
					}
					if(i==1){
						if(barcosali[1].vivo == true) tiro=2;
						else {
							JOptionPane.showMessageDialog(this,"Você não tem mais esse barco","",JOptionPane.WARNING_MESSAGE); 
							ImageIcon minhaImagem = new ImageIcon("navios//Escolta2M.jpg");
							int largura = 135;
							int altura = 127;
							minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
							tiros[1].setIcon(minhaImagem);
							tiros[1].removeActionListener(this);
							tiros[1].setRolloverIcon(minhaImagem);
						}
					}
					if(i==2){
						if(barcosali[3].vivo == true) tiro=3;
						else {
							JOptionPane.showMessageDialog(this,"Você não tem mais esse barco","",JOptionPane.WARNING_MESSAGE); 
							ImageIcon minhaImagem = new ImageIcon("navios//Caca2M.jpg");
							int largura = 135;
							int altura = 127;
							minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
							tiros[2].setIcon(minhaImagem);
							tiros[2].removeActionListener(this);
							tiros[2].setRolloverIcon(minhaImagem);
						}
					}
					if(i==3){
						if(dica!=0){
							boolean result = JOptionPane.showConfirmDialog(this, "Você tem "+dica+" dicas,deseja realmente utilizar uma?","", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
							if(result == true) {
								tiro=4;
							}
						}
						else JOptionPane.showMessageDialog(this,"Você não tem mais dicas","",JOptionPane.WARNING_MESSAGE);
					}
					if(i==4){
						boolean result = JOptionPane.showConfirmDialog(this, "Deseja criar um novo jogo?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
						if(result == true) {
							jogo.clipStop("Jogo");
							this.dispose();
							jogo.createGame();
						}
					}
					if(i==5){
						boolean result = JOptionPane.showConfirmDialog(this, "O jogo será reinicializado. \n Deseja prosseguir?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
						if(result == true){
							this.Reinicia();
						}
					}
					if(i==6){
						boolean result = JOptionPane.showConfirmDialog(this, "Se você sair o jogo será finalizado. \n Deseja prosseguir?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
						if(result == true) {
							jogo.clipStop("Jogo");
							this.dispose();
							jogo.createMenu();
						}
					}
				}
				if(hue==1){
					barcosali=jogo.Getbarcos();
					if(barcosali[0]!=null && barcosali[1]!=null && barcosali[2]!=null && barcosali[3]!=null){
						hue=0;
						this.Mostra();
					}
					else {
						JOptionPane.showMessageDialog(this,"Voce não terminou de preencher os barcos,por favor termine","",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
	}
	
	public void Reinicia(){
		JOptionPane.showMessageDialog(this, "Aguarde, o jogo será reinicializado.", "",JOptionPane.WARNING_MESSAGE);
		for(int k=0;k<10;k++){
			for(int h=0;h<10;h++){				
				ImageIcon minhaImagem = new ImageIcon("agua//WaterNoClick.jpg");
				int largura=50;
				int altura=47;
				minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura,altura,100));
				table2[k][h].setIcon(minhaImagem);
				table[k][h].setIcon(minhaImagem);
				this.Mostra();
				table2[k][h].removeActionListener(this);
				table2[k][h].addActionListener(this);
			}
		}
		dica=3;
        proximo=0;
        for(int k=0;k<10;k++) {
            if(k<4){
                prox[k]=null;
            }
            for(int j=0;j<10;j++) {
                quais[k][j]=0;
                debug[k][j]=0;
            }
        }
		for(int k=0;k<4;k++){
            barcos[k].vivo=true;
            barcosali[k].vivo=true;
            barcos[k].quando=0;
            barcosali[k].quando=0;
            for(int h=0;h<barcos[k].tam;h++) {
                barcos[k].partes[h].setviva(true);
            }
            for(int h=0;h<barcosali[k].tam;h++) {
                barcosali[k].partes[h].setviva(true);
            }
        }
		for(int y=0;y<7;y++) {
			tiros[y].removeActionListener(this);
			tiros[y].addActionListener(this);
		}
		
		tiros[0].setRolloverIcon(SubmarinoS);
		tiros[1].setRolloverIcon(EscoltaS);
		tiros[2].setRolloverIcon(CacaS);
		tiros[0].setIcon(Submarino);
		tiros[1].setIcon(Escolta);
		tiros[2].setIcon(Caca);
		JOptionPane.showMessageDialog(this, "O jogo foi reinicializado com sucesso.","",JOptionPane.WARNING_MESSAGE);
	}
	public void Mostra(){
		int altura=47;
		int largura=50;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				for(int k = 0; k<4 ; k++){
					for(int h = 0; h<barcosali[k].tam ; h++){
						if(barcosali[k].partes[h].getX() == j && barcosali[k].partes[h].getY() == i){
							if(k==0){
								if(h==0){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==1){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==2){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==3){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
							}
							else if(k==1){
								if(h==0){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Epart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Epart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==1){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Epart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Epart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==2){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Epart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Epart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
							}
							else if(k==2){
								if(h==0){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Spart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Spart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==1){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Spart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Spart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
							}
							else if(k==3){
								if(h==0){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==1){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void setNavios(String qual) {
		Barco barcos[] = new Barco[4];
		Random rand = new Random();
		
		int aux = 0; // auxilia na tomada de decisao na distribuicao aleatoria
		int aux2;
		int dire=1;
		int tam=0;
		boolean okay = false;
		boolean okay2=false;
		boolean foi = true;
		
		while(!okay){
			if(qual.equalsIgnoreCase("aleatorio") || qual.equalsIgnoreCase("aleatoria") || qual.equalsIgnoreCase("aleatória") || qual.equalsIgnoreCase("aleatório")){
				for(int i = 0; i<4 ; i++){
					if(i==0) tam = 4;
					else if(i==1) tam = 3;
					else if(i==2) tam = 2;
					else if(i==3) tam = 2;
					int qualer[] = {0,0,0,0};
					aux = rand.nextInt(10);
					aux2 = rand.nextInt(10);
					Coordenada inicial = new Coordenada(aux,aux2);
					while(foi){
						dire = rand.nextInt(4) + 1;
						if(dire == 1 && qualer[0]==0){
							if(aux2-tam+1>=0){
								int comp = aux2-tam+1;
								for(int j=0;j<i;j++) {
									for(int k=0;k<barcosali[j].tam;k++){
										if(barcosali[j].partes[k].getY()>=comp && barcosali[j].partes[k].getY()<=aux2 && barcosali[j].partes[k].getX()==aux) {
											qualer[0]=1;
											dire = rand.nextInt(3) + 2;
											break;
										}
									}
									if(qualer[0]==1) break;
								}
								if(qualer[0]==0) foi=false;
							}
							else{
								qualer[0]=1;
								dire = rand.nextInt(3) + 2;
							}
						}
						else if(dire == 2 && qualer[1]==0){
							if(aux+tam-1<=9){
								int comp = aux+tam-1;
								for(int j=0;j<i;j++) {
									for(int k=0;k<barcosali[j].tam;k++){
										if(barcosali[j].partes[k].getX()<=comp && barcosali[j].partes[k].getX()>=aux && barcosali[j].partes[k].getY()==aux2) {
											qualer[1]=1;
											dire = rand.nextInt(4) + 1;
											break;
										}
									}
									if(qualer[1]==1) break;
								}
								if(qualer[1]==0) foi=false;
							}
							else {
								qualer[1]=1;
								dire = rand.nextInt(4) + 1;
							}
						}
						else if(dire == 3 && qualer[2]==0){
							if(aux2+tam-1<=9){
								int comp = aux2+tam-1;
								for(int j=0;j<i;j++) {
									for(int k=0;k<barcosali[j].tam;k++){
										if(barcosali[j].partes[k].getY()<=comp && barcosali[j].partes[k].getY()>=aux2 && barcosali[j].partes[k].getX()==aux) {
											qualer[2]=1;
											dire = rand.nextInt(4) + 1;
											break;
										}
									}
									if(qualer[2]==1) break;
								}
								if(qualer[2]==0) foi=false;
							}
							else {
								qualer[2]=1;
								dire = rand.nextInt(4) + 1;
							}
						}
						else if(dire == 4 && qualer[3]==0){
							if(aux-tam+1>=0){
								int comp = aux-tam+1;
								for(int j=0;j<i;j++) {
									for(int k=0;k<barcosali[j].tam;k++){
										if(barcosali[j].partes[k].getX()>=comp && barcosali[j].partes[k].getX()<=aux && barcosali[j].partes[k].getY()==aux2) {
											qualer[3]=1;
											dire = rand.nextInt(3) + 1;
											break;
										}
									}
									if(qualer[3]==1) break;
								}
								if(qualer[3]==0) foi=false;
							}
							else {
								qualer[3]=1;
								dire = rand.nextInt(3) + 1;
							}
						}
						if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
							aux = rand.nextInt(10);
							aux2 = rand.nextInt(10);
							inicial = new Coordenada(aux,aux2);
							for(int j=0;j<4;j++){
								qualer[j]=0;
							}
						}
					}
					barcosali[i] = new Barco(i,inicial,dire);
					foi=true;
				}
				
				foi=true;
				for(int i = 0; i<4 ; i++){
					if(i==0) tam = 4;
					else if(i==1) tam = 3;
					else if(i==2) tam = 2;
					else if(i==3) tam = 2;
					int qualer[] = {0,0,0,0};
					aux = rand.nextInt(10);
					aux2 = rand.nextInt(10);
					Coordenada inicial = new Coordenada(aux,aux2);
					while(foi){
						dire = rand.nextInt(4) + 1;
						if(dire == 1 && qualer[0]==0){
							if(aux2-tam+1>=0){
								int comp = aux2-tam+1;
								for(int j=0;j<i;j++) {
									for(int k=0;k<barcos[j].tam;k++){
										if(barcos[j].partes[k].getY()>=comp && barcos[j].partes[k].getY()<=aux2 && barcos[j].partes[k].getX()==aux) {
											qualer[0]=1;
											dire = rand.nextInt(3) + 2;
											break;
										}
									}
									if(qualer[0]==1) break;
								}
								if(qualer[0]==0) foi=false;
							}
							else{
								qualer[0]=1;
								dire = rand.nextInt(3) + 2;
							}
						}
						else if(dire == 2 && qualer[1]==0){
							if(aux+tam-1<=9){
								int comp = aux+tam-1;
								for(int j=0;j<i;j++) {
									for(int k=0;k<barcos[j].tam;k++){
										if(barcos[j].partes[k].getX()<=comp && barcos[j].partes[k].getX()>=aux && barcos[j].partes[k].getY()==aux2) {
											qualer[1]=1;
											dire = rand.nextInt(4) + 1;
											break;
										}
									}
									if(qualer[1]==1) break;
								}
								if(qualer[1]==0) foi=false;
							}
							else {
								qualer[1]=1;
								dire = rand.nextInt(4) + 1;
							}
						}
						else if(dire == 3 && qualer[2]==0){
							if(aux2+tam-1<=9){
								int comp = aux2+tam-1;
								for(int j=0;j<i;j++) {
									for(int k=0;k<barcos[j].tam;k++){
										if(barcos[j].partes[k].getY()<=comp && barcos[j].partes[k].getY()>=aux2 && barcos[j].partes[k].getX()==aux) {
											qualer[2]=1;
											dire = rand.nextInt(4) + 1;
											break;
										}
									}
									if(qualer[2]==1) break;
								}
								if(qualer[2]==0) foi=false;
							}
							else {
								qualer[2]=1;
								dire = rand.nextInt(4) + 1;
							}
						}
						else if(dire == 4 && qualer[3]==0){
							if(aux-tam+1>=0){
								int comp = aux-tam+1;
								for(int j=0;j<i;j++) {
									for(int k=0;k<barcos[j].tam;k++){
										if(barcos[j].partes[k].getX()>=comp && barcos[j].partes[k].getX()<=aux && barcos[j].partes[k].getY()==aux2) {
											qualer[3]=1;
											dire = rand.nextInt(3) + 1;
											break;
										}
									}
									if(qualer[3]==1) break;
								}
								if(qualer[3]==0) foi=false;
							}
							else {
								qualer[3]=1;
								dire = rand.nextInt(3) + 1;
							}
						}
						if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
							aux = rand.nextInt(10);
							aux2 = rand.nextInt(10);
							inicial = new Coordenada(aux,aux2);
							for(int j=0;j<4;j++){
								qualer[j]=0;
							}
						}
					}
					barcos[i] = new Barco(i,inicial,dire);
					foi=true;
				}	
				
				this.Mostra();
				
				JOptionPane.showMessageDialog(null,"Os barcos foram colocados de maneira aleatoria","",JOptionPane.WARNING_MESSAGE);
				okay = true;
			}
			else if(qual.equalsIgnoreCase("manual")){
				okay2=false;
				while(!okay2){
					String wut = JOptionPane.showInputDialog(this,"Você deseja inserir por arquivo ou interface gráfica?","",JOptionPane.WARNING_MESSAGE);
					if(wut == null){
						jogo.clipStop("Jogo");
						jogo.createMenu();
						this.dispose();
					}
					if(wut.equalsIgnoreCase("Interface Gráfica") || wut.equalsIgnoreCase("Interface Grafica") || wut.equalsIgnoreCase("Interface") || wut.equalsIgnoreCase("Gráfica") || wut.equalsIgnoreCase("Grafica")) {
						jogo.createPreGame();
						this.hue=1;
						JOptionPane.showMessageDialog(null,"Escolha os barcos, depois a coordenada desejada \n e por fim a direção do barco","",JOptionPane.WARNING_MESSAGE);
						okay = true;
						okay2=true;
						foi=true;
						for(int i = 0; i<4 ; i++){
							if(i==0) tam = 4;
							else if(i==1) tam = 3;
							else if(i==2) tam = 2;
							else if(i==3) tam = 2;
							int qualer[] = {0,0,0,0};
							aux = rand.nextInt(10);
							aux2 = rand.nextInt(10);
							Coordenada inicial = new Coordenada(aux,aux2);
							while(foi){
								dire = rand.nextInt(4) + 1;
								if(dire == 1 && qualer[0]==0){
									if(aux2-tam+1>=0){
										int comp = aux2-tam+1;
										for(int j=0;j<i;j++) {
											for(int k=0;k<barcos[j].tam;k++){
												if(barcos[j].partes[k].getY()>=comp && barcos[j].partes[k].getY()<=aux2 && barcos[j].partes[k].getX()==aux) {
													qualer[0]=1;
													dire = rand.nextInt(3) + 2;
													break;
												}
											}
											if(qualer[0]==1) break;
										}
										if(qualer[0]==0) foi=false;
									}
									else{
										qualer[0]=1;
										dire = rand.nextInt(3) + 2;
									}
								}
								else if(dire == 2 && qualer[1]==0){
									if(aux+tam-1<=9){
										int comp = aux+tam-1;
										for(int j=0;j<i;j++) {
											for(int k=0;k<barcos[j].tam;k++){
												if(barcos[j].partes[k].getX()<=comp && barcos[j].partes[k].getX()>=aux && barcos[j].partes[k].getY()==aux2) {
													qualer[1]=1;
													dire = rand.nextInt(4) + 1;
													break;
												}
											}
											if(qualer[1]==1) break;
										}
										if(qualer[1]==0) foi=false;
									}
									else {
										qualer[1]=1;
										dire = rand.nextInt(4) + 1;
									}
								}
								else if(dire == 3 && qualer[2]==0){
									if(aux2+tam-1<=9){
										int comp = aux2+tam-1;
										for(int j=0;j<i;j++) {
											for(int k=0;k<barcos[j].tam;k++){
												if(barcos[j].partes[k].getY()<=comp && barcos[j].partes[k].getY()>=aux2 && barcos[j].partes[k].getX()==aux) {
													qualer[2]=1;
													dire = rand.nextInt(4) + 1;
													break;
												}
											}
											if(qualer[2]==1) break;
										}
										if(qualer[2]==0) foi=false;
									}
									else {
										qualer[2]=1;
										dire = rand.nextInt(4) + 1;
									}
								}
								else if(dire == 4 && qualer[3]==0){
									if(aux-tam+1>=0){
										int comp = aux-tam+1;
										for(int j=0;j<i;j++) {
											for(int k=0;k<barcos[j].tam;k++){
												if(barcos[j].partes[k].getX()>=comp && barcos[j].partes[k].getX()<=aux && barcos[j].partes[k].getY()==aux2) {
													qualer[3]=1;
													dire = rand.nextInt(3) + 1;
													break;
												}
											}
											if(qualer[3]==1) break;
										}
										if(qualer[3]==0) foi=false;
									}
									else {
										qualer[3]=1;
										dire = rand.nextInt(3) + 1;
									}
								}
								if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
									aux = rand.nextInt(10);
									aux2 = rand.nextInt(10);
									inicial = new Coordenada(aux,aux2);
									for(int j=0;j<4;j++){
										qualer[j]=0;
									}
								}
							}
							barcos[i] = new Barco(i,inicial,dire);
							foi=true;
						}
					}
					else if(wut.equalsIgnoreCase("arquivo")){
						try{
							Scanner arq = new Scanner(new File("batalhanaval.txt"));
							int linha=0;
							int qualer[] = {0,0,0,0};
							foi=true;
							Coordenada inicial=null;
							while(arq.hasNext()){
								linha++;
								String lin = arq.nextLine();
								char[] linc = lin.toCharArray();
								if(linc.length<4 || linc.length>5){
									JOptionPane.showMessageDialog(null,"A linha: "+linha+" esta com problemas, o barco foi colocado de forma aleatória","",JOptionPane.WARNING_MESSAGE);
									continue;
								}
								else{
									tam = Character.getNumericValue(linc[0]);
									if(tam!=2 && tam!=4 && tam!=3){
										JOptionPane.showMessageDialog(null,"A linha: "+linha+" esta com problemas, o barco foi colocado de forma aleatória","",JOptionPane.WARNING_MESSAGE);
										continue;
									}
									int x=0;
									if(linc[2]=='A' || linc[2]=='a'){
										x=0;
									}
									else if(linc[2]=='B' || linc[2]=='b'){
										x=1;
									}
									else if(linc[2]=='C' || linc[2]=='c'){
										x=2;
									}
									else if(linc[2]=='D' || linc[2]=='d'){
										x=3;
									}
									else if(linc[2]=='E' || linc[2]=='e'){
										x=4;
									}
									else if(linc[2]=='F' || linc[2]=='f'){
										x=5;
									}
									else if(linc[2]=='G' || linc[2]=='g'){
										x=6;
									}
									else if(linc[2]=='H' || linc[2]=='h'){
										x=7;
									}
									else if(linc[2]=='I' || linc[2]=='i'){
										x=8;
									}
									else if(linc[2]=='J' || linc[2]=='j'){
										x=9;	
									}
									else{
										JOptionPane.showMessageDialog(null,"A linha: "+linha+" esta com problemas, o barco foi colocado de forma aleatória","",JOptionPane.WARNING_MESSAGE);
										continue;
									}
									int y=0;
									if(linc.length==4){
										y = Character.getNumericValue(linc[3]) - 1;
										if(y<1 || y>10){
											JOptionPane.showMessageDialog(null,"A linha: "+linha+" esta com problemas, o barco foi colocado de forma aleatória","",JOptionPane.WARNING_MESSAGE);
											continue;
										}
									}
									if(linc.length==5){
										if(linc[3]=='1' && linc[4]=='0'){
											y=9;
										}
										else{
											JOptionPane.showMessageDialog(null,"A linha: "+linha+" esta com problemas, o barco foi colocado de forma aleatória","",JOptionPane.WARNING_MESSAGE);
											continue;	
										}
									}
									aux = x;
									aux2 = y;
									inicial = new Coordenada(aux,aux2);
									int i=0;
									if(tam==4){
										i=0;
									}
									else if(tam==3){
										i=1;
									}
									else if(tam==2 && barcosali[3]==null){
										i=3;
									}
									else if(tam==2 && barcosali[2]==null){
										i=2;
									}
									while(foi){
										dire = rand.nextInt(4) + 1;
										if(dire == 1 && qualer[0]==0){
											if(aux2-tam+1>=0){
												int comp = aux2-tam+1;
												for(int j=0;j<i;j++){
													if(barcosali[j]!=null){
														for(int k=0;k<barcosali[j].tam;k++){
															if(barcosali[j].partes[k].getY()>=comp && barcosali[j].partes[k].getY()<=aux2 && barcosali[j].partes[k].getX()==aux) {
																qualer[0]=1;
																dire = rand.nextInt(3) + 2;
																break;
															}
														}
														if(qualer[0]==1) break;
													}
												}
												if(qualer[0]==0) foi=false;
											}
											else{
												qualer[0]=1;
												dire = rand.nextInt(3) + 2;
											}
										}
										else if(dire == 2 && qualer[1]==0){
											if(aux+tam-1<=9){
												int comp = aux+tam-1;
												for(int j=0;j<i;j++) {
													if(barcosali[j]!=null){
														for(int k=0;k<barcosali[j].tam;k++){
															if(barcosali[j].partes[k].getX()<=comp && barcosali[j].partes[k].getX()>=aux && barcosali[j].partes[k].getY()==aux2) {
																qualer[1]=1;
																dire = rand.nextInt(4) + 1;
																break;
															}
														}
														if(qualer[1]==1) break;
													}
												}
												if(qualer[1]==0) foi=false;
											}
											else {
												qualer[1]=1;
												dire = rand.nextInt(4) + 1;
											}
										}
										else if(dire == 3 && qualer[2]==0){
											if(aux2+tam-1<=9){
												int comp = aux2+tam-1;
												for(int j=0;j<i;j++) {
													if(barcosali[j]!=null){
														for(int k=0;k<barcosali[j].tam;k++){
															if(barcosali[j].partes[k].getY()<=comp && barcosali[j].partes[k].getY()>=aux2 && barcosali[j].partes[k].getX()==aux) {
																qualer[2]=1;
																dire = rand.nextInt(4) + 1;
																break;
															}
														}
														if(qualer[2]==1) break;
													}
												}
												if(qualer[2]==0) foi=false;
											}
											else {
												qualer[2]=1;
												dire = rand.nextInt(4) + 1;
											}
										}
										else if(dire == 4 && qualer[3]==0){
											if(aux-tam+1>=0){
												int comp = aux-tam+1;
												for(int j=0;j<i;j++) {
													if(barcosali[j]!=null){
														for(int k=0;k<barcosali[j].tam;k++){
															if(barcosali[j].partes[k].getX()>=comp && barcosali[j].partes[k].getX()<=aux && barcosali[j].partes[k].getY()==aux2) {
																qualer[3]=1;
																dire = rand.nextInt(3) + 1;
																break;
															}
														}
														if(qualer[3]==1) break;
													}
												}
												if(qualer[3]==0) foi=false;
											}
											else {
												qualer[3]=1;
												dire = rand.nextInt(3) + 1;
											}
										}
										if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
											JOptionPane.showMessageDialog(null,"O barco da linha: "+linha+" não pode ser colocado nessa posição, a nova posição foi escolhida aleatoriamente","",JOptionPane.WARNING_MESSAGE);
											aux = rand.nextInt(10);
											aux2 = rand.nextInt(10);
											inicial = new Coordenada(aux,aux2);
											for(int j=0;j<4;j++){
												qualer[j]=0;
											}
										}
									}
									barcosali[i] = new Barco(i,inicial,dire);
									foi=true;
								}
							}
							foi=true;
							for(int i=0;i<4;i++){
								if(barcosali[i]==null){
									if(i==0) tam = 4;
									else if(i==1) tam = 3;
									else if(i==2) tam = 2;
									else if(i==3) tam = 2;
									qualer[0] = 0;
									qualer[1] = 0;
									qualer[2] = 0;
									qualer[3] = 0;
									aux = rand.nextInt(10);
									aux2 = rand.nextInt(10);
									inicial = new Coordenada(aux,aux2);
									while(foi){
										dire = rand.nextInt(4) + 1;
										if(dire == 1 && qualer[0]==0){
											if(aux2-tam+1>=0){
												int comp = aux2-tam+1;
												for(int j=0;j<i;j++) {
													for(int k=0;k<barcosali[j].tam;k++){
														if(barcosali[j].partes[k].getY()>=comp && barcosali[j].partes[k].getY()<=aux2 && barcosali[j].partes[k].getX()==aux) {
															qualer[0]=1;
															dire = rand.nextInt(3) + 2;
															break;
														}
													}
													if(qualer[0]==1) break;
												}
												if(qualer[0]==0) foi=false;
											}
											else{
												qualer[0]=1;
												dire = rand.nextInt(3) + 2;
											}
										}
										else if(dire == 2 && qualer[1]==0){
											if(aux+tam-1<=9){
												int comp = aux+tam-1;
												for(int j=0;j<i;j++) {
													for(int k=0;k<barcosali[j].tam;k++){
														if(barcosali[j].partes[k].getX()<=comp && barcosali[j].partes[k].getX()>=aux && barcosali[j].partes[k].getY()==aux2) {
															qualer[1]=1;
															dire = rand.nextInt(4) + 1;
															break;
														}
													}
													if(qualer[1]==1) break;
												}
												if(qualer[1]==0) foi=false;
											}
											else {
												qualer[1]=1;
												dire = rand.nextInt(4) + 1;
											}
										}
										else if(dire == 3 && qualer[2]==0){
											if(aux2+tam-1<=9){
												int comp = aux2+tam-1;
												for(int j=0;j<i;j++) {
													for(int k=0;k<barcosali[j].tam;k++){
														if(barcosali[j].partes[k].getY()<=comp && barcosali[j].partes[k].getY()>=aux2 && barcosali[j].partes[k].getX()==aux) {
															qualer[2]=1;
															dire = rand.nextInt(4) + 1;
															break;
														}
													}
													if(qualer[2]==1) break;
												}
												if(qualer[2]==0) foi=false;
											}
											else {
												qualer[2]=1;
												dire = rand.nextInt(4) + 1;
											}
										}
										else if(dire == 4 && qualer[3]==0){
											if(aux-tam+1>=0){
												int comp = aux-tam+1;
												for(int j=0;j<i;j++) {
													for(int k=0;k<barcosali[j].tam;k++){
														if(barcosali[j].partes[k].getX()>=comp && barcosali[j].partes[k].getX()<=aux && barcosali[j].partes[k].getY()==aux2) {
															qualer[3]=1;
															dire = rand.nextInt(3) + 1;
															break;
														}
													}
													if(qualer[3]==1) break;
												}
												if(qualer[3]==0) foi=false;
											}
											else {
												qualer[3]=1;
												dire = rand.nextInt(3) + 1;
											}
										}
										if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
											aux = rand.nextInt(10);
											aux2 = rand.nextInt(10);
											inicial = new Coordenada(aux,aux2);
											for(int j=0;j<4;j++){
												qualer[j]=0;
											}
										}
									}
									barcosali[i] = new Barco(i,inicial,dire);
									foi=true;
								}
							}
							arq.close();
							this.Mostra();
							foi=true;
							for(int i = 0; i<4 ; i++){
								if(i==0) tam = 4;
								else if(i==1) tam = 3;
								else if(i==2) tam = 2;
								else if(i==3) tam = 2;
								qualer[0] = 0;
								qualer[1] = 0;
								qualer[2] = 0;
								qualer[3] = 0;
								aux = rand.nextInt(10);
								aux2 = rand.nextInt(10);
								inicial = new Coordenada(aux,aux2);
								while(foi){
									dire = rand.nextInt(4) + 1;
									if(dire == 1 && qualer[0]==0){
										if(aux2-tam+1>=0){
											int comp = aux2-tam+1;
											for(int j=0;j<i;j++) {
												for(int k=0;k<barcos[j].tam;k++){
													if(barcos[j].partes[k].getY()>=comp && barcos[j].partes[k].getY()<=aux2 && barcos[j].partes[k].getX()==aux) {
														qualer[0]=1;
														dire = rand.nextInt(3) + 2;
														break;
													}
												}
												if(qualer[0]==1) break;
											}
											if(qualer[0]==0) foi=false;
										}
										else{
											qualer[0]=1;
											dire = rand.nextInt(3) + 2;
										}
									}
									else if(dire == 2 && qualer[1]==0){
										if(aux+tam-1<=9){
											int comp = aux+tam-1;
											for(int j=0;j<i;j++) {
												for(int k=0;k<barcos[j].tam;k++){
													if(barcos[j].partes[k].getX()<=comp && barcos[j].partes[k].getX()>=aux && barcos[j].partes[k].getY()==aux2) {
														qualer[1]=1;
														dire = rand.nextInt(4) + 1;
														break;
													}
												}
												if(qualer[1]==1) break;
											}
											if(qualer[1]==0) foi=false;
										}
										else {
											qualer[1]=1;
											dire = rand.nextInt(4) + 1;
										}
									}
									else if(dire == 3 && qualer[2]==0){
										if(aux2+tam-1<=9){
											int comp = aux2+tam-1;
											for(int j=0;j<i;j++) {
												for(int k=0;k<barcos[j].tam;k++){
													if(barcos[j].partes[k].getY()<=comp && barcos[j].partes[k].getY()>=aux2 && barcos[j].partes[k].getX()==aux) {
														qualer[2]=1;
														dire = rand.nextInt(4) + 1;
														break;
													}
												}
												if(qualer[2]==1) break;
											}
											if(qualer[2]==0) foi=false;
										}
										else {
											qualer[2]=1;
											dire = rand.nextInt(4) + 1;
										}
									}
									else if(dire == 4 && qualer[3]==0){
										if(aux-tam+1>=0){
											int comp = aux-tam+1;
											for(int j=0;j<i;j++) {
												for(int k=0;k<barcos[j].tam;k++){
													if(barcos[j].partes[k].getX()>=comp && barcos[j].partes[k].getX()<=aux && barcos[j].partes[k].getY()==aux2) {
														qualer[3]=1;
														dire = rand.nextInt(3) + 1;
														break;
													}
												}
												if(qualer[3]==1) break;
											}
											if(qualer[3]==0) foi=false;
										}
										else {
											qualer[3]=1;
											dire = rand.nextInt(3) + 1;
										}
									}
									if(qualer[0]==1 && qualer[1]==1 && qualer[2]==1 && qualer[3]==1){
										aux = rand.nextInt(10);
										aux2 = rand.nextInt(10);
										inicial = new Coordenada(aux,aux2);
										for(int j=0;j<4;j++){
											qualer[j]=0;
										}
									}
								}
								barcos[i] = new Barco(i,inicial,dire);
								foi=true;
							}
							okay2=true;
							okay=true;
						}
						catch(FileNotFoundException e){
							JOptionPane.showMessageDialog(null,"O arquivo não foi encontrado, escolha novamente a opção desejada","",JOptionPane.WARNING_MESSAGE);
							okay2=true;
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"Comando invalido !!! Tente novamente","",JOptionPane.WARNING_MESSAGE);		
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Comando invalido !!! Tente novamente","",JOptionPane.WARNING_MESSAGE);
				qual = JOptionPane.showInputDialog(this,"Deseja que os barcos sejam colocados de maneira aleatoria ou manual?","",JOptionPane.WARNING_MESSAGE);
				if(qual == null){
					jogo.clipStop("Jogo");
					jogo.createMenu();
					this.dispose();
				}
			}
		}
		this.barcos = barcos;
	}
	public void addComponentsToPane() {
		final JPanelTwo compsToExperiment = new JPanelTwo(1);
		final JPanelTwo teste = new JPanelTwo(2);
		final JPanelTwo tiro = new JPanelTwo(3);
		
		ImageIcon icon = new ImageIcon("Agua//WaterNoClick.jpg");
		ImageIcon icon2 = new ImageIcon("Agua//WaterNoClick.jpg");
		Escolta = new ImageIcon("Navios//Escolta2.jpg");
		Submarino = new ImageIcon("Navios//Submarino2.jpg");
		Caca = new ImageIcon("Navios//Caca2.jpg");
		ImageIcon NovoJogo = new ImageIcon("Botoes//NovoJogo.jpg");
		ImageIcon Restart = new ImageIcon("Botoes//Restart.jpg");
		ImageIcon Dica = new ImageIcon("Botoes//Dica.jpg");
		ImageIcon VoltarMenu = new ImageIcon("Botoes//VoltarMenu.jpg");
		ImageIcon Dicas = new ImageIcon("Botoes//DicaS.jpg");
		ImageIcon NovoJogos = new ImageIcon("Botoes//NovoJogoS.jpg");
		ImageIcon Restarts = new ImageIcon("Botoes//RestartS.jpg");
		ImageIcon VoltarMenus = new ImageIcon("Botoes//VoltarMenuS.jpg");
		CacaS = new ImageIcon("Navios//CacaS.jpg");
		EscoltaS = new ImageIcon("Navios//EscoltaS.jpg");
		SubmarinoS = new ImageIcon("Navios//SubmarinoS.jpg");
		
		int largura = 135;
		int altura = 127;
		
		icon2.setImage(icon2.getImage().getScaledInstance(50, 47, 100));
		
		Escolta.setImage(Escolta.getImage().getScaledInstance(largura, altura, 100));
		Submarino.setImage(Submarino.getImage().getScaledInstance(largura, altura, 100));
		Caca.setImage(Caca.getImage().getScaledInstance(largura, altura, 100));
		
		NovoJogo.setImage(NovoJogo.getImage().getScaledInstance(largura, altura, 100));
		Restart.setImage(Restart.getImage().getScaledInstance(largura, altura, 100));
		Dica.setImage(Dica.getImage().getScaledInstance(largura, altura, 100));
		VoltarMenu.setImage(VoltarMenu.getImage().getScaledInstance(largura, altura, 100));
		
		
		NovoJogos.setImage(NovoJogos.getImage().getScaledInstance(largura, altura, 100));
		Restarts.setImage(Restarts.getImage().getScaledInstance(largura, altura, 100));
		Dicas.setImage(Dicas.getImage().getScaledInstance(largura, altura, 100));
		VoltarMenus.setImage(VoltarMenus.getImage().getScaledInstance(largura, altura, 100));
		CacaS.setImage(CacaS.getImage().getScaledInstance(largura,altura,100));
		EscoltaS.setImage(EscoltaS.getImage().getScaledInstance(largura,altura,100));
		SubmarinoS.setImage(SubmarinoS.getImage().getScaledInstance(largura,altura,100));
		
		
		compsToExperiment.setLayout(experimentLayout);
		teste.setLayout(experimentLayout);
		tiro.setLayout(layout);
		
		teste.setPreferredSize(new Dimension(600,500));
		compsToExperiment.setPreferredSize(new Dimension(600,500));
		tiro.setPreferredSize(new Dimension(70,128));
		
		table = new JButton[10][10];
		table2 = new JButton[10][10];
		tiros = new JButton[7];

		tiros[3] = new JButton(Dica);
		tiros[4] = new JButton(NovoJogo);
		tiros[5] = new JButton(Restart);
		tiros[6] = new JButton(VoltarMenu);
		tiros[0] = new JButton(Submarino);
		tiros[1] = new JButton(Escolta);
		tiros[2] = new JButton(Caca);
		
		tiros[3].setRolloverIcon(Dicas);
		tiros[4].setRolloverIcon(NovoJogos);
		tiros[5].setRolloverIcon(Restarts);
		tiros[6].setRolloverIcon(VoltarMenus);
		tiros[0].setRolloverIcon(SubmarinoS);
		tiros[1].setRolloverIcon(EscoltaS);
		tiros[2].setRolloverIcon(CacaS);
		
		for(int i=0;i<7;i++) {
			tiros[i].setMargin(new Insets(0, 0, 0, 0));
			tiros[i].setBorder(null);
			tiros[i].setOpaque(false);
			tiros[i].setContentAreaFilled(false);
			tiros[i].setBorderPainted(false);
			tiros[i].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playSoundE("Efeitos//BotaoEntered.wav", -5.0f, false);
			}
			});
		}
		
		for(int i = 0; i<7; i++) {
			tiros[i].addActionListener(this);
			tiros[i].setPreferredSize(new Dimension(10,10));
		}
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++){
				table[i][j] = new JButton(icon2);
				table2[i][j] = new JButton(icon);

				table[i][j].setPreferredSize(new Dimension(10,10));
				table2[i][j].setPreferredSize(new Dimension(10,10));
				table2[i][j].addActionListener(this);
				table2[i][j].setMargin(new Insets(0, 0, 0, 0));
				table2[i][j].setBorder(null);
				table2[i][j].setOpaque(false);
				table2[i][j].setContentAreaFilled(false);
				table2[i][j].setBorderPainted(false);
				table[i][j].setMargin(new Insets(0, 0, 0, 0));
				table[i][j].setBorder(null);
				table[i][j].setOpaque(false);
				table[i][j].setContentAreaFilled(false);
				table[i][j].setBorderPainted(false);
			}
		}	
		for(int i=0; i<14;i++){
			compsToExperiment.add(new JLabel("  "));
			teste.add(new JLabel(" "));
		}
		
		//primeira linha
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel("  "));
			teste.add(new JLabel(" "));
		}
		for(int i=0;i<10;i++) {
			compsToExperiment.add(labelsFirst[i]);
			teste.add(labelsSecond[i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//segunda linha
		
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[10]);
		teste.add(labelsSecond[10]);
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[0][i]);
			teste.add(table2[0][i]);
		}
		
		for(int i=3; i<7;i++) {
			tiro.add(tiros[i]);
		}
		
		tiro.add(new JLabel(" "));
		tiro.add(new JLabel(" "));
		
		for(int i=0;i<3;i++) {
			tiro.add(tiros[i]);
		}
		
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//terceira linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[11]);
		teste.add(labelsSecond[11]);
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[1][i]);
			teste.add(table2[1][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//quarta linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[12]);
		teste.add(labelsSecond[12]);
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[2][i]);
			teste.add(table2[2][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//quinta linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[13]);
		teste.add(labelsSecond[13]);
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[3][i]);
			teste.add(table2[3][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//sexta linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[14]);
		teste.add(labelsSecond[14]);
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[4][i]);
			teste.add(table2[4][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//setima linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[15]);
		teste.add(labelsSecond[15]);
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[5][i]);
			teste.add(table2[5][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//oitava linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[16]);
		teste.add(labelsSecond[16]);
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[6][i]);
			teste.add(table2[6][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//nona linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[17]);
		teste.add(labelsSecond[17]);
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[7][i]);
			teste.add(table2[7][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//decima linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[18]);
		teste.add(labelsSecond[18]);
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[8][i]);
			teste.add(table2[8][i]);
		}
		
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}
		
		//decima primeira linha
		compsToExperiment.add(new JLabel(" "));
		teste.add(new JLabel(" "));
		compsToExperiment.add(labelsFirst[19]);
		teste.add(labelsSecond[19]);
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[9][i]);
			teste.add(table2[9][i]);
		}
		for(int i=0; i<10;i++){
			compsToExperiment.add(new JLabel(" "));
			teste.add(new JLabel(" "));
		}

		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				table2[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						playSoundE("Efeitos//Agua2.wav", -5.0f, false);
					}
				});
				table[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						playSoundE("Efeitos//Agua2.wav", -5.0f, false);
					}
				});
			}
		}
		//adicionando os componente no ContentPane do Frame
		this.getContentPane().add(compsToExperiment, BorderLayout.CENTER);
		this.getContentPane().add(teste, BorderLayout.EAST);
		this.getContentPane().add(tiro, BorderLayout.NORTH);
		
	}
	public void PCjoga(){
		Random rand = new Random();
		int x,y,tiro=0;
		int cont=0;
		int cont2=0;
		int cont3=0;
		int cont4=0;
		int cont5=0;
		
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		
		if(barcos[3].vivo==true){
			tiro=3;
		}
		else if(barcos[1].vivo==true){
			tiro=2;
		}
		else if(barcos[2].vivo==true)
		{
			tiro=1;
		}
		if(tiro==0){
			jogo.clipStop("Jogo");
			this.setVisible(false);
			this.jogo.createPosGame(true);
		}
		else {
			playSoundE("Efeitos//tiro.wav",-6.0f,false);
		}
		for(int i =0;i<4;i++){
			if(prox[i]!=null && barcosali[i].vivo==false){
				prox[i]=null;
			}
		}
		if(prox[0]==null && prox[1]==null && prox[2]==null && prox[3]==null){
			proximo=0;
		}
		if(proximo==0){
			do{
				x = rand.nextInt(10);
				y = rand.nextInt(10);
			}while(quais[y][x]==1);
		}
		else if(proximo==1){
			if(prox[3]!=null){
				
				if(barcosali[3].partes[0].getX()==prox[3].getX() && barcosali[3].partes[0].getY()==prox[3].getY()){
					x=barcosali[3].partes[1].getX();
					y=barcosali[3].partes[1].getY();
					if(quais[y][x]==1){
						do{
							x = rand.nextInt(10);
							y = rand.nextInt(10);
						}while(quais[y][x]==1);				
					}
				}
				if(barcosali[3].partes[1].getX()==prox[3].getX() && barcosali[3].partes[1].getY()==prox[3].getY()){
					x=barcosali[3].partes[0].getX();
					y=barcosali[3].partes[0].getY();
					if(quais[y][x]==1){
						do{
							x = rand.nextInt(10);
							y = rand.nextInt(10);
						}while(quais[y][x]==1);				
					}
				}
				prox[3]=null;
			}
			if(prox[3]==null){
				if(prox[1]!=null){
					if(barcosali[1].partes[0].getX()==prox[1].getX() && barcosali[1].partes[0].getY()==prox[1].getY()){
						x=barcosali[1].partes[1].getX();
						y=barcosali[1].partes[1].getY();
						if(quais[y][x]==1){
							x=barcosali[1].partes[2].getX();
							y=barcosali[1].partes[2].getY();
							if(quais[y][x]==1){
								do{
									x = rand.nextInt(10);
									y = rand.nextInt(10);
								}while(quais[y][x]==1);
							}
						}
					}
					if(barcosali[1].partes[1].getX()==prox[1].getX() && barcosali[1].partes[1].getY()==prox[1].getY()){
						x=barcosali[1].partes[0].getX();
						y=barcosali[1].partes[0].getY();
						if(quais[y][x]==1){
							x=barcosali[1].partes[2].getX();
							y=barcosali[1].partes[2].getY();
							if(quais[y][x]==1){
								do{
									x = rand.nextInt(10);
									y = rand.nextInt(10);
								}while(quais[y][x]==1);
							}
						}
					}
					if(barcosali[1].partes[2].getX()==prox[1].getX() && barcosali[1].partes[2].getY()==prox[1].getY()){
						x=barcosali[1].partes[1].getX();
						y=barcosali[1].partes[1].getY();
						if(quais[y][x]==1){
							x=barcosali[1].partes[0].getX();
							y=barcosali[1].partes[0].getY();
							if(quais[y][x]==1){
								do{
									x = rand.nextInt(10);
									y = rand.nextInt(10);
								}while(quais[y][x]==1);
							}
						}
					}
					prox[1]=null;
				}
				if(prox[1]==null){
					if(prox[2]!=null){
						if(barcosali[2].partes[0].getX()==prox[2].getX() && barcosali[2].partes[0].getY()==prox[2].getY()){
							x=barcosali[2].partes[1].getX();
							y=barcosali[2].partes[1].getY();
							if(quais[y][x]==1){
								do{
									x = rand.nextInt(10);
									y = rand.nextInt(10);
								}while(quais[y][x]==1);				
							}
						}
						if(barcosali[2].partes[1].getX()==prox[2].getX() && barcosali[2].partes[1].getY()==prox[2].getY()){
							x=barcosali[2].partes[0].getX();
							y=barcosali[2].partes[0].getY();
							if(quais[y][x]==1){
								do{
									x = rand.nextInt(10);
									y = rand.nextInt(10);
								}while(quais[y][x]==1);				
							}
						}
						prox[2]=null;
					}
					if(prox[2]==null){
						if(prox[0]!=null){
							if(barcosali[0].partes[0].getX()==prox[0].getX() && barcosali[0].partes[0].getY()==prox[0].getY()){
								x=barcosali[0].partes[1].getX();
								y=barcosali[0].partes[1].getY();
								if(quais[y][x]==1){
									x=barcosali[0].partes[2].getX();
									y=barcosali[0].partes[2].getY();
									if(quais[y][x]==1){
										x=barcosali[0].partes[3].getX();
										y=barcosali[0].partes[3].getY();
										if(quais[y][x]==1){
											do{
												x = rand.nextInt(10);
												y = rand.nextInt(10);
											}while(quais[y][x]==1);
										}
									}
								}
							}
							if(barcosali[0].partes[1].getX()==prox[0].getX() && barcosali[0].partes[1].getY()==prox[0].getY()){
								x=barcosali[0].partes[0].getX();
								y=barcosali[0].partes[0].getY();
								if(quais[y][x]==1){
									x=barcosali[0].partes[2].getX();
									y=barcosali[0].partes[2].getY();
									if(quais[y][x]==1){
										x=barcosali[0].partes[3].getX();
										y=barcosali[0].partes[3].getY();
										if(quais[y][x]==1){
											do{
												x = rand.nextInt(10);
												y = rand.nextInt(10);
											}while(quais[y][x]==1);
										}
									}
								}
							}
							if(barcosali[0].partes[2].getX()==prox[0].getX() && barcosali[0].partes[2].getY()==prox[0].getY()){
								x=barcosali[0].partes[1].getX();
								y=barcosali[0].partes[1].getY();
								if(quais[y][x]==1){
									x=barcosali[0].partes[0].getX();
									y=barcosali[0].partes[0].getY();
									if(quais[y][x]==1){
										x=barcosali[0].partes[3].getX();
										y=barcosali[0].partes[3].getY();
										if(quais[y][x]==1){
											do{
												x = rand.nextInt(10);
												y = rand.nextInt(10);
											}while(quais[y][x]==1);
										}
									}
								}
							}
							if(barcosali[0].partes[3].getX()==prox[0].getX() && barcosali[0].partes[3].getY()==prox[0].getY()){
								x=barcosali[0].partes[1].getX();
								y=barcosali[0].partes[1].getY();
								if(quais[y][x]==1){
									x=barcosali[0].partes[2].getX();
									y=barcosali[0].partes[2].getY();
									if(quais[y][x]==1){
										x=barcosali[0].partes[0].getX();
										y=barcosali[0].partes[0].getY();
										if(quais[y][x]==1){
											do{
												x = rand.nextInt(10);
												y = rand.nextInt(10);
											}while(quais[y][x]==1);
										}
									}
								}
							}
							prox[0]=null;
						}
					}
				}
			}
			if(prox[0]==null && prox[1]==null && prox[2]==null && prox[3]==null){
				proximo=0;
			}
		}
		if(tiro == 1  || tiro==2 || tiro == 3){	
			for(int k = 0; k<4 ; k++){
				for(int h = 0; h<barcosali[k].tam ; h++){
					if(barcosali[k].partes[h].getX() == x && barcosali[k].partes[h].getY() == y){
						if(k==0){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
						}
						else if(k==1){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
						}
						else if(k==2){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
						}
						else if(k==3){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
						}
						barcosali[k].quando += 1;
						if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						proximo=1;
						prox[k]=new Coordenada(x,y);
					}
					else{
					
						cont++;
					}
				}
			}
			if(cont==11){
				ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
				int largura = 50;
				int altura = 47;
				minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
				table[y][x].setIcon(minhaImagem);
				table[y][x].removeActionListener(this);
				
			}
			quais[y][x]=1;
		}
		if((tiro==3 || tiro == 2) && x<=8){
			for(int k = 0; k<4 ; k++){
				for(int h = 0; h<barcosali[k].tam ; h++){
					if(barcosali[k].partes[h].getX() == x+1 && barcosali[k].partes[h].getY() == y){
						if(k==0){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==1){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==2){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando == barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==3){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						proximo=1;
						prox[k]=new Coordenada(x+1,y);
					}
					else{
						cont2++;
					}
				}
			}
			if(cont2==11){
				ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
				int largura = 50;
				int altura = 47;
				minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
				table[y][x+1].setIcon(minhaImagem);
				table[y][x+1].removeActionListener(this);
			}
			quais[y][x+1]=1;
		}
		if(tiro==3 && x>=1){
			for(int k = 0; k<4 ; k++){
				for(int h = 0; h<barcosali[k].tam ; h++){
					if(barcosali[k].partes[h].getX() == x-1 && barcosali[k].partes[h].getY() == y){
						if(k==0){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==1){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==2){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando == barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==3){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						proximo=1;
						prox[k]=new Coordenada(x-1,y);
					}
					else{
						cont3++;
					}
				}
			}
			if(cont3==11){
				ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
				int largura = 50;
				int altura = 47;
				minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
				table[y][x-1].setIcon(minhaImagem);
				table[y][x-1].removeActionListener(this);
			}
			quais[y][x-1]=1;
		}
		if(tiro==3 && y>=1){
			for(int k = 0; k<4 ; k++){
				for(int h = 0; h<barcosali[k].tam ; h++){
					if(barcosali[k].partes[h].getX() == x && barcosali[k].partes[h].getY() == y-1){
						if(k==0){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==1){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==2){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando == barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==3){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						proximo=1;
						prox[k]=new Coordenada(x,y-1);
					}
					else{
						cont4++;
					}
				}
			}
			if(cont4==11){
				ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
				int largura = 50;
				int altura = 47;
				minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
				table[y-1][x].setIcon(minhaImagem);
				table[y-1][x].removeActionListener(this);
			}
			quais[y-1][x]=1;
		}
		if(tiro==3 && y<=8){
			for(int k = 0; k<4 ; k++){
				for(int h = 0; h<barcosali[k].tam ; h++){
					if(barcosali[k].partes[h].getX() == x && barcosali[k].partes[h].getY() == y+1){
						if(k==0){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==1){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==2){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando == barcosali[k].tam) barcosali[k].vivo = false;
						}
						else if(k==3){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("Navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("Navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							barcosali[k].quando += 1;
							if(barcosali[k].quando==barcosali[k].tam) barcosali[k].vivo = false;
						}
						proximo=1;
						prox[k]=new Coordenada(x,y+1);
					}
					else{
						cont5++;
					}
				}
			}
			if(cont5==11){
				ImageIcon minhaImagem = new ImageIcon("agua//WaterClicked.jpg");
				int largura = 50;
				int altura = 47;
				minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
				table[y+1][x].setIcon(minhaImagem);
				table[y+1][x].removeActionListener(this);
				
			}
			quais[y+1][x]=1;
		}
		if(barcosali[1].vivo==false && barcosali[2].vivo==false && barcosali[3].vivo==false) {
			jogo.clipStop("Jogo");
			this.setVisible(false);
			this.jogo.createPosGame(false);
		}
	}
}