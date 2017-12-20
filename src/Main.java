import javax.swing.JOptionPane;

public class Main{
	public static void main(String[] args){
		PMotor jogo = new PMotor();
		try{
			jogo.setConfiguration();
		}
		catch(Exception e) {
			System.out.println("Tema não suportado!");
			JOptionPane.showMessageDialog(null, "Deu ruim");
		}
		jogo.createMenu();
	}
}