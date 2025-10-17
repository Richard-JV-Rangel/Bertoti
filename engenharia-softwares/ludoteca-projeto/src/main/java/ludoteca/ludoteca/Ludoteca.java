package ludoteca.ludoteca;

import java.util.LinkedList;
import java.util.List;

public class Ludoteca {
    private List<Jogo> jogos = new LinkedList<>();
    private List<Jogador> jogadores = new LinkedList<>();

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void cadastrarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
}