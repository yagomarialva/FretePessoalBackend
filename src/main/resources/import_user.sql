insert into tb_user ( name, email, cpf, phone, city, uf, birth_date, cep, address, password )
    VALUES ('Administrator', 'admin@email.com', '000.000.000-00', '(92) 98454-3122',
            'Manaus', 'AM', '01/01/2000', '69000000', 'Tv Araquari 184',
            '$2a$10$o61u5t/r0R2jhOouDGWCFuwOLl31NIh8UiDVzRN4TSBybUs4keCmW');

insert into tb_user ( name, email, cpf, phone, city, uf, birth_date, cep, address, password )
    VALUES ('Darlison Osorio', 'darlison@email.com', '111.111.111-11', '(92) 99999-9999',
            'Manaus', 'AM', '01/01/2000', '69000000', 'Tv Araquari 184',
            '$2a$10$o61u5t/r0R2jhOouDGWCFuwOLl31NIh8UiDVzRN4TSBybUs4keCmW');

insert into tb_user ( name, email, cpf, phone, city, uf, birth_date, cep, address, password )
    VALUES ('Raissa Ramos', 'raissa@email.com', '222.222.222-22', '(92) 88888-8888',
            'Manaus', 'AM', '01/01/2000', '69000000', 'Rua 01, N 50',
            '$2a$10$o61u5t/r0R2jhOouDGWCFuwOLl31NIh8UiDVzRN4TSBybUs4keCmW');

insert into tb_user ( name, email, cpf, phone, city, uf, birth_date, cep, address, password )
    VALUES ('Yago Marialva', 'yago@email.com', '333.333.333-33', '(92) 77777-7777',
            'Manaus', 'AM', '01/01/2000', '69000000', 'Rua 01, N 50',
            '$2a$10$o61u5t/r0R2jhOouDGWCFuwOLl31NIh8UiDVzRN4TSBybUs4keCmW');

insert into profiles ( user_id, profiles ) VALUES (1, 1);
insert into profiles ( user_id, profiles ) VALUES (1, 2);
insert into profiles ( user_id, profiles ) VALUES (2, 1);
insert into profiles ( user_id, profiles ) VALUES (2, 2);
insert into profiles ( user_id, profiles ) VALUES (3, 1);
insert into profiles ( user_id, profiles ) VALUES (3, 2);
insert into profiles ( user_id, profiles ) VALUES (4, 1);
insert into profiles ( user_id, profiles ) VALUES (4, 2);

insert into city (id, name) VALUES (1, 'Manaus');
insert into city (id, name) VALUES (2, 'São Paulo');
insert into city (id, name) VALUES (3, 'Rio de Janeiro');
insert into city (id, name) VALUES (4, 'Porto Alegre');
insert into city (id, name) VALUES (5, 'Fortaleza');
insert into city (id, name) VALUES (6, 'Belo Horizonte');
