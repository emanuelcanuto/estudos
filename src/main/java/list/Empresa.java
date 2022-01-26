package list;

import java.time.LocalDate;

public class Empresa {
	private String nome;
	private LocalDate dataDeCadastro;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(LocalDate localDate) {
		this.dataDeCadastro = localDate;
	}
}
