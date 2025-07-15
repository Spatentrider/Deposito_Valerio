-- crea tabella
CREATE TABLE world.Clienti (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    cognome VARCHAR(100),
    email VARCHAR(100),
    eta INT,
    citta VARCHAR(100)
);
-- inserimento dati
INSERT INTO world.Clienti (id, nome, cognome, email, eta, citta) VALUES
(1, 'Marco', 'Rossi', 'marco.rossi@email.it', 34, 'Milano'),
(2, 'Giulia', 'Bianchi', 'giulia.bianchi@gmail.com', 28, 'Roma'),
(3, 'Luca', 'Verdi', 'luca.verdi@email.it', 45, 'Torino'),
(4, 'Elena', 'Russo', 'elena.russo@email.it', 31, 'Napoli'),
(5, 'Paolo', 'Ferrari', 'paolo.ferrari@gmail.it', 50, 'Bologna'),
(6, 'Anna', 'Esposito', 'anna.esposito@email.it', 27, 'Firenze'),
(7, 'Davide', 'Conti', 'davide.conti@email.it', 39, 'Genova'),
(8, 'Sara', 'Marino', 'sara.marino@gmail.com', 22, 'Verona'),
(9, 'Francesco', 'Lombardi', 'francesco.lombardi@email.it', 41, 'Bari'),
(10, 'Chiara', 'Fontana', 'chiara.fontana@email.it', 36, 'Catania'),
(11, 'Alessandro', 'Galli', 'alessandro.galli@email.it', 33, 'Padova'),
(12, 'Laura', 'Moretti', 'laura.moretti@gmail.com', 29, 'Palermo'),
(13, 'Simone', 'Rizzo', 'simone.rizzo@gmail.it', 38, 'Trieste'),
(14, 'Marta', 'Greco', 'marta.greco@email.it', 24, 'Parma'),
(15, 'Giorgio', 'De Luca', 'giorgio.deluca@email.it', 44, 'Reggio Emilia'),
(16, 'Ilaria', 'Monti', 'ilaria.monti@email.it', 26, 'Perugia'),
(17, 'Matteo', 'Bruno', 'matteo.bruno@email.it', 37, 'Livorno'),
(18, 'Beatrice', 'Vitale', 'beatrice.vitale@email.it', 30, 'Trento'),
(19, 'Stefano', 'Caruso', 'stefano.caruso@email.it', 48, 'Ancona'),
(20, 'Valentina', 'Barbieri', 'valentina.barbieri@email.it', 32, 'Lecce');


-- clienti con gmail
SELECT nome
FROM world.clienti
WHERE email LIKE '%@gmail.com'
ORDER BY nome;
-- clienti che iniziano per A
SELECT nome
FROM world.clienti
WHERE nome LIKE 'A%';

-- clienti con cognome di 5 lettere
SELECT cognome
FROM world.clienti
WHERE cognome LIKE  '_____'
ORDER BY cognome;

-- clienti con età tra 30 e 40
SELECT nome
FROM world.clienti
WHERE eta BETWEEN 30 AND 40
ORDER BY nome;

-- clienti con la parola 'roma' nella città
SELECT nome
FROM world.clienti
WHERE citta LIKE ('%roma%')
ORDER BY nome;
