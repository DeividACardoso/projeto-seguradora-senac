package model.vo;

public class Veiculo {

	private Integer id;
	private Integer idSeguro;
	private String placaVeiculo;
	private String modelo;
	
	public Veiculo(Integer id, Integer idSeguro, String placaVeiculo, String modelo) {
		super();
		this.id = id;
		this.idSeguro = idSeguro;
		this.placaVeiculo = placaVeiculo;
		this.modelo = modelo;
	}
	
	public Veiculo() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdSeguro() {
		return idSeguro;
	}
	
	public void setIdSeguro(Integer idSeguro) {
		this.idSeguro = idSeguro;
	}
	
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}