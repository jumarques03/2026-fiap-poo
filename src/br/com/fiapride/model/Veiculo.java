package br.com.fiapride.model;

public abstract class Veiculo {
    
    private String placa;
    private String modelo;
    private double nivelCombustivel;
    
    public Veiculo(String placa, String modelo) {
        this.setPlaca(placa);
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }
    
    public void atualizarPlaca(String novaPlaca) {
        System.out.println("🔄 Solicitada atualização de placa no Detran para o veículo " + this.modelo + "...");
        this.setPlaca(novaPlaca); 
    }

    private void setPlaca(String novaPlaca) {
        if (novaPlaca != null && !novaPlaca.trim().isEmpty()) {
            this.placa = novaPlaca;
        } else {
            System.out.println("❌ Erro de Validação: A placa informada é inválida!");
        }
    }
    
    public String calcularAutonomia() {
        return "Autonomia não definida para um veículo genérico.";
    }

    public void abaster(int quantidade) {
        this.setNivelCombustivel( this.getNivelCombustivel() + quantidade);
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    private void setNivelCombustivel(double nivelCombustivel) {
        this.nivelCombustivel = nivelCombustivel;
    }

    public abstract void exibirTipo();
}