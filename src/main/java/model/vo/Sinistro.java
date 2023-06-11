package model.vo;

import java.time.LocalDate;
import model.vo.Pessoa;

public class Sinistro {

	private Integer id;
	private Pessoa pessoa;
	private String numeroSinistro;
	private TipoSinistro tipoSinistro;
	private Veiculo veiculo;
	private LocalDate dt_sinistro;
	private double valor_franquia;
	private double valor_orcado;
	private double valor_pago;
	private String situacao;
	private String motivo;
	
	public Sinistro(Pessoa pessoa, String numeroSinistro, TipoSinistro tipoSinistro, Veiculo veiculo,
			LocalDate dt_sinistro, double valor_franquia, double valor_orcado, double valor_pago, String situacao,
			String motivo) {
		super();
		this.pessoa = pessoa;
		this.numeroSinistro = numeroSinistro;
		this.tipoSinistro = tipoSinistro;
		this.veiculo = veiculo;
		this.dt_sinistro = dt_sinistro;
		this.valor_franquia = valor_franquia;
		this.valor_orcado = valor_orcado;
		this.valor_pago = valor_pago;
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
	public LocalDate getDt_sinistro() {
		return dt_sinistro;
	}
	public void setDt_sinistro(LocalDate dt_sinistro) {
		this.dt_sinistro = dt_sinistro;
	}
	public double getValor_franquia() {
		return valor_franquia;
	}
	public void setValor_franquia(double valor_franquia) {
		this.valor_franquia = valor_franquia;
	}
	public double getValor_orcado() {
		return valor_orcado;
	}
	public void setValor_orcado(double valor_orcado) {
		this.valor_orcado = valor_orcado;
	}
	public double getValor_pago() {
		return valor_pago;
	}
	public void setValor_pago(double valor_pago) {
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
