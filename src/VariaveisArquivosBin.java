import java.io.Serializable;

public class VariaveisArquivosBin implements Serializable {

	private static final long serialVersionUID = 7331615495936945583L;
	String cliente;
	double seguro;
	boolean isPessoaFisica;

	public VariaveisArquivosBin(String cliente, int idCliente, double seguro, boolean isPessoaFisica) {
		super();
		this.cliente = cliente;
		this.seguro = seguro;
		this.isPessoaFisica = isPessoaFisica;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSeguro() {
		return seguro;
	}

	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}

	public boolean isPessoaFisica() {
		return isPessoaFisica;
	}

	public void setPessoaFisica(boolean isPessoaFisica) {
		this.isPessoaFisica = isPessoaFisica;
	}

}
