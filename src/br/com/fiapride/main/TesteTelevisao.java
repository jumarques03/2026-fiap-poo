package br.com.fiapride.main;

import br.com.fiapride.model.Canal;
import br.com.fiapride.model.SmartTV;
import br.com.fiapride.model.TVPortatil;
import br.com.fiapride.model.Televisao;

public class TesteTelevisao {
    public static void main(String[] args) {
        System.out.println("=== TESTE DE ABSTRAÇÃO E POLIMORFISMO ===\n");

            // 1. PROVA DO ERRO DE COMPILAÇÃO
            // Se remover o comentário da linha abaixo, o Java apresentará o erro:
            // "Cannot instantiate the type Televisao"
            
            // Televisao tvGenerica = new Televisao("Sony", 40);


            // 2. INSTANCIANDO SUBCLASSES CONCRETAS
            SmartTV minhaSmart = new SmartTV("LG", 65.0, "WebOS", "Wi-Fi");
            TVPortatil minhaPortatil = new TVPortatil("Philco", 10.0, 85);

            // Criando um canal para teste de funcionalidade
            Canal canalFilmes = new Canal(10, "Filmes 24h");

            // 3. EXECUTANDO MÉTODOS NAS INSTÂNCIAS REAIS
            System.out.println("--- Testando SmartTV ---");
            minhaSmart.ligar();
            minhaSmart.exibirModelo(); // Método abstrato implementado
            minhaSmart.sintonizarCanal(canalFilmes);
            
            System.out.println("\n--- Testando TV Portátil ---");
            minhaPortatil.ligar();
            minhaPortatil.exibirModelo(); // Método abstrato implementado
            minhaPortatil.ajustarVolume(50);

            System.out.println("\n=== FIM DO TESTE: SUCESSO ===");
    }
}