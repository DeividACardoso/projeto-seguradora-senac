package model.vo;

public class Veiculo {

	private Integer id;
	private String placaVeiculo;
	private String modelo;
	
	public Veiculo(Integer id, String placaVeiculo, String modelo) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return placaVeiculo + " Modelo: " + modelo;

	}
	
}