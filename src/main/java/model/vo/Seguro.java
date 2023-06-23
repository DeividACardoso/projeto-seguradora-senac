package model.vo;

import java.time.LocalDate;

public class Seguro {

	private Integer id;
	private Integer idSegurado;
	
	private String nomeSegurado;
	private int numeroProposta;
	private LocalDate dtInicioVigencia;
	private LocalDate dtFimVigencia;
	private String placaVeiculo;
	private double rcfDanosMateriais;
	private double rcfDanosCorporais;
	private String franquia;
	private String assistencia;
	private String carroReserva;
	

	public Seguro() {

	}

	public Seguro(Integer id, String nomeSegurado, int numeroProposta, LocalDate dtInicioVigencia,
			LocalDate dtFimVigencia, String placaVeiculo, double rcfDanosMateriais, double rcfDanosCorporais,
			String franquia, String assistencia, String carroReserva) {
		super();
		this.id = id;
		this.nomeSegurado = nomeSegurado;
		this.numeroProposta = numeroProposta;
		this.dtInicioVigencia = dtInicioVigencia;
		this.dtFimVigencia = dtFimVigencia;
		this.placaVeiculo = placaVeiculo;
		this.rcfDanosMateriais = rcfDanosMateriais;
		this.rcfDanosCorporais = rcfDanosCorporais;
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

	public String getNomeSegurado() {
		return nomeSegurado;
	}

	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}

	public int getNumeroProposta() {
		return numeroProposta;
	}

	public void setNumeroProposta(int numeroProposta) {
		this.numeroProposta = numeroProposta;
	}

	public LocalDate getDtInicioVigencia() {
		return dtInicioVigencia;
	}

	public void setDtInicioVigencia(LocalDate dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public LocalDate getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(LocalDate dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public double getRcfDanosMateriais() {
		return rcfDanosMateriais;
	}

	public void setRcfDanosMateriais(double rcfDanosMateriais) {
		this.rcfDanosMateriais = rcfDanosMateriais;
	}

	public double getRcfDanosCorporais() {
		return rcfDanosCorporais;
	}

	public void setRcfDanosCorporais(double rcfDanosCorporais) {
		this.rcfDanosCorporais = rcfDanosCorporais;
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

	public String getCarroReserva() {
		return carroReserva;
	}

	public void setCarroReserva(String carroReserva) {
		this.carroReserva = carroReserva;
	}

	public Integer getIdSegurado() {
		return idSegurado;
	}

	public void setIdSegurado(Integer idSegurado) {
		this.idSegurado = idSegurado;
	}
	
}
