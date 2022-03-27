insert into tbl_cliente values (1,1,1,50,sysdate(),sysdate(),'33361417880', 'Teste Fantasia', 'SSP','Obs teste','Teste Razao Social');

insert into tbl_endereco values (1, 'Vila Bancaria', '03918090', 'São Paulo', 'SP', 'Rua Teste');

insert into tbl_operador values (1, '$2a$12$R15nbyDTG9TNj2/hus2nKuQPaBUg6J6J9OR2ZDRMJfdwHjDBvkNKC','wsilva');
insert into tbl_operador values (2, '$2a$12$R15nbyDTG9TNj2/hus2nKuQPaBUg6J6J9OR2ZDRMJfdwHjDBvkNKC','teste');

insert into tbl_equipamento values (1,1);

insert into tbl_contato values (1,'cliente_email',1,1,1,null);
insert into tbl_contato values (2,'telefone contato',1,2,1,null);
insert into tbl_contato values (3,'celular contato',1,3,1,null);
insert into tbl_contato values (4,'wsilva187@gmail.com',1,1,null,1);
insert into tbl_contato values (5,'telefone contato',1,2,null,1);
insert into tbl_contato values (6,'celular contato',1,3,null,1);

insert into tbl_cliente_endereco values (1,1);

insert into tbl_cliente_operador values (1,1);
insert into tbl_cliente_operador values (1,2);