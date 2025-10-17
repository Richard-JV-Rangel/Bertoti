package ludoteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ludoteca.ludoteca.Jogo;
import ludoteca.ludoteca.Ludoteca;

public class LudotecaTest {

    @Test
    public void testAdicionarJogo() {
        // Cenário
        Ludoteca ludoteca = new Ludoteca();
        Jogo jogo = new Jogo("Stardew Valley", "Simulação");

        // Ação
        ludoteca.adicionarJogo(jogo);

        // Verificação
        assertEquals(1, ludoteca.getJogos().size());
        assertEquals("Stardew Valley", ludoteca.getJogos().get(0).getTitulo());
    }
}