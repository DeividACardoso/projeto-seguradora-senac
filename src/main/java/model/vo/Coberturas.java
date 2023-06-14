package model.vo;

public enum Coberturas {
	
	PADRAO(100000.0, 100000.0, "Padrão", "Básica", "7 DIAS BÁSICO"),
    AMPLIADO(250000.0, 250000.0, "Ampliado", "Completa", "15 DIAS AMPLIADO"),
    PREMIUM(500000.0, 500000.0, "Premium", "Plus", "30 DIAS PREMIUM");

    private final double rcf_danos_materiais;
    private final double rcf_danos_corporais;
    private final String franquia;
    private final String assistencia;
    private final String carroReserva;

    Coberturas(double rcf_danos_materiais, double rcf_danos_corporais, String franquia, String assistencia, String carroReserva) {
        this.rcf_danos_materiais = rcf_danos_materiais;
        this.rcf_danos_corporais = rcf_danos_corporais;
        this.franquia = franquia;
        this.assistencia = assistencia;
        this.carroReserva = carroReserva;
    }

    public double getRcf_danos_materiais() {
        return rcf_danos_materiais;
    }

    public double getRcf_danos_corporais() {
        return rcf_danos_corporais;
    }

    public String getFranquia() {
        return franquia;
    }

    public String getAssistencia() {
        return assistencia;
    }

    public String getCarroReserva() {
        return carroReserva;
    }

}
