INSERT INTO addresses(city, state, street) VALUES ('Vancouver', 'Canada', 'Denman Street' );
INSERT INTO addresses(city, state, street) VALUES ('Paris', 'France', 'The Champs-Élysées' );

INSERT INTO users (name, surname, email, password, enabled, approved, address_id) VALUES ('John', 'Doe', 'johndoe@example.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, true, 1);
INSERT INTO users (name, surname, email, password, enabled, approved, address_id) VALUES ('Nick', 'Ostodrift', 'nick@mail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, true, 2);

INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_SOFTWARE_ENGINEER');

INSERT INTO software_engineer(id) VALUES (2);

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);
