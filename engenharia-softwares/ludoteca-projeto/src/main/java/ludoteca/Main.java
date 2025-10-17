package ludoteca;

import ludoteca.ludoteca.Jogo;
import ludoteca.ludoteca.Ludoteca;

public class Main {
    public static void main(String[] args) {
        Ludoteca minhaLudoteca = new Ludoteca();
        minhaLudoteca.adicionarJogo(new Jogo("The Witcher 3", "RPG"));
        minhaLudoteca.adicionarJogo(new Jogo("Age of Empires II", "Estratégia"));

        System.out.println("Jogos na Ludoteca:");
        for (Jogo jogo : minhaLudoteca.getJogos()) {
            System.out.println("- " + jogo.getTitulo() + " (Gênero: " + jogo.getGenero() + ")");
        }
    }
}