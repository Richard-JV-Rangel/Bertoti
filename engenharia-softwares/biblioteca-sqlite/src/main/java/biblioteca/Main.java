package biblioteca;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando aplicação da biblioteca...");

        // 1. Cria uma instância da Biblioteca
        // O construtor da Biblioteca já chama o DatabaseManager.createTable()
        Biblioteca biblioteca = new Biblioteca();

        // 2. Adiciona alguns livros
        System.out.println("Adicionando livros ao banco de dados...");
        biblioteca.addLivro(new Livro("Engenharia de Software", "Ian Sommerville"));
        biblioteca.addLivro(new Livro("O Programador Pragmático", "Andrew Hunt"));
        biblioteca.addLivro(new Livro("Padrões de Projetos", "Erich Gamma"));

        // 3. Busca todos os livros do banco de dados
        System.out.println("\nBuscando todos os livros salvos...");
        List<Livro> livrosDoBanco = biblioteca.getTodosOsLivros();

        // 4. Imprime os livros encontrados
        System.out.println("\n--- Livros recuperados do banco de dados ---");
        if (livrosDoBanco.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            for (Livro livro : livrosDoBanco) {
                System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Aplicação finalizada.");
    }
}