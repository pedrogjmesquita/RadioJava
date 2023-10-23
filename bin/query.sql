CREATE USER 'radiosuser'@'localhost' IDENTIFIED BY 'radiosuser';

GRANT ALL PRIVILEGES ON * . * TO 'radiosuser'@'localhost';

FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS radios;

USE radios;

CREATE TABLE IF NOT EXISTS frequencias (
    freq VARCHAR(10) NOT NULL,
    nome VARCHAR(25) NOT NULL,
    path VARCHAR(200) not null
);


INSERT INTO frequencias (freq, nome, path) VALUES ('76.7 MHz', 'Jovem Pan News', './lib/sound/midias/76_7.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('77.5 MHz', 'Radio Capital', './lib/sound/midias/77_5.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('77.9 MHz', 'Cultura Brasil', './lib/sound/midias/77_9.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('79.5 MHz', 'Radio São Paulo', './lib/sound/midias/79_5.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('79.9 MHz', 'Nova Difusora', './lib/sound/midias/79_9.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('80.9 MHz', 'Radio RBC FM', './lib/sound/midias/80_9.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('81.9 MHz', 'Radio ABC', './lib/sound/midias/81_9.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('82.9 MHz', 'Melhor FM', './lib/sound/midias/82_9.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('83.1 MHz', 'Vibe Mundial', './lib/sound/midias/83_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('84.3 MHz', 'Nova Morada', './lib/sound/midias/84_3.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('84.7 MHz', 'Gru FM', './lib/sound/midias/84_7.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('86.3 MHz', 'Bandeirantes', './lib/sound/midias/86_3.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('87.1 MHz', 'Radio Nacional', './lib/sound/midias/87_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('88.1 MHz', 'Gazeta FM', './lib/sound/midias/88_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('88.5 MHz', 'Radio Laser FM','./lib/sound/midias/88_5.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('89.1 MHz', 'Radio Rock', './lib/sound/midias/89_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('89.7 MHz', 'Novabrasil FM', './lib/sound/midias/89_7.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('90.1 MHz', 'Radio Gospel', './lib/sound/midias/90_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('90.5 MHz', 'CBN', './lib/sound/midias/90_5.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('91.3 MHz', 'Radio Disney', './lib/sound/midias/91_3.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('92.5 MHz', 'Radio Kiss', './lib/sound/midias/92_5.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('92.9 MHz', 'Massa FM', './lib/sound/midias/92_9.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('93.3 MHz', 'Estilo FM', './lib/sound/midias/93_3.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('93.7 MHz', 'Radio USP FM', './lib/sound/midias/93_7.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('94.1 MHz', 'Nossa Radio', './lib/sound/midias/94_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('94.7 MHz', 'Antena 1', './lib/sound/midias/94_7.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('95.3 MHz', 'Nativa FM', './lib/sound/midias/95_3.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('96.1 MHz', 'Band FM', './lib/sound/midias/96_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('96.9 MHz', 'BandNews FM', './lib/sound/midias/96_9.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('97.7 MHz', 'Energia 97 FM', './lib/sound/midias/97_7.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('98.5 MHz', 'Metropolitana', './lib/sound/midias/98_5.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('99.5 MHz', 'Rede Aleluia', './lib/sound/midias/99_5.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('100.1 MHz', 'Transamérica', './lib/sound/midias/100_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('100.9 MHz', 'Jovem Pan FM', './lib/sound/midias/100_9.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('101.7 MHz', 'Alpha FM', './lib/sound/midias/101_7.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('102.5 MHz', 'Imprensa FM', './lib/sound/midias/102_5.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('103.3 MHz', 'Cultura FM', './lib/sound/midias/103_3.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('104.1 MHz', 'Top FM', './lib/sound/midias/104_1.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('105.7 MHz', 'Musical FM', './lib/sound/midias/105_7.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('106.3 MHz', 'Radio Mix FM', './lib/sound/midias/106_3.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('107.3 MHz', 'Eldorado FM', './lib/sound/midias/107_3.wav');
INSERT INTO frequencias (freq, nome, path) VALUES ('107.9 MHz', 'Tropical FM', './lib/sound/midias/107_9.wav');