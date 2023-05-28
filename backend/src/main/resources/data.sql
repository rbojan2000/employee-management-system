INSERT INTO addresses(city, state, street) VALUES ('Vancouver', 'Canada', 'Denman Street' );
INSERT INTO addresses(city, state, street) VALUES ('Paris', 'France', 'The Champs-Élysées' );

INSERT INTO project(duration, name) VALUES (561, 'Road to victory');
INSERT INTO project(duration, name) VALUES (272, 'Arizona show');

INSERT INTO users (name, surname, email, password, enabled, approved, address_id, salt) VALUES ('John', 'Doe', 'johndoe@example.com', '$2a$10$F395fsSeFDGUdOzMG1W8g.Kr2DgkISpgPHntwiemZU5poWrzfYZ5m', true, true, 1, 'DpiHCZSfWiw=');
INSERT INTO users (name, surname, email, password, enabled, approved, address_id, salt) VALUES ('Nick', 'Ostodrift', 'nick@mail.com', '$2a$10$F395fsSeFDGUdOzMG1W8g.Kr2DgkISpgPHntwiemZU5poWrzfYZ5m', true, true, 2, 'DpiHCZSfWiw=');

INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_SOFTWARE_ENGINEER');
INSERT INTO role (name) VALUES ('ROLE_HUMAN_RESOURCES');

INSERT INTO software_engineer(id) VALUES (2);

INSERT INTO engineer_project_assignment(description, software_engineer_id, project_id) VALUES ('Development of the project: identify gaps in service provision and encourage the development of effective, high quality innovative services. Play a key role in developing partnership working with other organisations and professionals.', 2, 1);
INSERT INTO engineer_project_assignment(description, software_engineer_id, project_id) VALUES ('Deployment of the project.', 2, 2);

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);

INSERT INTO skills(grade, name) VALUES (5, 'java');
INSERT INTO skills(grade, name) VALUES (4, 'C#');

INSERT INTO user_skills(software_engineer_id, skill_id) VALUES (2, 1);
INSERT INTO user_skills(software_engineer_id, skill_id) VALUES (2, 2);

INSERT INTO permission(description, url, method) VALUES ('Changing profile details.', 'https://localhost:4200/software-engineer', 'PUT');
INSERT INTO permission(description, url, method) VALUES ('Fetching all projects that the user works on.', 'https://localhost:4200/project/user/{id}', 'GET');
INSERT INTO permission(description, url, method) VALUES ('Updating the user''s activity description on the project.', 'https://localhost:4200/project', 'PUT');
INSERT INTO permission(description, url, method) VALUES ('Fetching all user''s skills.', 'https://localhost:4200/skill/user/{id}', 'GET');
INSERT INTO permission(description, url, method) VALUES ('Creating new skill.', 'https://localhost:4200/skill', 'POST');

INSERT INTO permission_role(permission_id, role_id) VALUES (1, 2);
INSERT INTO permission_role(permission_id, role_id) VALUES (2, 2);
INSERT INTO permission_role(permission_id, role_id) VALUES (3, 2);
INSERT INTO permission_role(permission_id, role_id) VALUES (4, 2);
INSERT INTO permission_role(permission_id, role_id) VALUES (5, 2);
INSERT INTO permission_role(permission_id, role_id) VALUES (1, 3);
INSERT INTO permission_role(permission_id, role_id) VALUES (4, 3);
INSERT INTO permission_role(permission_id, role_id) VALUES (5, 3);
