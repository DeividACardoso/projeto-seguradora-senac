package model.vo;

import java.time.LocalDate;

public class Sinistro {

	private Integer id;
	private Seguro seguro;
	private String numeroSinistro;
	private TipoSinistro tipoSinistro;
	private LocalDate dataSinistro;
	private double valorFranquia;
	private double valorOrcado;
	private double valorPago;
	private Situacao situacao;
	private String motivo;

	public Sinistro() {
	}
	public Sinistro(Seguro seguro, String numeroSinistro, TipoSinistro tipoSinistro, LocalDate dataSinistro,
			double valorFranquia, double valorOrcado, double valorPago, Situacao situacao, String motivo) {
		super();
		this.seguro = seguro;
		this.numeroSinistro = numeroSinistro;
		this.tipoSinistro = tipoSinistro;
		this.dataSinistro = dataSinistro;
		this.valorFranquia = valorFranquia;
		this.valorOrcado = valorOrcado;
		this.valorPago = valorPago;
		this.situacao = situacao;
		this.motivo = motivo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	public String getNumeroSinistro() {
		return numeroSinistro;
	}
	public void setNumeroSinistro(String numeroSinistro) {
		this.numeroSinistro = numeroSinistro;
	}
	public TipoSinistro getTipoSinistro() {
		return tipoSinistro;
	}
	public void setTipoSinistro(TipoSinistro tipoSinistro) {
		this.tipoSinistro = tipoSinistro;
	}
	public LocalDate getDataSinistro() {
		return dataSinistro;
	}
	public void setDataSinistro(LocalDate dataSinistro) {
		this.dataSinistro = dataSinistro;
	}
	public double getValorFranquia() {
		return valorFranquia;
	}
	public void setValorFranquia(double valorFranquia) {
		this.valorFranquia = valorFranquia;
	}
	public double getValorOrcado() {
		return valorOrcado;
	}
	public void setValorOrcado(double valorOrcado) {
		this.valorOrcado = valorOrcado;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	@Override
	public String toString() {
		return "Id: " + id 
				+ "\nSeguro: " + seguro 
				+ "\nNúmero Sinistro: " + numeroSinistro 
				+ "\nTipo Sinistro: " + tipoSinistro 
				+ "\nData Sinistro: " + dataSinistro 
				+ "\nValor Franquia: " + valorFranquia 
				+ "\nValor Orcado: " + valorOrcado 
				+ "\nValor Pago: " + valorPago 
				+ "\nSituação: " + situacao
				+ "\nMotivo: " + motivo;
	}	
	
	
}