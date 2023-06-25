package model.vo;

public enum TipoPessoa {

	CORRETOR (1),
	SEGURADO (2);
	
	private int valor;

	private TipoPessoa(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static TipoPessoa getTipoPessoaPorValor(int valor) {
		TipoPessoa tipoPessoa = null;
		for(TipoPessoa elemento: TipoPessoa.values()) {
			if(elemento.getValor() == valor) {
				tipoPessoa = elemento;
			}
		}
		return tipoPessoa;
	}
}
