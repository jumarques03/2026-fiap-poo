package br.com.fiapride.main;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Veiculo;

public class SistemaPrincipal {
    public static void main(String[] args) {
        
        System.out.println("=== FIAPRIDE: Teste de Classes Abstratas ===");
        System.out.println();
        
        // TESTE 1: Tentar criar Veiculo direto (VAI DAR ERRO)
        // Descomente a linha abaixo para ver o erro de compilação!
        
        // Veiculo v = new Veiculo("ABC-1234", "Generico");
        // ❌ ERRO: "Veiculo is abstract; cannot be instantiated"
        // O Java bloqueia porque Veiculo é um molde, não um objeto real!
        
        // TESTE 2: Criar objetos concretos (FUNCIONA)
        Veiculo taxi = new Carro("ABC-1234", "Chevrolet Onix");
        Veiculo mototaxi = new Moto("MOT-9999", "Honda Biz");
        
        // TESTE 3: Chamar método abstrato implementado
        System.out.println("Identificação dos Veículos:");
        taxi.exibirTipo();      // Saída: Sou um Carro
        mototaxi.exibirTipo();  // Saída: Sou uma Moto
        
        System.out.println();
        System.out.println("=== Polimorfismo com Classe Abstrata ===");
        
        // Podemos criar um array de Veiculo (tipo abstrato)
        // mas os OBJETOS são instâncias das filhas concretas
        Veiculo[] frota = new Veiculo[] {
            new Carro("CAR-1111", "Fiat Uno"),
            new Moto("MOT-2222", "Yamaha"),
            new Carro("CAR-3333", "Honda Civic")
        };
        
        for (Veiculo v : frota) {
            v.exibirTipo();
            System.out.println("---");
        }
    }
}