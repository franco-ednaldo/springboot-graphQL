create table cliente (
                         id    serial primary key,
                         email varchar(255) null,
                         nome  varchar(255) null
);

create table produto(
                        id    serial primary key,
                        nome  varchar(255) null,
                        valor numeric(19,2)       not null
);

create table compra
(
    id         serial primary key,
    data       date     null,
    quantidade int          null,
    status     varchar(255) null,
    cliente_id bigint       null,
    produto_id bigint       null,
    constraint FK_COMPRA_PRODUTO foreign key (produto_id) references produto (id),
    constraint FK_COMPRA_CLIENTE foreign key (cliente_id) references cliente (id)
);

