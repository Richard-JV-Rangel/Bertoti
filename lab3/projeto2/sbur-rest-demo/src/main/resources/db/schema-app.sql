CREATE TABLE IF NOT EXISTS jogo (
                                    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    titulo     VARCHAR(150) NOT NULL
    ) ENGINE=InnoDB;

INSERT INTO jogo (titulo)
SELECT 'Baldurs Gate 3'
    WHERE NOT EXISTS (SELECT 1 FROM jogo WHERE titulo='Baldurs Gate 3');

INSERT INTO jogo (titulo)
SELECT 'The Witcher 3'
    WHERE NOT EXISTS (SELECT 1 FROM jogo WHERE titulo='The Witcher 3');

INSERT INTO jogo (titulo)
SELECT 'Hollow Knight'
    WHERE NOT EXISTS (SELECT 1 FROM jogo WHERE titulo='Hollow Knight');

INSERT INTO jogo (titulo)
SELECT 'Elden Ring'
    WHERE NOT EXISTS (SELECT 1 FROM jogo WHERE titulo='Elden Ring');