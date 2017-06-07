import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class ContratoComercial extends ProcuraGeraCliente implements Interface {
	ChecarEntrada checar = new ChecarEntrada();

	private long numeroF;
	private long numeroV;
	private int ramo;
	private String ramoM;
	private String[] ramoA = { "Industria", "Comercio", "Agropecuaria" };

	public void cadastro() {
		do {
			cancelar = false;
			ok = false;
			saiu = false;
			
			do {
				try {
					razaoSocial = JOptionPane.showInputDialog("Digite o nome real da empresa:");
					
					File check = new File(razaoSocial + ".con");
					if (razaoSocial != null && razaoSocial.length() > 0) {
						ok = true;
					} else if (razaoSocial.length() == 0 && razaoSocial != null) {
						throw new CampoVazio();
					}else if (check.exists() == true){
						throw new ArquivoExistente();
					}
					
				} catch (NullPointerException ex) {
					cancelar = true;
					saiu = true;
					break;
				} catch (CampoVazio e) {
				} catch (ArquivoExistente e) {
				}
			} while (ok == false);

			if (cancelar == true)
				break;

			ok = false;
				
				do {
					try {
						cliente = JOptionPane.showInputDialog("Digite o nome ficticio da empresa:");

						if (cliente != null && cliente.length() > 0) {
							ok = true;
						} else if (cliente.length() == 0 && cliente != null) {
							throw new CampoVazio();
						}
					} catch (NullPointerException ex) {
						cancelar = true;
						saiu = true;
						break;
					} catch (CampoVazio e) {
					}
				} while (ok == false);

				if (cancelar == true)
					break;

				ok = false;

			do {
				try {
					endereco = JOptionPane.showInputDialog("Digite o endereco da empresa:");

					if (endereco != null && endereco.length() > 0) {
						ok = true;
					} else if (endereco.length() == 0 && endereco != null) {
						throw new CampoVazio();
					}
				} catch (NullPointerException ex) {
					cancelar = true;
					saiu = true;
					break;
				} catch (CampoVazio e){
					}
			} while (ok == false);

			if (cancelar == true)
				break;

			ok = false;

			do {
				try {
					valor_imovel = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do imovel:"));

					check = String.valueOf(valor_imovel);

					if (check != null && check.length() > 0 && checar.isCurrency(check) == true) {
						ok = true;
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Você digitou um valor não aceito ou não digitou nada!");
				} catch (NullPointerException ex) {
					cancelar = true;
					saiu = true;
					break;
				}
			} while (ok == false);

			if (cancelar == true)
				break;

			ok = false;

			do {
				try {
					numeroF = Integer
							.parseInt(JOptionPane.showInputDialog("Digite o numero de funcionarios:"));

					check = String.valueOf(numeroF);

					if (check != null && check.length() > 0 && checar.isNumeric(check) == true) {
						ok = true;
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Você digitou um valor não aceito ou não digitou nada!");
				} catch (NullPointerException ex) {
					cancelar = true;
					saiu = true;
					break;
				}
			} while (ok == false);

			if (cancelar == true)
				break;

			ok = false;

			do {
				try {
					numeroV = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de visitas:"));

					check = String.valueOf(numeroV);

					if (check != null && check.length() > 0 && checar.isNumeric(check) == true) {
						ok = true;
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Você digitou um valor não aceito ou não digitou nada!");
				} catch (NullPointerException ex) {
					cancelar = true;
					saiu = true;
					break;
				}
			} while (ok == false);

			if (cancelar == true)
				break;

			Object[] ramoEscolha = { "Industria", "Comercio", "Agropecuaria", "cancelar" };

			ramo = JOptionPane.showOptionDialog(null, "Escolha o ramo de atuação da empresa:", "Seguradora",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ramoEscolha, ramoEscolha[0]);

			if (ramo == 3) {
				cancelar = true;
				saiu = true;
			}

			cancelar = true;

		} while (cancelar == false);

	}

	public void calculoSeguroEmpresarial() {
		seguro += valor_imovel * 0.04;

		int i;
		double acPorcentagem = 0, porFunc = 0, porVis = 0;

		if (numeroF >= 10)
			porFunc = 0.002;

		if (numeroV >= 200)
			porVis = 0.003;

		for (i = 1; i <= numeroF; i++) {
			if (i % 10 == 0)
				porFunc += 0.002;
		}

		for (i = 1; i <= numeroV; i++) {
			if (i % 200 == 0) 
				porFunc += 0.003;
		}

		acPorcentagem = porFunc + porVis;

		seguro += valor_imovel * acPorcentagem;

		if (ramo == 0) {
			seguro += valor_imovel * 0.01;
		}

		if (ramo == 1) {
			seguro += valor_imovel * 0.005;
		}
	}
	
	public void salvarCadastro() {
		VariaveisArquivosBin c = new VariaveisArquivosBin(cliente, 0, seguro,false);

		try {

			FileOutputStream saidaArquivo = new FileOutputStream(razaoSocial+".bin");
			ObjectOutputStream saidaObjeto = new ObjectOutputStream(saidaArquivo);
			saidaObjeto.writeObject(c);

			saidaObjeto.close();
			saidaArquivo.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro!");
		}
	}

	public void gerarContrato() {
		NumberFormat f = NumberFormat.getCurrencyInstance();

		try {
			int i;

			for (i = 0; i <= 2; i++) {
				if (ramo == i) {
					ramoM = ramoA[i];
				}
			}

			int opcao = JOptionPane.showOptionDialog(null, "Clique na operação a qual deseja realizar:", "Operação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			if (opcao == 0) {

				FileWriter arq = new FileWriter(razaoSocial + ".con");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.printf("CONTRATO%n" + "%nRazão Social: " + razaoSocial + "%nNome ficticio: " + cliente + "%nEndereço: "
						+ endereco + "%nRamo: " + ramoM + "%nValor do imóvel: " + f.format(valor_imovel)
						+ "%nNúmero de Funcionários: " + numeroF + "%nNúmero de visitas: " + numeroV
						+ "%nValor do seguro: " + f.format(seguro));

				JOptionPane.showMessageDialog(null, "Contrato salvo com sucesso como " + razaoSocial + ".con !");
				arq.close();

			} else if (opcao == 1) {
				JOptionPane.showMessageDialog(null, "Você não gerou o contrato!\nClique em OK para retornar ao menu");

			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar contrato!");
		}

	}
}
