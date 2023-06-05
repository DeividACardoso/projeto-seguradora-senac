package model.vo;

import java.time.LocalDate;

public class Seguro {
	
	private Integer id;
	private Integer idPessoa;
	private String nomeSegurado;
	private int numero_proposta;
	private LocalDate dt_inicio_vigencia;
	private LocalDate dt_fim_vigencia;
	private String placaVeiculo;
	private int rcf_danos_materiais;
	private int rcf_danos_corporais;
	private String franquia;
	private String assistencia;
	private int carroReserva;
	
	public Seguro() {
		
	}

	public Seguro(Integer id, Integer idPessoa, String nomeSegurado, int numero_proposta, LocalDate dt_inicio_vigencia,
			LocalDate dt_fim_vigencia, String placaVeiculo, int rcf_danos_materiais, int rcf_danos_corporais,
			String franquia, String assistencia, int carroReserva) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.nomeSegurado = nomeSegurado;
		this.numero_proposta = numero_proposta;
		this.dt_inicio_vigencia = dt_inicio_vigencia;
		this.dt_fim_vigencia = dt_fim_vigencia;
		this.placaVeiculo = placaVeiculo;
		this.rcf_danos_materiais = rcf_danos_materiais;
		this.rcf_danos_corporais = rcf_danos_corporais;
		this.franquia = franquia;
		this.assistencia = assistencia;
		this.carroReserva = carroReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomeSegurado() {
		return nomeSegurado;
	}

	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}

	public int getNumero_proposta() {
		return numero_proposta;
	}

	public void setNumero_proposta(int numero_proposta) {
		this.numero_proposta = numero_proposta;
	}

	public LocalDate getDt_inicio_vigencia() {
		return dt_inicio_vigencia;
	}

	public void setDt_inicio_vigencia(LocalDate dt_inicio_vigencia) {
		this.dt_inicio_vigencia = dt_inicio_vigencia;
	}

	public LocalDate getDt_fim_vigencia() {
		return dt_fim_vigencia;
	}

	public void setDt_fim_vigencia(LocalDate dt_fim_vigencia) {
		this.dt_fim_vigencia = dt_fim_vigencia;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public int getRcf_danos_materiais() {
		return rcf_danos_materiais;
	}

	public void setRcf_danos_materiais(int rcf_danos_materiais) {
		this.rcf_danos_materiais = rcf_danos_materiais;
	}

	public int getRcf_danos_corporais() {
		return rcf_danos_corporais;
	}

	public void setRcf_danos_corporais(int rcf_danos_corporais) {
		this.rcf_danos_corporais = rcf_danos_corporais;
	}

	public String getFranquia() {
		return franquia;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	public String getAssistencia() {
		return assistencia;
	}

	public void setAssistencia(String assistencia) {
		this.assistencia = assistencia;
	}

	public int getCarroReserva() {
		return carroReserva;
	}

	public void setCarroReserva(int carroReserva) {
		this.carroReserva = carroReserva;
	}
	
}

	
