package model.vo;

public enum TipoSinistro {

	COLISAO (1),
	ROUBO_FURTO (2),
	CAUSAS_NATURAIS (3),
	TERCEIROS (4);
	
	private int valor;

	private TipoSinistro(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static TipoSinistro getTipoSinistroPorValor(int valor) {
		TipoSinistro tipoSinistro = null;
		for(TipoSinistro elemento: TipoSinistro.values()) {
			if(elemento.getValor() == valor) {
				tipoSinistro = elemento;
			}
		}
		return tipoSinistro;
	}
	
}
