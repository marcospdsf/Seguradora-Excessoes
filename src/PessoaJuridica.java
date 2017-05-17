import java.io.IOException;

import javax.swing.JOptionPane;

public class PessoaJuridica extends Cliente {
	ChecarEntrada checar = new ChecarEntrada();

	private String valorImovelChecar;
	private String checarEntrada;
	private String ramoM;
	private boolean ok = false;

	public void cadastro() {
		cliente = JOptionPane.showInputDialog("Digite o nome do cliente:");

		do {
			try {
				valor_imovel = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do imovel:"));

				valorImovelChecar = String.valueOf(valor_imovel);

				if (checar.isCurrency(valorImovelChecar) == true) {
					ok = true;
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Você digitou um valor não aceito!");
			}

		} while (ok != true);

		ok = false;

		do {
			try {
				numero_funcionarios = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de funcionarios:"));

				checarEntrada = String.valueOf(numero_funcionarios);
				if (checar.isNumeric(checarEntrada) == true) {
					ok = true;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Você digitou um valor não aceito!");
			}

		} while (ok != true);

		ok = false;

		do {
			try {
				numero_visitas = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de visitas diarias:"));

				checarEntrada = String.valueOf(numero_visitas);
				if (checar.isNumeric(checarEntrada) == true) {
					ok = true;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Você digitou um valor não aceito!");
			}

		} while (ok != true);

		ok = false;

		do {
			try {
				ramo = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o ramo de atuacao(1-Industria 2-Comercio 3-Agropecuaria):"));

				if (ramo == 1 || ramo == 2 || ramo == 3) {
					ok = true;
				} else {
					throw new IOException();
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Voce digitou uma opcao invalida!");
			}

		} while (ok != true);

	}

	public void calculoSeguroEmpresarial() {
		seguro += valor_imovel * 0.04;

		int i;
		double acPorcentagem = 0, porFunc = 0, porVis = 0;
		
		if(numero_funcionarios>=10){
			porFunc=0.002;
		}
		
		if(numero_visitas>=200){
			porVis= 0.003;
		}
		
		for(i=1;i<=numero_funcionarios;i++){
			if(i%10==0){
				porFunc+=0.002;
			}
		}
		
		for(i=1;i<=numero_visitas;i++){
			if(i%200==0){
				porFunc+=0.003;
			}
		}

		acPorcentagem = porFunc + porVis;

		seguro += valor_imovel * acPorcentagem;

		if (ramo == 1) {
			seguro += valor_imovel * 0.01;
		}

		if (ramo == 2) {
			seguro += valor_imovel * 0.005;
		}
	}

	public void mostraContratoEmpresarial() {
		if (ramo == 1) {
			ramoM = "Industria";
		}
		if (ramo == 2) {
			ramoM = "Comercio";
		}
		if (ramo == 3) {
			ramoM = "Agropecuaria";
		}
		JOptionPane.showMessageDialog(null,
				"**CONTRATO**\n\nNome do cliente: " + "\nRamo: " + ramoM + cliente + "\nValor do imovel: R$"
						+ valor_imovel + "\nNumero de Funcionarios: " + numero_funcionarios + "\nNumero de visitas: "
						+ numero_visitas + "\nValor do seguro: " + seguro);
	}
}
