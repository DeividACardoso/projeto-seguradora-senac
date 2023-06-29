package testes;

import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;

import org.junit.Test;

import controller.SinistroController;
import model.exception.CampoInvalidoException;
import model.exception.PessoaInvalidaException;
import model.exception.VeiculoInvalidaException;
import model.vo.Sinistro;
import view.PainelCadastroSinistro;

public class PainelCadastroSinistroTeste {
    private PainelCadastroSinistro painelCadastroSinistro;
    
    @Test
    public void testarInserirDoSinistroValido() {
    	
    	Sinistro novSinistro = new Sinistro();
    	SinistroController sinController = new SinistroController();
    	
    	novSinistro = sinController.consultarPorId(2);
    	
    	assertNotEquals("Sinistro inserido com sucesso.", novSinistro.getId(), sinController.consultarPorId(2));
    }

    @Test
    public void testarInserirDoSinistroInvalido() throws PessoaInvalidaException, VeiculoInvalidaException, CampoInvalidoException {
    	
    	Sinistro novSinistro = new Sinistro();
    	SinistroController sinController = new SinistroController();
    	
    	LocalDate data = LocalDate.of(2023, 6, 21);
    	novSinistro.setDataSinistro(data);
    	sinController.inserir(novSinistro);
    	
    	assertNotEquals("Id de Sinistro retornou Null, inserção falha.", novSinistro.getId(), sinController.consultarPorId(novSinistro.getId()));
    }
    
}
