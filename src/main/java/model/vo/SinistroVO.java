package model.vo;

import java.time.LocalDate;

public class SinistroVO {

	private Integer id;
	private Integer idPessoa;
	private int numeroSinistro;
	private int nomeSegurado;
	private String placaVeiculo;
	private LocalDate dt_sinistro;
	private int valor_franquia;
	private int valor_orcado;
	private int valor_pago;
	private String situacao;
	private String motivo;

	public SinistroVO() {

	}

	public SinistroVO(Integer id, Integer idPessoa, int numeroSinistro, int nomeSegurado, String placaVeiculo,
			LocalDate dt_sinistro, int valor_franquia, int valor_orcado, int valor_pago, String situacao,
			String motivo) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.numeroSinistro = numeroSinistro;
		this.nomeSegurado = nomeSegurado;
		this.placaVeiculo = placaVeiculo;
		this.dt_sinistro = dt_sinistro;
		this.valor_franquia = valor_franquia;
		this.valor_orcado = valor_orcado;
		this.valor_pago = valor_pago;
		this.situacao = situacao;
		this.motivo = motivo;
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

	public int getNumeroSinistro() {
		return numeroSinistro;
	}

	public void setNumeroSinistro(int numeroSinistro) {
		this.numeroSinistro = numeroSinistro;
	}

	public int getNomeSegurado() {
		return nomeSegurado;
	}

	public void setNomeSegurado(int nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public LocalDate getDt_sinistro() {
		return dt_sinistro;
	}

	public void setDt_sinistro(LocalDate dt_sinistro) {
		this.dt_sinistro = dt_sinistro;
	}

	public int getValor_franquia() {
		return valor_franquia;
	}

	public void setValor_franquia(int valor_franquia) {
		this.valor_franquia = valor_franquia;
	}

	public int getValor_orcado() {
		return valor_orcado;
	}

	public void setValor_orcado(int valor_orcado) {
		this.valor_orcado = valor_orcado;
	}

	public int getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(int valor_pago) {
		this.valor_pago = valor_pago;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
