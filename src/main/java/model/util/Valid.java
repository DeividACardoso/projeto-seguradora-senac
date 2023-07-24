package model.util;

import model.exception.CampoInvalidoException;

public abstract class Valid {
	
	static public boolean nomeValido(String nome){
		return nome.matches("^(?=.*[a-zA-Z]).{1,}$");
	}
	
	//valida 3 caracteres com número, texto ou caracteres especiais
	public static String removeCPF(String cpf) {
		return cpf.replace(".", "").replace("-", "");
	}
	
}
