package br.com.fiapride.main;

import br.com.fiapride.model.SmartTV;
import br.com.fiapride.model.TVPortatil;
import br.com.fiapride.model.Quadro;
import br.com.fiapride.model.Penduravel;

public class TesteTelevisao {
    public static void main(String[] args) {
            
            System.out.println("=== TESTE DE INTERFACES E POLIMORFISMO MULTI-HIERARQUIA ===\n");

            // 1. Criando os objetos
            SmartTV smart = new SmartTV("Samsung", 55, "Tizen", "Wi-Fi");
            TVPortatil portatil = new TVPortatil("Sony", 12, 100);
            Quadro quadro = new Quadro("Vincent van Gogh", "A Noite Estrelada");

            // 2. O GRANDE TRUNFO: Criar um array da INTERFACE
            // Eles só têm em comum a interface Penduravel.
            Penduravel[] objetosNaParede = new Penduravel[3];
            objetosNaParede[0] = smart;
            objetosNaParede[1] = portatil;
            objetosNaParede[2] = quadro;

            // 3. Percorrendo o array polimorficamente
            System.out.println("--- Executando a ação de pendurar objetos ---");
            for (Penduravel item : objetosNaParede) {
                // Não importa se é uma TV ou um Quadro, o Java garante que todos têm o método pendurar()
                item.pendurar();
            }

            System.out.println("\n=== SUCESSO: Diferentes hierarquias usando o mesmo contrato! ===");
        }
}