CREATE TABLE time (
                      id BIGINT PRIMARY KEY,
                      nome VARCHAR(100) NOT NULL,
                      vitorias INTEGER NOT NULL,
                      saldoGols INTEGER NOT NULL
);

CREATE TABLE campeonato (
                            id BIGINT PRIMARY KEY,
                            nome VARCHAR(100) NOT NULL,
                            ano INTEGER NOT NULL
);

CREATE TABLE jogador (
                         id BIGINT PRIMARY KEY,
                         nOme VARCHAR(100) NOT NULL,
                         birthdate DATE NOT NULL,
                         height DOUBLE NOT NULL,
                         time_id BIGINT NOT NULL,
                         FOREIGN KEY (time_id) REFERENCES time(id)
);

CREATE TABLE estadio (
                         id BIGINT PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         address VARCHAR(200) NOT NULL
);

CREATE TABLE partida (
                         id BIGINT PRIMARY KEY,
                         campeonato_id BIGINT NOT NULL,
                         estadio_id BIGINT NOT NULL,
                         time_mandante_id BIGINT NOT NULL,
                         time_visitante_id BIGINT NOT NULL,
                         data_hora DATETIME NOT NULL,
                         FOREIGN KEY (campeonato_id) REFERENCES campeonato(id),
                         FOREIGN KEY (estadio_id) REFERENCES estadio(id),
                         FOREIGN KEY (time_mandante_id) REFERENCES time(id),
                         FOREIGN KEY (time_visitante_id) REFERENCES time(id)
);

CREATE TABLE resultado (
                           id BIGINT PRIMARY KEY,
                           partida_id BIGINT NOT NULL,
                           gols_mandante INT NOT NULL,
                           gols_visitante INT NOT NULL,
                           FOREIGN KEY (partida_id) REFERENCES partida(id)
);

INSERT INTO campeonato (id, nome, ano) VALUES
    (1, 'Campeonato 2023', 2023);

-- Inserir dados na tabela "time"
INSERT INTO time (id, nome, vitorias, saldoGols) VALUES
                                               (1, 'Time A',3,5),
                                               (2, 'Time B',4,6),
                                               (3, 'Time C',5,7);

-- Inserir dados na tabela "jogador"
INSERT INTO jogador (id, nome, birthdate, height, time_id) VALUES
                                                                     (1, 'Jogador 1', '1990-01-01', 1.80, 1),
                                                                     (2, 'Jogador 2', '1992-03-15', 1.75, 1),
                                                                     (3, 'Jogador 3', '1995-06-10', 1.85, 2),
                                                                     (4, 'Jogador 4', '1998-09-25', 1.82, 2),
                                                                     (5, 'Jogador 5', '1993-12-20', 1.78, 3),
                                                                     (6, 'Jogador 6', '1996-08-05', 1.88, 3);

-- Inserir dados na tabela "estadio"
INSERT INTO estadio (id, nome, address) VALUES
                                             (1, 'Estádio 1', 'Endereço 1'),
                                             (2, 'Estádio 2', 'Endereço 2');

-- Inserir dados na tabela "partida"
INSERT INTO partida (id, data_hora, estadio_id, time_mandante_id, time_visitante_id, campeonato_id) VALUES
                                                                                                           (1, '2023-01-01', 1, 1, 2, 1),
                                                                                                           (2, '2023-01-02', 2, 3, 2, 1);

-- Inserir dados na tabela "resultado"
INSERT INTO resultado (id, partida_id, gols_mandante, gols_visitante) VALUES
                                                                      (1,1, 2, 1),
                                                                      (2, 2, 0, 0);