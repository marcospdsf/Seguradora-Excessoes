import java.io.IOException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {// inicio da funcao principal
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaJuridica pessoaJuridica = new PessoaJuridica();

		int opcao = 0;
		boolean ok = false;
		
		do{
			do {
				try {
					opcao = Integer
							.parseInt(JOptionPane.showInputDialog("**SEGURADORA**\n\nFazer Cadastro\n\n1-Pessoa Fisica \n2-Pessoa Juridica\n\n0-Sair"));
					if (opcao == 1 || opcao == 2) {
						ok = true;
					}
					if(opcao==0){
						break;
					}
					else {
						if (ok != true)
							throw new IOException();
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Voce digitou uma opcao invalida!");
	
				}
			} while (ok != true);
	
			switch (opcao) {// inicio do switch
			case 1:
	
				pessoaFisica.cadastro();
				pessoaFisica.calculoSeguroResidencial();
				pessoaFisica.mostraContratoResidencial();
	
				break;
	
			case 2:
				pessoaJuridica.cadastro();
				pessoaJuridica.calculoSeguroEmpresarial();
				pessoaJuridica.mostraContratoEmpresarial();
	
				break;
			}// fim do switch
		}while(opcao!=0);
	}
}
