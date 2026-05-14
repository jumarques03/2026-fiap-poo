package br.com.fiapride.model;

public class TVPortatil extends Televisao implements Penduravel{
    private int nivelBateria;

    public TVPortatil(String marca, double tamanhoPolegadas, int nivelBateria) {
        super(marca, tamanhoPolegadas);
        this.setNivelBateria(nivelBateria);
    }

    public int getNivelBateria() { return this.nivelBateria; }

    private void setNivelBateria(int nivelBateria) {
        if (nivelBateria >= 0 && nivelBateria <= 100) {
            this.nivelBateria = nivelBateria;
        } else {
            System.out.println("Erro: valor da bateria errado");
        }
    }

    @Override
    public void ligar() {
        if (nivelBateria > 0) {
            super.ligar();
            System.out.println("TV portátil ligada com bateria em " + nivelBateria + "%.");
        } else {
            System.out.println("Bateria insuficiente para ligar a TV portátil.");
        }
    }

    @Override
    public void exibirModelo(){
        System.out.println("Eu sou uma Televisão Portátil");
    }

    @Override
    public void pendurar(){
        System.out.println("TV Portátil pendurada na parede da cozinha");
    }
}