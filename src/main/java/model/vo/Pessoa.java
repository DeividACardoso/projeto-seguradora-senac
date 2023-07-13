package model.vo;

import java.time.LocalDate;
import java.util.List;

public class Pessoa {
	private Integer id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	private Endereco endereco;

	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento, String telefone,
			Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
	}


	public Pessoa(Integer id, String nome, String cpf, LocalDate dataNascimento, String telefone,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
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




	@Override
	public String toString() {
		return nome.toUpperCase();
//				+ "\nCPF: " + cpf;
//				+ "\nData Nascimento: " + dataNascimento
//				+ "\nSeguros: " + seguros 
//				+ "\nTelefone: " + telefone 
//				+ "\nEndereço: " + endereco;
	}
	
}