package model.seletor;

import java.time.LocalDate;

import model.vo.Situacao;

public class SinistroSeletor extends BaseSeletor{

	private String numeroSinistro;
	private String nomeSegurado;
	private LocalDate dtInicio;
	private LocalDate dtFim;
	private Situacao situacao;
	
	@Override
	public boolean temFiltro() {
		
		return (this.numeroSinistro != null && this.numeroSinistro.trim().length() > 0)
				|| (this.nomeSegurado != null && this.nomeSegurado.trim().length() > 0)
				|| (this.dtInicio != null)
				|| (this.dtFim != null)
				|| (this.situacao != null);
	}
	
	public String getNumeroSinistro() {
		return numeroSinistro;
	}

	public void setNumeroSinistro(String numeroSinistro) {
		this.numeroSinistro = numeroSinistro;
	}

	public String getNomeSegurado() {
		return nomeSegurado;
	}

	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDate getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDate dtFim) {
		this.dtFim = dtFim;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	
	
	
}
