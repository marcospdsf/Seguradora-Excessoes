import javax.swing.JOptionPane;

public class Principal extends ProcuraGeraCliente {

	public static void main(String[] args) {
		ContratoMoradia pessoaFisica = new ContratoMoradia();
		ContratoComercial pessoaJuridica = new ContratoComercial();
		ProcuraGeraCliente cliente = new ProcuraGeraCliente();
		Object[] menu = { "Cadastrar Pessoa Fisica", "\nCadastrar Pessoa Juridica", "Abrir Cadastro", "Ler cadastros",
				"\nSair" };

		int opcao = 0;

		do {

			opcao = JOptionPane.showOptionDialog(null, "SEGURADORA", "Seguradora", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, menu, menu[0]);

			switch (opcao) {
			case 0:
				pessoaFisica.cadastro();
				if (saiu == false) {
					pessoaFisica.calculoSeguroResidencial();
					pessoaFisica.salvarCadastro();
					pessoaFisica.gerarContrato();
				}
				break;

			case 1:
				pessoaJuridica.cadastro();
				if (saiu == false) {
					pessoaJuridica.calculoSeguroEmpresarial();	
					pessoaJuridica.salvarCadastro();
					pessoaJuridica.gerarContrato();
				}
				break;

			case 2:
				cliente.mostraContrato();
				break;

			case 3:
				cliente.lerCadastro();
				break;
			case 4:
				break;

			}
		} while (opcao != 4);
	}
}
