package model.vo;

import java.time.LocalDate;

import model.vo.telefonia.Endereco;

public class PessoaVO {
	
	private Integer id;
	private String nome;
	private String cpf;
	private LocalDate data_nascimento;
	private int telefone;
	private Endereco endereco;
	
	public PessoaVO() {
		
	}
	public PessoaVO(Integer id, String nome, String cpf, LocalDate data_nascimento, int telefone, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.telefone = telefone;
		this.endereco = endereco;
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
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
