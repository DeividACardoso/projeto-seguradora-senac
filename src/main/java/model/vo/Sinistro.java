package model.vo;

import java.time.LocalDate;
import model.vo.Pessoa;

public class Sinistro {

	private Integer id;
	private Pessoa pessoa;
	private String numeroSinistro;
	private TipoSinistro tipoSinistro;
	private Veiculo veiculo;
	private LocalDate dataSinistro;
	private double valorFranquia;
	private double valorOrcado;
	private double valorPago;
	private String situacao;
	private String motivo;
	public Sinistro(Pessoa pessoa, String numeroSinistro, TipoSinistro tipoSinistro, Veiculo veiculo,
			LocalDate dataSinistro, double valorFranquia, double valorOrcado, double valorPago, String situacao,
			String motivo) {
		super();
		this.pessoa = pessoa;
		this.numeroSinistro = numeroSinistro;
		this.tipoSinistro = tipoSinistro;
		this.veiculo = veiculo;
		this.dataSinistro = dataSinistro;
		this.valorFranquia = valorFranquia;
		this.valorOrcado = valorOrcado;
		this.valorPago = valorPago;
		this.situacao = situacao;
		this.motivo = motivo;
	}
	public Sinistro() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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
