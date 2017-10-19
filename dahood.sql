DROP TABLE IF EXISTS usuario, usuario_gusto, chat, gusto;


CREATE TABLE gusto (
                id_gusto INT NOT NULL AUTO_INCREMENT,
                nombre_gusto VARCHAR(40) NOT NULL,
                CONSTRAINT id_gusto PRIMARY KEY (id_gusto)
);


CREATE TABLE usuario (
                id_usuario INT NOT NULL,
                contrasena VARCHAR(40) NOT NULL,
                foto VARCHAR(100) NOT NULL,
                nombre VARCHAR(40) NOT NULL,
                apellido_p VARCHAR(40) NOT NULL,
                apellido_m VARCHAR(40) NOT NULL,
		nickname VARCHAR(40) NOT NULL,
		correo VARCHAR(40) NOT NULL,
                PRIMARY KEY(id_usuario),
		UNIQUE (nickname, correo)
		
);


CREATE TABLE chat (
                id_chat INT NOT NULL AUTO_INCREMENT,
                id_usuario1 INT,
                id_usuario2 INT,
                fecha DATE NOT NULL,
                ruta VARCHAR(100) NOT NULL,
                PRIMARY KEY (id_chat)
);


CREATE TABLE usuario_gusto (
                id_gusto INT NOT NULL,
                id_usuario INT NOT NULL,
                PRIMARY KEY (id_gusto, id_usuario)
);


ALTER TABLE usuario_gusto ADD CONSTRAINT gusto_usuario_gusto_fk
FOREIGN KEY (id_gusto)
REFERENCES gusto (id_gusto)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE usuario_gusto ADD CONSTRAINT usuario_usuario_gusto_fk
FOREIGN KEY (id_usuario)
REFERENCES usuario (id_usuario)
ON DELETE CASCADE
ON UPDATE NO ACTION;

ALTER TABLE chat ADD CONSTRAINT usuario_chat_fk
FOREIGN KEY (id_usuario1)
REFERENCES usuario (id_usuario)
ON DELETE SET NULL
ON UPDATE NO ACTION;

ALTER TABLE chat ADD CONSTRAINT usuario_chat_fk1
FOREIGN KEY (id_usuario2)
REFERENCES usuario (id_usuario)
ON DELETE SET NULL
ON UPDATE NO ACTION;
