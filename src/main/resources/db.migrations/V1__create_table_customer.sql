create table customer
(
	id int auto_increment primary key,
    name varchar(255) not null,
	email varchar(255) not null unique
);

INSERT INTO customer (name, email)
VALUES
    ('Elif Sahin', 'elif.sahin@teste.com'),
    ('Bru Luccas', 'bruluccas30@teste.com'),
    ('Monica Mattos', 'monicamattos@teste.com'),
    ('Gina Valentina', 'gina.valentina@teste.com'),
    ('Violet Mayers', 'violetmayers@teste.com'),
    ('Aline Rios', 'aline.rios@teste.com'),
    ('Alina Cherepanova', 'alichkalina@teste.com'),
    ('Mia Kitkat', 'miiakitkat@teste.com'),
    ('Karoline Marquesa', 'karolinemarquesa_@teste.com'),
    ('Sierra Rain', 'sierraxraiin@teste.com');