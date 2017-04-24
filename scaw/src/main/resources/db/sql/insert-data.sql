INSERT INTO person (FIRSTNAME, LASTNAME, EMAIL) VALUES ('Cintia', 'Gioia', 'cgioia@unlam.edu.ar'); 
INSERT INTO person (FIRSTNAME, LASTNAME, EMAIL) VALUES ('Walter', 'Ureta', 'wureta@unlam.edu.ar');
INSERT INTO person (FIRSTNAME, LASTNAME, EMAIL) VALUES ('Juan', 'Monteagudo', 'jmonteagudo@unlam.edu.ar');

INSERT INTO user_ (USERNAME, PASSWORD, EMAIL) VALUES('hector', '1234', 'vhg_92@outlook.com');
INSERT INTO user_ (USERNAME, PASSWORD, EMAIL) VALUES('martin', '1234', 'vhg_92@outlook.com');
INSERT INTO user_ (USERNAME, PASSWORD, EMAIL) VALUES('agustin', '1234', 'vhg_92@outlook.com');
INSERT INTO user_ (USERNAME, PASSWORD, EMAIL) VALUES('sergio', '1234', 'vhg_92@outlook.com');

INSERT INTO user_ (USERNAME, PASSWORD, EMAIL, CONDITION) VALUES('victor', '1234', 'vhg_92@outlook.com', 'ADMIN_USER');

INSERT INTO task (MODE, FIRSTNAME_TO_ADD, LASTNAME_TO_ADD, EMAIL_TO_ADD) VALUES ('ALTA', 'JUAN', 'LOPEZ', 'vic@hotmail.com');
INSERT INTO task (MODE, FIRSTNAME_TO_ADD, LASTNAME_TO_ADD, EMAIL_TO_ADD, TARGET_REGISTER) VALUES ('BAJA', 'Juan', 'Monteagudo', 'jmonteagudo@unlam.edu.ar', 1);
INSERT INTO task (MODE, FIRSTNAME_TO_ADD, LASTNAME_TO_ADD, EMAIL_TO_ADD) VALUES ('MODIFICACION', 'JUAN', 'LOPEZ', 'vic@hotmail.com');

--COMMIT;