package br.com.fiapride.model;

public class SmartTV extends Televisao {

    private String tipoConexaoInternet;
    private String sistemaOperacional;

    public SmartTV(String marca, double tamanhoPolegadas, String sistemaOperacional, String tipoConexaoInternet) {
        super(marca, tamanhoPolegadas);
        this.setTipoConexaoInternet(tipoConexaoInternet);
        this.sistemaOperacional = sistemaOperacional;    
    }

    private void setTipoConexaoInternet(String tipoConexaoInternet) {
        String conexao = tipoConexaoInternet.toLowerCase().trim();
        if (conexao.equals("wifi") || conexao.equals("wi-fi")) {
            this.tipoConexaoInternet = "Wi-Fi";
        } else if (conexao.equals("cabo")) {
            this.tipoConexaoInternet = "Cabo";
        } else {
            System.out.println("ERRO: Tipo de conexão '" + tipoConexaoInternet + "' inválido.");
        }
    }

    public String getTipoConexaoInternet() { return this.tipoConexaoInternet; }
    public String getSistemaOperacional() { return this.sistemaOperacional; }

    @Override
    public void ligar() {
        super.ligar();
        if (getEstaLigada()) {
            System.out.println("Sistema operacional " + sistemaOperacional + " iniciado.");
            System.out.println("Conectado via " + tipoConexaoInternet + ".");
        }
    }

    @Override
    public void exibirModelo(){
        System.out.println("Eu sou uma Smart TV");
    }
}