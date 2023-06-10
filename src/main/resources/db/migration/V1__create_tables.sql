CREATE TABLE campeonato (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            nome VARCHAR(255) NOT NULL,
                            ano INT NOT NULL
);

CREATE TABLE time (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      nome VARCHAR(255) NOT NULL,
                      vitorias INT NOT NULL,
                      saldo_gols INT NOT NULL,
                      campeonato_id INT NOT NULL
);

CREATE TABLE estadio (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(255) NOT NULL,
                         endereco VARCHAR(255) NOT NULL
);

CREATE TABLE jogador (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(255) NOT NULL,
                         data_nascimento DATE NOT NULL,
                         altura DOUBLE NOT NULL,
                         time_id BIGINT,
                         CONSTRAINT fk_jogador_time FOREIGN KEY (time_id) REFERENCES time (id)
);

CREATE TABLE partida (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         time_mandante_id BIGINT,
                         time_visitante_id BIGINT,
                         data DATE NOT NULL,
                         estadio_id BIGINT,
                         campeonato_id INT NOT NULL,
                         CONSTRAINT fk_partida_time_mandante FOREIGN KEY (time_mandante_id) REFERENCES time (id),
                         CONSTRAINT fk_partida_time_visitante FOREIGN KEY (time_visitante_id) REFERENCES time (id),
                         CONSTRAINT fk_partida_estadio FOREIGN KEY (estadio_id) REFERENCES estadio (id)
);

CREATE TABLE resultado (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           gols_time_mandante INT NOT NULL,
                           gols_time_visitante INT NOT NULL,
                           partida_id BIGINT,
                           CONSTRAINT fk_resultado_partida FOREIGN KEY (partida_id) REFERENCES partida (id)
);
