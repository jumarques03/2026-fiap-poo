package br.com.fiapride.model;

public class Carro extends Veiculo {
    
    private int capacidadePassageiros;

    public Carro (String placa, String modelo) {
        super(placa, modelo);
        this.setCapacidadePassageiros(4);
    }

    public int getCapacidadePassageiros() {
        return this.capacidadePassageiros;
    }

    private void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }
    
    @Override 
    // Anotação obrigatória (Boas Práticas!)    
    public String calcularAutonomia() {
        double kmRestante = this.getNivelCombustivel() * 10.0;
        return "Autonomia: " + kmRestante + " km (Consumo de 10 km/l).";
    }

    @Override
    public void exibirTipo() {
        System.out.println("Sou um Carro");
    }
}