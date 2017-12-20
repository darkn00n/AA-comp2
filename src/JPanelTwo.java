import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelTwo extends JPanel{

	private static final long serialVersionUID = 145587478141456489L;
	private ImageIcon image;
	JPanelTwo(int qual){
		//0 menu 1 tabuleiro player 2 tabuleiro PC 3 tabela de tiro 4 botao pregame 5 pos game win 6 pos game defeat 7 creditos
		//8 tutorial 9 historia
		if(qual == 0) {
			image = new ImageIcon("Background//FundoMenu.jpg");
			image.setImage(image.getImage().getScaledInstance(820, 620, 100));
		}
		if(qual == 1) {
			image = new ImageIcon("Background//FundoGame2.jpg");
			image.setImage(image.getImage().getScaledInstance(600, 500, 100));
		}
		if(qual == 2) {
			image = new ImageIcon("Background//FundoGame.jpg");
			image.setImage(image.getImage().getScaledInstance(600, 500, 100));
		}
		if(qual == 3) {
			image = new ImageIcon("Background//Tools.jpg");
			image.setImage(image.getImage().getScaledInstance(805, 127, 100));
		}
		if(qual == 4) {
			image = new ImageIcon("Background//FundoGame3.jpg");
			image.setImage(image.getImage().getScaledInstance(600, 500, 100));
		}
		if(qual == 5) {
			image = new ImageIcon("Background//Vitoria.jpg");
			image.setImage(image.getImage().getScaledInstance(800, 600, 100));
		}
		if(qual == 6) {
			image = new ImageIcon("Background//Derrota.jpg");
			image.setImage(image.getImage().getScaledInstance(800, 600, 100));
		}
		if(qual == 7) {
			image = new ImageIcon("Background//Creditos.jpg");
			image.setImage(image.getImage().getScaledInstance(820, 620, 100));
		}
		if(qual == 8) {
			image = new ImageIcon("Background//Tutorial.jpg");
			image.setImage(image.getImage().getScaledInstance(800, 600, 100));
		}
		if(qual == 9) {
			image = new ImageIcon("Background//Historia.jpg");
			image.setImage(image.getImage().getScaledInstance(800, 600, 100));
		}
	}
	public static JPanel drawGamePanel(){
	    // cria painel do jogo
	    JPanel gamePanel = new JPanel();
	    //retorna
	    return gamePanel;
	}

	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(image.getImage(),0,0, null);
	}
}