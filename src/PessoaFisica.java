import java.io.IOException;

import javax.swing.JOptionPane;

public class PessoaFisica extends Cliente {
	ChecarEntrada checar = new ChecarEntrada();
	
	private String valorImovelChecar;
	private String tipoM;
	private String zonaM;
	private boolean ok = false;

	public void cadastro() {
		cliente = JOptionPane.showInputDialog("Digite o nome do cliente:");

		endereco = JOptionPane.showInputDialog("Digite o endereco do cliente:");
		
		do{
			try{
				valor_imovel = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do imovel:"));
				
				valorImovelChecar =String.valueOf(valor_imovel);
				
				if(checar.isCurrency(valorImovelChecar)==true){
					ok=true;
				}else{
					throw new NumberFormatException();
				}
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Você digitou um valor não aceito!");
			}
				
		}while(ok!=true);
		
		ok=false;
		
		do{
			try{
				zona = Integer.parseInt(JOptionPane.showInputDialog("Digite a zona (1-urbana,2-suburbana,3-rural):"));
				
				if(zona==1||zona==2||zona==3){
					ok=true;
				}else{
					throw new IOException();
				}
			}catch(IOException ex){
				JOptionPane.showMessageDialog(null,"Voce digitou uma opcao invalida!");
			}
		}while(ok!=true);
		
		ok = false;
		
		do{
			try{
				tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de residencia(1-casa,2-apartamento):"));
				
				if(tipo==1||tipo==2){
					ok=true;
				}else{
					throw new IOException();
				}
			}catch(IOException ex){
				JOptionPane.showMessageDialog(null,"Voce digitou uma opcao invalida!");
			}
		}while(ok!=true);

	}

	public void calculoSeguroResidencial() {
		
		seguro += valor_imovel * 0.01;

		if (zona == 1) {
			seguro += valor_imovel * 0.01;
		}

		if (zona == 2) {
			seguro += valor_imovel * 0.025;
		}

		if (tipo == 1) {
			seguro += valor_imovel * 0.005;
		}
	}

	public void mostraContratoResidencial() {
		
		if (zona == 1) {
			zonaM = "Urbana";
		}
		if (zona == 2) {
			zonaM = "Suburbana";

		}
		if (zona == 3) {
			zonaM = "Rural";
		}
		if (tipo == 1) {
			tipoM = "Casa";
		}
		if (tipo == 2) {
			tipoM = "Predio";
		}
		JOptionPane.showMessageDialog(null,
				"**CONTRATO**\n\nNome do cliente: " + cliente + "\nEndereco: " + endereco + "\n" + tipoM + "\nZona: "
						+ zonaM + "\nValor do imovel: R$" + valor_imovel + "\nValor do seguro: R$" + seguro);
	}

}
