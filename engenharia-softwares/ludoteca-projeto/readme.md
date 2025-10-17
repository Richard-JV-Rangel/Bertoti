## ATIVIDADES 4, 5 E 6: Código Java e Testes

A implementação do diagrama UML da Ludoteca (com as 3 classes) e seus testes automatizados utilizando JUnit estão disponíveis na pasta abaixo.

---
## Atividade 4 (UML):

```mermaid
classDiagram
    class Ludoteca {
        -List~Jogo~ jogos
        -List~Jogador~ jogadores
        +adicionarJogo(Jogo jogo) void
        +cadastrarJogador(Jogador jogador) void
        +buscarJogosPorGenero(String genero) List~Jogo~
        +buscarJogadorPorNickname(String nickname) Jogador
    }

    class Jogo {
        -String titulo
        -String genero
        -int anoLancamento
        +getTitulo() String
        +getGenero() String
    }

    class Jogador {
        -String nome
        -String nickname
        +getNome() String
        +getNickname() String
    }

    Ludoteca "1" -- "0..*" Jogo : possui
    Ludoteca "1" -- "0..*" Jogador : gerencia
```
