import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelTwo extends JPanel{

	private static final long serialVersionUID = 145587478141456489L;
	private ImageIcon image;
	JPanelTwo(int qual){
		//0 menu 1 tabuleiro player 2 tabuleiro PC 3 tabela de tiro 4 botao pregame
		if(qual == 0) {
			image = new ImageIcon("Background//FundoMenu.jpg");
			image.setImage(image.getImage().getScaledInstance(800, 660, 100));
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
	}
	public static JPanel drawGamePanel(){
	    //Create game panel and attributes
	    JPanel gamePanel = new JPanel();
	    //Set Return
	    return gamePanel;
	}

	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(image.getImage(),0,0, null);
	}
}