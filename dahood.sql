DROP TABLE IF EXISTS Gusto, Usuario, Chat, Usuario_gusto;


CREATE TABLE Gusto (
                id_gusto INT NOT NULL AUTO_INCREMENT,
                nombre_gusto VARCHAR(40) NOT NULL,
                CONSTRAINT id_gusto PRIMARY KEY (id_gusto)
);


CREATE TABLE Usuario (
                id_usuario INT NOT NULL,
                contrasena VARCHAR(40) NOT NULL,
                foto VARCHAR(100) NOT NULL,
                nombre VARCHAR(40) NOT NULL,
                apellido_p VARCHAR(40) NOT NULL,
                apellido_m VARCHAR(40) NOT NULL,
                CONSTRAINT id_Usuario PRIMARY KEY (id_usuario)
);


CREATE TABLE Chat (
                id_chat INT NOT NULL AUTO_INCREMENT,
                id_usuario1 INT,
                id_usuario2 INT,
                fecha DATE NOT NULL,
                ruta VARCHAR(100) NOT NULL,
                CONSTRAINT chat_pk PRIMARY KEY (id_chat)
);


CREATE TABLE Usuario_gusto (
                id_gusto INT NOT NULL,
                id_usuario INT NOT NULL,
                CONSTRAINT usuario_gusto_pk PRIMARY KEY (id_gusto, id_usuario)
);


ALTER TABLE Usuario_gusto ADD CONSTRAINT Gusto_Usuario_gusto_fk
FOREIGN KEY (id_gusto)
REFERENCES Gusto (id_gusto)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Usuario_gusto ADD CONSTRAINT Usuario_Usuario_gusto_fk
FOREIGN KEY (id_usuario)
REFERENCES Usuario (id_usuario)
ON DELETE CASCADE
ON UPDATE NO ACTION;

ALTER TABLE Chat ADD CONSTRAINT Usuario_chat_fk
FOREIGN KEY (id_usuario1)
REFERENCES Usuario (id_usuario)
ON DELETE SET NULL
ON UPDATE NO ACTION;

ALTER TABLE Chat ADD CONSTRAINT Usuario_chat_fk1
FOREIGN KEY (id_usuario2)
REFERENCES Usuario (id_usuario)
ON DELETE SET NULL
ON UPDATE NO ACTION;
