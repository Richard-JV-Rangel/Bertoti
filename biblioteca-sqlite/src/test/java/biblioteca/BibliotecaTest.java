package biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BibliotecaTest {

    // Este método roda ANTES de cada teste para garantir que a tabela esteja limpa
    @BeforeEach
    void setUp() {
        String sql = "DELETE FROM livros"; // Apaga todos os registros da tabela
        try (Connection conn = DatabaseManager.connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testAdicionarEBuscarLivroNoBanco() {
        // Cenário
        Biblioteca biblioteca = new Biblioteca();
        Livro novoLivro = new Livro("Código Limpo", "Robert C. Martin");

        // Ação
        biblioteca.addLivro(novoLivro);
        List<Livro> livrosDoBanco = biblioteca.getTodosOsLivros();

        // Verificação
        assertFalse(livrosDoBanco.isEmpty()); // Garante que a lista não está vazia
        assertEquals(1, livrosDoBanco.size());
        assertEquals("Código Limpo", livrosDoBanco.get(0).getTitulo());
        assertEquals("Robert C. Martin", livrosDoBanco.get(0).getAutor());
    }
}