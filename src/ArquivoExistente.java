import javax.swing.JOptionPane;

public class ArquivoExistente extends Exception {

	private static final long serialVersionUID = -6346794817253321355L;

	public ArquivoExistente(){
		JOptionPane.showMessageDialog(null, "Você digitou um nome existente.");
    }
}

