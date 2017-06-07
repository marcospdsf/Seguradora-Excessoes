import javax.swing.JOptionPane;

public class CampoVazio extends Exception{

	private static final long serialVersionUID = 2628380054499696578L;
	
	public CampoVazio(){
		JOptionPane.showMessageDialog(null, "Por favor insira um valor.");
	}

}
