DROP TABLE IF EXISTS usertable;
DROP TABLE IF EXISTS ottelu; 
DROP TABLE IF EXISTS joukkue;
DROP TABLE IF EXISTS seura; 
DROP TABLE IF EXISTS kunta;

CREATE TABLE kunta
(kunta_id BIGSERIAL PRIMARY KEY
, kunnannimi VARCHAR(100) NOT NULL
);
    
CREATE TABLE seura (
seura_id BIGSERIAL PRIMARY KEY
, nimi VARCHAR(50) NOT NULL
, verkkosivu VARCHAR(50)
, kunta BIGINT
, FOREIGN KEY (kunta) REFERENCES kunta(kunta_id));


INSERT INTO seura (nimi, verkkosivu, kunta) 
VALUES ('Vantaan pallo', 'www.google.fi', 1),
	('Espoon pallo', 'www.google.fi', 2),
('Helsingin pallo', 'www.google.fi', 3),
('Tuusulan pallo', 'www.google.fi', 4),
('Kirkkonummen pallo', 'www.google.fi', 5),
('Sipoon pallo', 'www.google.fi', 6),
('Keravan pallo', 'www.google.fi', 7);

CREATE TABLE joukkue (
joukkue_id BIGSERIAL PRIMARY KEY
, nimi VARCHAR(50) NOT NULL
, logo VARCHAR(50)
, yhteyshlo VARCHAR(50)
, email VARCHAR(50)
, puh VARCHAR(50)
, seura BIGINT
, FOREIGN KEY (seura) REFERENCES seura(seura_id)
);

INSERT INTO joukkue (nimi, logo, yhteyshlo, email, puh, seura) 
VALUES ('I-HK P15', '', 'Aku Ankka', 'ankka@email.fi', '09-123654', 1),
('Espoon P15', '', 'Nimmi Ankka', 'ankka@email.fi', '09-123654', 2),
('Hesan tyypit', '', 'Aku Ankka', 'ankka@email.fi', '09-123654', 3),
('Tuusulan tiimi', '', 'Aku Ankka', 'ankka@email.fi', '09-123654', 4),
('Kirkkis', '', 'Aku Ankka', 'ankka@email.fi', '09-123654', 5),
('Sipoon tenavat', '', 'Aku Ankka', 'ankka@email.fi', '09-123654', 6),
('Keravan naperot', '', 'Aku Ankka', 'ankka@email.fi', '09-123654', 7),
('I-HK P15 toinen porukka', '', 'Aku Ankka', 'ankka@email.fi', '09-123654', 1);

CREATE TABLE ottelu (
    ottelu_id BIGSERIAL PRIMARY KEY,
    alkaa TIMESTAMP,
    loppuu TIMESTAMP,
    kotijoukkue BIGINT NOT NULL,
    vierasjoukkue BIGINT NOT NULL,
    kotimaalit INTEGER,
    vierasmaalit INTEGER,
    FOREIGN KEY (kotijoukkue) REFERENCES joukkue(joukkue_id),
    FOREIGN KEY (vierasjoukkue) REFERENCES joukkue(joukkue_id)
);

INSERT INTO ottelu (alkaa, loppuu, kotijoukkue, vierasjoukkue, kotimaalit, vierasmaalit) 
VALUES ('2024-04-05 17:20:00 +02:00', null , 1, 2, null, null),
('2024-03-25T12:25:00', null , 2, 3, null, null);

CREATE TABLE usertable
(id BIGSERIAL PRIMARY KEY
, username VARCHAR(200) NOT NULL
, password VARCHAR(250) NOT NULL
, email VARCHAR(100) NOT NULL
, role  VARCHAR(100) NOT NULL);

INSERT INTO usertable (username, password, email, role) 
VALUES ('user', '$2a$10$.nQ6BP7JVkyVoW0fyjYjNuiDHYDqPaa4.ojC/OFI9tT/8U8h1ayGe', 'email@email.com', 'USER'), 
('admin', '$2a$10$4eOXjTGvXDJfqEihKByH0e7ejIQbgQtG1Lzx.hz0eGEw5LPczHWTC', 'admin@email.com', 'ADMIN');


SELECT * FROM ottelu;
SELECT * FROM joukkue;
SELECT * FROM seura;
SELECT * FROM usertable;
SELECT * FROM kunta;
