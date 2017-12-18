package jogo;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Tabuleiro extends JFrame implements ActionListener{
	private static final long serialVersionUID = 7526472295622776147L;
	private GridLayout experimentLayout = new GridLayout(13,12,-1,-1);
	private GridLayout layout = new GridLayout(1,3,-2,-2);
	private JButton table[][],table2[][],tiros[];
	private Barco barcos[];
	private Barco barcosali[];
	private int tiro;
	private int hue;
	private int dica;
	private int quais[][];
	private int debug[][];
	private int proximo;
	private Coordenada[] prox;
	private PMotor jogo;

	public Tabuleiro(String n,PMotor jogo){
		super(n);
		//setSize(400,260);
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
			}
			for(int j=0;j<10;j++) {
				quais[i][j]=0;
				debug[i][j]=0;
			}
		}
	}
	public void actionPerformed(ActionEvent e){
		Object object = e.getSource();
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
						if(tiro==0){
							JOptionPane.showMessageDialog(this,"escolha um tipo de tiro ou a dica para realizar uma ação");
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
											barcos[k].quando += 1;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
										}
										aux=1;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
										}
										aux=1;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
										}
										aux=1;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
										}
										aux=1;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando == barcos[k].tam) barcos[k].vivo = false;
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
											barcos[k].quando += 1;
											if(barcos[k].quando==barcos[k].tam) barcos[k].vivo = false;
										}
										aux=1;
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
								JOptionPane.showMessageDialog(this,"Tem um barco nessa linha");
								tiro=0;
							}
							else{
								JOptionPane.showMessageDialog(this,"Não tem um barco nessa linha");
								tiro=0;
							}
							if(deubom==1){
								JOptionPane.showMessageDialog(this,"Tem um barco nessa coluna");
								tiro=0;
							}
							else{
								JOptionPane.showMessageDialog(this,"Não tem um barco nessa coluna");
								tiro=0;
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
							JOptionPane.showMessageDialog(this,"Voce não terminou de preencher os barcos,por favor termine");
						}
					}
				}
			}
		}
		if(aux2==1 && aux==0) {
			JOptionPane.showMessageDialog(this,"voce não encontrou nada");
			this.PCjoga();
		}
		if(aux==1) {
			JOptionPane.showMessageDialog(this,"Parabens voce achou um navio");
			this.PCjoga();
		}
		tiro=0;
		for(int i=0;i<7;i++){
			if (object == tiros[i]){
				if(hue==0){
					if(i==0){
						if(barcosali[2].vivo == true) tiro=1;
						else JOptionPane.showMessageDialog(this,"voce não tem mais esse barco"); 
					}
					if(i==1){
						if(barcosali[1].vivo == true) tiro=2;
						else JOptionPane.showMessageDialog(this,"voce não tem mais esse barco"); 
					}
					if(i==2){
						if(barcosali[3].vivo == true) tiro=3;
						else JOptionPane.showMessageDialog(this,"voce não tem mais esse barco"); 
					}
					if(i==3){
						if(dica!=0){
							boolean result = JOptionPane.showConfirmDialog(this, "voce tem "+dica+" dicas,deseja realmente utilizar uma?","", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
							if(result == true) {
								tiro=4;
								dica--;
							}
						}
						else JOptionPane.showMessageDialog(this,"Voce não tem mais dicas");
					}
					if(i==4){
						boolean result = JOptionPane.showConfirmDialog(this, "Deseja criar um novo jogo?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
						if(result == true) {
							this.dispose();
							jogo.createGame();
						}
					}
					if(i==5){
						boolean result = JOptionPane.showConfirmDialog(this, "O jogo será reinicializado. \n Deseja prosseguir?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
						if(result == true){
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
									dica=3;
								}
							}
						}
						for(int k=0;k<4;k++) {
							barcos[k].vivo=true;
							barcosali[k].vivo=true;
						}
					}
					if(i==6){
						boolean result = JOptionPane.showConfirmDialog(this, "Se você sair o jogo será finalizado. \n Deseja prosseguir?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0;		
						if(result == true) {
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
						JOptionPane.showMessageDialog(this,"Voce não terminou de preencher os barcos,por favor termine");
					}
				}
			}
		}
		
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
										ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==1){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==2){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//PVpart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Ppart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//PVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Ppart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==3){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//PVpart4.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Ppart4.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//PVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Ppart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
							}
							else if(k==1){
								if(h==0){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==1){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//EVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Epart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==2){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//EVpart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Epart3.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//EVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Epart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
							}
							else if(k==2){
								if(h==0){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==1){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//SVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Spart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//SVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Spart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
							}
							else if(k==3){
								if(h==0){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
								}
								else if(h==1){
									if(barcosali[k].direcao==1){
										ImageIcon minhaImagem = new ImageIcon("navios//CVpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==2){
										ImageIcon minhaImagem = new ImageIcon("navios//Cpart2.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==3){
										ImageIcon minhaImagem = new ImageIcon("navios//CVpart1.jpg");
										minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
										table[i][j].setIcon(minhaImagem);
									}
									if(barcosali[k].direcao==4){
										ImageIcon minhaImagem = new ImageIcon("navios//Cpart1.jpg");
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
		boolean foi = true;
		
		while(!okay){
			if(qual.equalsIgnoreCase("aleatorio") || qual.equalsIgnoreCase("aleatoria")){
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
				//for(int i = 0; i<5 ; i++) System.out.println("Coordenada navio " + i + " eh: " + barcos[i].partes[0].X);
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
				
				JOptionPane.showMessageDialog(null,"Os barcos foram colocados de maneira aleatoria");
				okay = true;
			}
			else if(qual.equalsIgnoreCase("manual")){
				jogo.createPreGame();
				this.hue=1;
				JOptionPane.showMessageDialog(null,"Escolha os barcos, depois a coordenada desejada e por fim a direção do barco");
				okay = true;
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
			else {
				JOptionPane.showMessageDialog(null,"Comando invalido !!! Tente novamente");
				qual = JOptionPane.showInputDialog("Deseja que os barcos sejam colocados de maneira aleatoria ou manual?");
				if(qual == null){
					jogo.createMenu();
					this.dispose();
				}
			}
		}
		this.barcos = barcos;
	}
	public void addComponentsToPane() {
		final JPanel compsToExperiment = new JPanel();
		final JPanel teste = new JPanel();
		final JPanel tiro = new JPanel();
		
		ImageIcon icon = new ImageIcon("Agua//WaterNoClick.jpg");
		ImageIcon icon2 = new ImageIcon("Agua//WaterNoClick.jpg");
		ImageIcon Escolta = new ImageIcon("Navios//Escolta2.jpg");
		ImageIcon Submarino = new ImageIcon("Navios//Submarino2.jpg");
		ImageIcon Caca = new ImageIcon("Navios//Caca2.jpg");
		ImageIcon NovoJogo = new ImageIcon("Botoes//NovoJogo.jpg");
		ImageIcon Restart = new ImageIcon("Botoes//Restart.jpg");
		ImageIcon Dica = new ImageIcon("Botoes//Dica.jpg");
		ImageIcon VoltarMenu = new ImageIcon("Botoes//VoltarMenu.jpg");
		ImageIcon Dicas = new ImageIcon("Botoes//DicaS.jpg");
		ImageIcon NovoJogos = new ImageIcon("Botoes//NovoJogoS.jpg");
		ImageIcon Restarts = new ImageIcon("Botoes//RestartS.jpg");
		ImageIcon VoltarMenus = new ImageIcon("Botoes//VoltarMenuS.jpg");
		
		int largura = 135;
		int altura = 127;
		icon2.setImage(icon2.getImage().getScaledInstance(50, 47, 100));
		
		Escolta.setImage(Escolta.getImage().getScaledInstance(largura, altura, 100));
		Submarino.setImage(Submarino.getImage().getScaledInstance(largura, altura, 100));
		Caca.setImage(Caca.getImage().getScaledInstance(largura, altura, 100));
		
		//mandar vitor
		NovoJogo.setImage(NovoJogo.getImage().getScaledInstance(largura, altura, 100));
		Restart.setImage(Restart.getImage().getScaledInstance(largura, altura, 100));
		Dica.setImage(Dica.getImage().getScaledInstance(largura, altura, 100));
		VoltarMenu.setImage(VoltarMenu.getImage().getScaledInstance(largura, altura, 100));
		
		
		NovoJogos.setImage(NovoJogos.getImage().getScaledInstance(largura, altura, 100));
		Restarts.setImage(Restarts.getImage().getScaledInstance(largura, altura, 100));
		Dicas.setImage(Dicas.getImage().getScaledInstance(largura, altura, 100));
		VoltarMenus.setImage(VoltarMenus.getImage().getScaledInstance(largura, altura, 100));
		
		compsToExperiment.setLayout(experimentLayout);
		teste.setLayout(experimentLayout);
		tiro.setLayout(layout);
		
		teste.setPreferredSize(new Dimension(600,500));
		compsToExperiment.setPreferredSize(new Dimension(600,500));
		tiro.setPreferredSize(new Dimension(70,130));
		
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
			}
		}	
		for(int i=0; i<14;i++){
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//primeira linha
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}

		compsToExperiment.add(new Label("      A"));
		teste.add(new Label("      A"));
		compsToExperiment.add(new Label("      B"));
		teste.add(new Label("      B"));
		compsToExperiment.add(new Label("      C"));
		teste.add(new Label("      C"));
		compsToExperiment.add(new Label("      D"));
		teste.add(new Label("      D"));
		compsToExperiment.add(new Label("      E"));
		teste.add(new Label("      E"));
		compsToExperiment.add(new Label("      F"));
		teste.add(new Label("      F"));
		compsToExperiment.add(new Label("      G"));
		teste.add(new Label("      G"));
		compsToExperiment.add(new Label("      H"));
		teste.add(new Label("      H"));
		compsToExperiment.add(new Label("      I"));
		teste.add(new Label("      I"));
		compsToExperiment.add(new Label("      J"));
		teste.add(new Label("      J"));
		
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//segunda linha
		
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          1"));
		teste.add(new Label("          1"));
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[0][i]);
			teste.add(table2[0][i]);
		}
		
		for(int i=3; i<7;i++) {
			tiro.add(tiros[i]);
		}
		
		tiro.add(new Label(" "));
		tiro.add(new Label(" "));
		
		for(int i=0;i<3;i++) {
			tiro.add(tiros[i]);
		}
		
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//terceira linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          2"));
		teste.add(new Label("          2"));
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[1][i]);
			teste.add(table2[1][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//quarta linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          3"));
		teste.add(new Label("          3"));
		
		//adicionando os botoes no GridLayout
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[2][i]);
			teste.add(table2[2][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//quinta linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          4"));
		teste.add(new Label("          4"));
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[3][i]);
			teste.add(table2[3][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//sexta linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          5"));
		teste.add(new Label("          5"));
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[4][i]);
			teste.add(table2[4][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//setima linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          6"));
		teste.add(new Label("          6"));
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[5][i]);
			teste.add(table2[5][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//oitava linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          7"));
		teste.add(new Label("          7"));
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[6][i]);
			teste.add(table2[6][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//nona linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          8"));
		teste.add(new Label("          8"));
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[7][i]);
			teste.add(table2[7][i]);
		}
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//decima linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("          9"));
		teste.add(new Label("          9"));
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[8][i]);
			teste.add(table2[8][i]);
		}
		
		for(int i=0;i<2;i++) {
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
		}
		
		//decima primeira linha
		compsToExperiment.add(new Label(" "));
		teste.add(new Label(" "));
		compsToExperiment.add(new Label("        10"));
		teste.add(new Label("        10"));
		
		for(int i=0; i<10; i++){
			compsToExperiment.add(table[9][i]);
			teste.add(table2[9][i]);
		}
		for(int i=0; i<10;i++){
			compsToExperiment.add(new Label(" "));
			teste.add(new Label(" "));
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
			JOptionPane.showMessageDialog(this,"Parabens voce venceu o jogo !");
			this.jogo.createMenu();
			this.dispose();
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
		System.out.println(x+" "+y);
		if(tiro == 1  || tiro==2 || tiro == 3){	
			for(int k = 0; k<4 ; k++){
				for(int h = 0; h<barcosali[k].tam ; h++){
					if(barcosali[k].partes[h].getX() == x && barcosali[k].partes[h].getY() == y){
						if(k==0){
							if(h==0){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x].setIcon(minhaImagem);
									table[y][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x+1].setIcon(minhaImagem);
									table[y][x+1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y][x-1].setIcon(minhaImagem);
									table[y][x-1].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y-1][x].setIcon(minhaImagem);
									table[y-1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==3){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart4M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//PVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Ppart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==2){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart3M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//EVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Epart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//SVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Spart1M.jpg");
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
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
							}
							else if(h==1){
								if(barcosali[k].direcao==1){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==2){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart2M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==3){
									ImageIcon minhaImagem = new ImageIcon("navios//CVpart1M.jpg");
									int largura = 50;
									int altura = 47;
									minhaImagem.setImage(minhaImagem.getImage().getScaledInstance(largura, altura, 100));
									table[y+1][x].setIcon(minhaImagem);
									table[y+1][x].removeActionListener(this);
									
								}
								if(barcosali[k].direcao==4){
									ImageIcon minhaImagem = new ImageIcon("navios//Cpart1M.jpg");
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
			JOptionPane.showMessageDialog(this,"Que pena, voce perdeu o jogo, tente de novo!");
			this.jogo.createMenu();
			this.dispose();
		}
	}
}