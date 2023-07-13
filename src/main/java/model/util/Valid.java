package model.util;

import model.exception.CampoInvalidoException;

public abstract class Valid {
	
	static public boolean nomeValido(String nome){
		return nome.matches("^(?=.*[a-zA-Z]).{1,}$");
	}
	
	//valida se o nome começa com letra maiúscula e o restante podendo ser em minúscula, com no mínimo 2 dígitos.
	public static boolean stringCaixaAltaEBaixa(String str) {
		return str.matches("[A-Z][a-z]{2,}");
	}
	
	//valida 3 caracteres com número, texto ou carcteres especiais
	public static boolean caracter(String texto) {
		return texto.matches("..."); 
	}
	
	//valida 3 caracteres com número, texto ou caracteres especiais
	public static String removeCPF(String cpf) {
		return cpf.replace(".", "").replace("-", "");
	}
	
}
