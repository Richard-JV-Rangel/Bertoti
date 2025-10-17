package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Biblioteca {

    public Biblioteca() {
        // Garante que a tabela seja criada ao instanciar a biblioteca
        DatabaseManager.createTable();
    }

    public void addLivro(Livro livro) {
        String sql = "INSERT INTO livros(titulo, autor) VALUES(?,?)";

        try (Connection conn = DatabaseManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar livro: " + e.getMessage());
        }
    }

    public List<Livro> getTodosOsLivros() {
        String sql = "SELECT titulo, autor FROM livros";
        List<Livro> livros = new LinkedList<>();

        try (Connection conn = DatabaseManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                livros.add(new Livro(rs.getString("titulo"), rs.getString("autor")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar livros: " + e.getMessage());
        }
        return livros;
    }
}