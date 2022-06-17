set foreign_key_checks = 0;

delete from cidade;
delete from cozinha;
delete from estado;

set foreign_key_checks = 1; 

alter table cidade auto_increment = 1; 
alter table cozinha auto_increment = 1;
alter table estado auto_increment = 1;

insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Chinesa');

insert into estado (id, nome) values (1, 'Bahia');
insert into estado (id, nome) values (2, 'Ceará');
insert into estado (id, nome) values (3, 'Minas Gerais');

insert into cidade (id, nome, estado_id) values (1, 'Salvador', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 2);
insert into cidade (id, nome, estado_id) values (3, 'Fortaleza', 2);