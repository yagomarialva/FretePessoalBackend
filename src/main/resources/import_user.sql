insert into tb_user ( name, email, cpf, phone, city, uf, birthDate, cep, address )
    VALUES ('admin', 'email@email.com', '000.000.000-00', '(92) 98454-3122',
            'Manaus', 'AM', '01/01/2000', '') RETURNING id;

insert into profiles ( user_id, profiles) VALUES (id, 1);
insert into profiles ( user_id, profiles) VALUES (id, 2);