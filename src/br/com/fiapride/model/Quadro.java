package br.com.fiapride.model;

// A classe Quadro assina o contrato Penduravel
public class Quadro implements Penduravel {
    
    private String artista;
    private String titulo;

    public Quadro(String artista, String titulo) {
        this.artista = artista;
        this.titulo = titulo;
    }

    // Implementação obrigatória do método da interface
    @Override
    public void pendurar() {
        System.out.println("O quadro '" + titulo + "' do artista " + artista + " foi pendurado na parede.");
    }

    // Getters e Setters podem ser adicionados conforme a necessidade
    public String getArtista() { return artista; }
    public String getTitulo() { return titulo; }
}