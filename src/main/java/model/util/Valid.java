package model.util;

import model.exception.CampoInvalidoException;

public class Valid {
	static public boolean nomeValido(String nome){
		return nome.matches("^(?=.*[a-zA-Z]).{1,}$");
	}
}
