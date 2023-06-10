INSERT INTO campeonato (nome, ano) VALUES
                                       ('Campeonato Brasileiro', 2023),
                                       ('Premier League', 2023),
                                       ('La Liga', 2023),
                                       ('Serie A', 2023),
                                       ('Bundesliga', 2023),
                                       ('Ligue 1', 2023),
                                       ('Primeira Liga', 2023);

INSERT INTO time (nome, vitorias, saldo_gols, campeonato_id) VALUES
                                                                 ('Juventus', 10, 15, 1),
                                                                 ('Real Madrid', 8, 12, 1),
                                                                 ('Barcelona', 7, 10, 1),
                                                                 ('Bayern Munich', 12, 20, 1),
                                                                 ('Paris Saint-Germain', 9, 18, 1),
                                                                 ('Liverpool', 11, 25, 1),
                                                                 ('Manchester City', 10, 22, 1),
                                                                 ('Inter Milan', 7, 15, 1);

INSERT INTO estadio (nome, endereco) VALUES
                                         ('Maracanã', 'Rio de Janeiro, Brasil'),
                                         ('Wembley Stadium', 'Londres, Reino Unido'),
                                         ('Camp Nou', 'Barcelona, Espanha'),
                                         ('San Siro', 'Milão, Itália'),
                                         ('Allianz Arena', 'Munique, Alemanha'),
                                         ('Parc des Princes', 'Paris, França'),
                                         ('Estádio da Luz', 'Lisboa, Portugal');

INSERT INTO jogador (nome, data_nascimento, altura, time_id) VALUES
                                                                 ('Cristiano Ronaldo', '1985-02-05', 1.87, 1),
                                                                 ('Lionel Messi', '1987-06-24', 1.70, 2),
                                                                 ('Neymar Jr.', '1992-02-05', 1.75, 3),
                                                                 ('Kylian Mbappé', '1998-12-20', 1.78, 4),
                                                                 ('Robert Lewandowski', '1988-08-21', 1.84, 5),
                                                                 ('Kevin De Bruyne', '1991-06-28', 1.81, 6),
                                                                 ('Mohamed Salah', '1992-06-15', 1.75, 7),
                                                                 ('Virgil van Dijk', '1991-07-08', 1.93, 8);

INSERT INTO partida (time_mandante_id, time_visitante_id, data, estadio_id, campeonato_id) VALUES
                                                                                               (1, 2, '2023-01-01', 1, 1),
                                                                                               (3, 4, '2023-01-02', 2, 1),
                                                                                               (5, 6, '2023-01-03', 3, 1),
                                                                                               (7, 8, '2023-01-04', 4, 1);

INSERT INTO resultado (gols_time_mandante, gols_time_visitante, partida_id) VALUES
                                                                                (2, 1, 1),
                                                                                (3, 0, 2),
                                                                                (1, 1, 3),
                                                                                (0, 0, 4);



