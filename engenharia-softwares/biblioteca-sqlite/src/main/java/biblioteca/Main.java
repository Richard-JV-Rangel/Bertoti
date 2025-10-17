package biblioteca;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando aplicação da biblioteca...");
        Biblioteca biblioteca = new Biblioteca();

        // Adiciona alguns livros (se já existirem, não tem problema)
        System.out.println("Adicionando livros ao banco de dados...");
        biblioteca.addLivro(new Livro("Engenharia de Software", "Ian Sommerville"));
        biblioteca.addLivro(new Livro("O Programador Pragmático", "Andrew Hunt"));

        // --- DEMONSTRAÇÃO DA NOVA BUSCA ---
        System.out.println("\nBuscando pelo livro 'O Programador Pragmático'...");

        // Chama o novo método de busca
        List<Livro> livrosEncontrados = biblioteca.buscarLivroPorTitulo("O Programador Pragmático");

        System.out.println("\n--- Resultado da Busca Específica ---");
        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro com este título foi encontrado.");
        } else {
            for (Livro livro : livrosEncontrados) {
                System.out.println("Encontrado -> Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
            }
        }
        System.out.println("------------------------------------");
    }
}