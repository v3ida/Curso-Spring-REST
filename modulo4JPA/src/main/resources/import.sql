insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Chinesa');

insert into restaurante (cozinha_id, nome, taxa_frete) values (1, 'Thai Gourmet', 10);
insert into restaurante (cozinha_id, nome, taxa_frete) values (2, 'Thai Delivery', 9.50);
insert into restaurante (cozinha_id, nome, taxa_frete) values (3, 'China In Box', 8);

insert into estado (id, nome) values (1, 'Bahia');
insert into estado (id, nome) values (2, 'Ceará');
insert into estado (id, nome) values (3, 'Minas Gerais');

insert into forma_pagamento (id, descricao) values (1, 'Dinheiro');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de Crédito');
insert into forma_pagamento (id, descricao) values (3, 'Cartão de Débito');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into cidade (id, nome, estado_id) values (1, 'Salvador', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 2);
insert into cidade (id, nome, estado_id) values (3, 'Fortaleza', 2);