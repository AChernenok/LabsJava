use myjdbc;

INSERT INTO myjdbc.cast(name, birthdate) VALUES
('Krepus James Jones', '16.04.1983'),
('Banderos Antonio Antonio', '24.08.1964'),
('Milos Ricardo Antonio', '01.01.1991'),
('Petrov Petr Olegovich', '23.03.1989'),
('Baskov Leonid James', '02.03.2003');

INSERT INTO myjdbc.films(filmname, castid, releasedate, country, role) VALUES
('Mstiteli', 1, '2005', 'USA', 'actor'),
('Mstiteli', 2, '2005', 'USA', 'producer'),
('Piraty', 2, '2014', 'USA', 'producer'),
('Piraty', 3, '2014', 'USA', 'actor'),
('Blesk', 3, '2017', 'USA', 'actor'),
('Blesk', 4, '2017', 'USA', 'producer'),
('Transfer', 4, '2019', 'USA', 'producer'),
('Agent', 5, '2020', 'USA', 'actor');

