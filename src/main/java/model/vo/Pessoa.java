package model.vo;

import java.time.LocalDate;
import java.util.List;

public class Pessoa {
	private Integer id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private List<Seguro> seguros;
	private String telefone;
	private Endereco endereco;
	private TipoPessoa tipoPessoa;

	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento, List<Seguro> seguros, String telefone,
			Endereco endereco, TipoPessoa tipoPessoa) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.seguros = seguros;
		this.telefone = telefone;
		this.endereco = endereco;
		this.tipoPessoa = tipoPessoa;
	}


	public Pessoa(Integer id, String nome, String cpf, LocalDate dataNascimento, List<Seguro> seguros, String telefone,
			Endereco endereco, TipoPessoa tipoPessoa) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.seguros = seguros;
		this.telefone = telefone;
		this.endereco = endereco;
		this.tipoPessoa = tipoPessoa;
	}

		
	public Pessoa() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public List<Seguro> getSeguros() {
		return seguros;
	}


	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}


	@Override
	public String toString() {
		return "Id: " + id 
				+ "\nNome: " + nome 
				+ "\nCpf: " + cpf 
				+ "\nData Nascimento: " + dataNascimento
				+ "\nSeguros: " + seguros 
				+ "\nTelefone: " + telefone 
				+ "\nEndereço: " + endereco 
				+ "\nTipo Pessoa: " + tipoPessoa;
	}
	
}