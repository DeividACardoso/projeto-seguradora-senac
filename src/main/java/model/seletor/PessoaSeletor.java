package model.seletor;

import java.time.LocalDate;
import java.util.List;

import model.vo.Endereco;
import model.vo.Seguro;

public class PessoaSeletor extends BaseSeletor{

	private String nome;
	private String cpf;
	private LocalDate dataNascimentoDe;
	private LocalDate dataNascimentoAte;
	private List<Seguro> seguros;
	private String telefone;
	private Endereco endereco;
	
	@Override
	public boolean temFiltro() {
		return (this.nome != null && this.nome.trim().length() > 0)
			|| (this.cpf != null && this.cpf.trim().length() > 0)
			|| this.dataNascimentoDe != null
			|| this.dataNascimentoAte != null
			|| this.seguros != null
			|| this.telefone != null
			|| this.endereco != null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimentoDe() {
		return dataNascimentoDe;
	}

	public void setDataNascimentoDe(LocalDate dataNascimentoDe) {
		this.dataNascimentoDe = dataNascimentoDe;
	}
	
	public LocalDate getDataNascimentoAte() {
		return dataNascimentoAte;
	}

	public void setDataNascimentoAte(LocalDate dataNascimentoAte) {
		this.dataNascimentoAte = dataNascimentoAte;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	
}
