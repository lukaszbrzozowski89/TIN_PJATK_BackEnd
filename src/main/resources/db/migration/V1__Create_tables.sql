create table user
(
    id         int unsigned PRIMARY KEY auto_increment,
    first_name varchar(20) not null,
    last_name  varchar(20) not null,
    password   varchar(20) not null,
    is_admin   bool
);

create table flight
(
    id            int unsigned PRIMARY KEY auto_increment,
    flight_number varchar(5) not null,
    airport_from  varchar(3) not null,
    airport_to    varchar(3) not null
);

create table reservation
(
    id        int unsigned PRIMARY KEY auto_increment,
    flight_id int not null,
    user_id   int not null
);

insert into user(first_name, last_name, password, is_admin)
values ('Jan', 'Kowalski', 'pass', true);
insert into user(first_name, last_name, password, is_admin)
values ('Roman', 'Nowak', 'pass', false);
insert into user(first_name, last_name, password, is_admin)
values ('Kazimierz', 'Legenda', 'pass', false);
insert into user(first_name, last_name, password, is_admin)
values ('Piotr', 'Romanowski', 'pass', false);
insert into user(first_name, last_name, password, is_admin)
values ('Kamil', 'Robak', 'pass', false);
insert into user(first_name, last_name, password, is_admin)
values ('Matuesz', 'Swiatek', 'pass', false);
insert into user(first_name, last_name, password, is_admin)
values ('Jan', '4', 'pass', false);

insert into flight(flight_number, airport_from, airport_to)
values ('FL331', 'WAW', 'CDG');
insert into flight(flight_number, airport_from, airport_to)
values ('FL332', 'CDG', 'WAW');
insert into flight(flight_number, airport_from, airport_to)
values ('FL333', 'WAW', 'CDG');
insert into flight(flight_number, airport_from, airport_to)
values ('FL334', 'CDG', 'WAW');
insert into flight(flight_number, airport_from, airport_to)
values ('FL335', 'WAW', 'CDG');
insert into flight(flight_number, airport_from, airport_to)
values ('FL336', 'CDG', 'WAW');
insert into flight(flight_number, airport_from, airport_to)
values ('FL003', 'WAW', 'ORD');
insert into flight(flight_number, airport_from, airport_to)
values ('FL004', 'ORD', 'WAW');
insert into flight(flight_number, airport_from, airport_to)
values ('FL006', 'WAW', 'JFK');
insert into flight(flight_number, airport_from, airport_to)
values ('FL007', 'JFK', 'WAW');
insert into flight(flight_number, airport_from, airport_to)
values ('FL287', 'WAW', 'LCY');
insert into flight(flight_number, airport_from, airport_to)
values ('FL288', 'LCY', 'WAW');
insert into flight(flight_number, airport_from, airport_to)
values ('FL289', 'WAW', 'LCY');
insert into flight(flight_number, airport_from, airport_to)
values ('FL290', 'LCY', 'WAW');


insert into reservation(flight_id, user_id)
VALUES (1, 5);
insert into reservation(flight_id, user_id)
VALUES (1, 2);
insert into reservation(flight_id, user_id)
VALUES (1, 3);
insert into reservation(flight_id, user_id)
VALUES (2, 5);
insert into reservation(flight_id, user_id)
VALUES (2, 2);
insert into reservation(flight_id, user_id)
VALUES (2, 3);
insert into reservation(flight_id, user_id)
VALUES (3, 3);
insert into reservation(flight_id, user_id)
VALUES (4, 3);
insert into reservation(flight_id, user_id)
VALUES (5, 2);
insert into reservation(flight_id, user_id)
VALUES (5, 3);
insert into reservation(flight_id, user_id)
VALUES (4, 2);
insert into reservation(flight_id, user_id)
VALUES (6, 3);
insert into reservation(flight_id, user_id)
VALUES (6, 3);
insert into reservation(flight_id, user_id)
VALUES (7, 4);
insert into reservation(flight_id, user_id)
VALUES (5, 5);