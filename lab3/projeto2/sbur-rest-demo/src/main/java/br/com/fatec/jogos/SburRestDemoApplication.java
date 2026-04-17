package br.com.fatec.jogos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SburRestDemoApplication {

    public static void main(String[] args) {
        Database.initialize();
        SpringApplication.run(SburRestDemoApplication.class, args);
    }
}

@RestController
@RequestMapping("/games")
class RestApiDemoController {

    public RestApiDemoController() {
    }

    @GetMapping
    Iterable<Game> getGames() {
        List<Game> games = new ArrayList<>();
        try (Connection conn = Database.get();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, titulo FROM jogo")) {
            while (rs.next()) {
                games.add(new Game(rs.getLong("id"), rs.getString("titulo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @GetMapping("/{id}")
    Optional<Game> getGameById(@PathVariable Long id) {
        try (Connection conn = Database.get();
             PreparedStatement ps = conn.prepareStatement("SELECT id, titulo FROM jogo WHERE id = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Game(rs.getLong("id"), rs.getString("titulo")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @PostMapping
    Game postGame(@RequestBody Game game) {
        try (Connection conn = Database.get();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO jogo (titulo) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, game.getTitle());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    game.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return game;
    }

    @PutMapping("/{id}")
    ResponseEntity<Game> putGame(@PathVariable Long id, @RequestBody Game game) {
        boolean exists = false;
        try (Connection conn = Database.get();
             PreparedStatement ps = conn.prepareStatement("UPDATE jogo SET titulo = ? WHERE id = ?")) {
            ps.setString(1, game.getTitle());
            ps.setLong(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                exists = true;
                game.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (exists) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(postGame(game), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    void deleteGame(@PathVariable Long id) {
        try (Connection conn = Database.get();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM jogo WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Game {
    private Long id;
    private String title;

    @JsonCreator
    public Game(@JsonProperty("id") Long id, @JsonProperty("title") String title) {
        this.id = id;
        this.title = title;
    }

    public Game(String title) {
        this(null, title);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}