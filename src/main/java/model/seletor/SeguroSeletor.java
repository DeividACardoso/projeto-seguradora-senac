package model.seletor;

import java.time.LocalDate;

public class SeguroSeletor extends BaseSeletor {

	private String nomeSegurado;
	private int numeroProposta;
	
	//TODO ajustar
//	private LocalDate dtInicialIntervaloInicioVigencia;
//	private LocalDate dtFinalInicioIntervaloVigencia;
//	private LocalDate dtInicialIntervaloFimVigencia;
//	private LocalDate dtFinalIntervaloFimVigencia;
	
	
	private LocalDate dtInicioVigencia;
	private LocalDate dtFimVigencia;
	
	private String placaVeiculo;
	private double rcfDanosMateriais;
	private double rcfDanosCorporais;
	private String franquia;
	private String assistencia;
	private int carroReserva;

	@Override
	public boolean temFiltro() {
		return (this.nomeSegurado != null && this.nomeSegurado.trim().length() > 0)
	            || (this.numeroProposta != 0 && this.numeroProposta > 0)
	            || (this.placaVeiculo != null && this.placaVeiculo.trim().length() > 0)
	            || (this.dtInicioVigencia != null)
	            || (this.dtFimVigencia != null)
	            || (this.rcfDanosMateriais != 0)
	            || (this.rcfDanosCorporais != 0)
	            || (this.franquia != null && this.franquia.trim().length() > 0)
	            || (this.assistencia != null && this.assistencia.trim().length() > 0)
	            || (this.carroReserva != 0 && String.valueOf(this.carroReserva).trim().length() > 0);
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

	public int getCarroReserva() {
		return carroReserva;
	}

	public void setCarroReserva(int carroReserva) {
		this.carroReserva = carroReserva;
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
	
}
