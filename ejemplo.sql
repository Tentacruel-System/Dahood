INSERT INTO usuario ( id_usuario, contrasena, foto, nombre, apellido_p, apellido_m, nickname, correo )
   VALUES ('1', 'h1234', 'foto', 'david', 'saules', 'rojas', 'davids', 'as@hotm' );
INSERT INTO usuario ( id_usuario, contrasena, foto, nombre, apellido_p, apellido_m, nickname, correo )
   VALUES ('2', 'h1233', 'foto2', 'david2', 'saules2', 'rojas2', 'davids2', 'as@hotmde' );
INSERT INTO usuario ( id_usuario, contrasena, foto, nombre, apellido_p, apellido_m, nickname, correo )
   VALUES ('3', 'h1234', 'foto', 'd', 'saul', 'rojas', 'dvds', 'ass@hotm' );

INSERT INTO gusto ( id_gusto, nombre_gusto)
   VALUES ('1', 'helados');
INSERT INTO gusto ( id_gusto, nombre_gusto)
   VALUES ('2', 'papas');
INSERT INTO gusto ( id_gusto, nombre_gusto)
   VALUES ('3', 'chile');
INSERT INTO gusto ( id_gusto, nombre_gusto)
   VALUES ('4', 'refresco');
INSERT INTO gusto ( id_gusto, nombre_gusto)
   VALUES ('5', 'pintura');

INSERT INTO usuario_gusto ( id_gusto, id_usuario)
   VALUES ('1', '1');
INSERT INTO usuario_gusto ( id_gusto, id_usuario)
   VALUES ('1', '2');
INSERT INTO usuario_gusto ( id_gusto, id_usuario)
   VALUES ('1', '3');
INSERT INTO usuario_gusto ( id_gusto, id_usuario)
   VALUES ('2', '1');
INSERT INTO usuario_gusto ( id_gusto, id_usuario)
   VALUES ('2', '2');
INSERT INTO usuario_gusto ( id_gusto, id_usuario)
   VALUES ('3', '2');

