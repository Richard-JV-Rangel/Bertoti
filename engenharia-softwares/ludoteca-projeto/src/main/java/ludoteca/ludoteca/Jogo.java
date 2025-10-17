package ludoteca.ludoteca;

public class Jogo {
    private String titulo;
    private String genero;

    public Jogo(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }
}