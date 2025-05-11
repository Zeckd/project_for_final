insert into train_types(id,name) values (1,'Скоростной');
insert into train_types(id,name) values (2,'Скорый');
insert into train_types(id, name) values (3,'Пассажирский');

insert into trains(id, train_number, train_type_id) values (1, 123, 1);
insert into trains(id, train_number, train_type_id) values (2, 123123, 3);
insert into trains(id, train_number, train_type_id) values (3, 21123, 2);
insert into trains(id, train_number, train_type_id) values (4, 13323, 1);




insert into carriage_types(id, name, extra_price) values (1,'Общий', 0);
insert into carriage_types(id,name, extra_price) values (2,'Плацкартный', 500);
insert into carriage_types(id,name, extra_price) values (3,'Купе', 1000);
insert into carriage_types(id,name, extra_price) values (4,'Спальный', 1500);


insert into carriages(id, carriage_number, carriage_type_id, train_id) values (1, 321, 1, 1);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (2, 323551, 4, 1);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (3, 3421, 3, 1);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (4, 34321, 2, 1);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (5, 3261, 1, 2);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (6, 35251, 4, 2);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (7, 16421, 3, 2);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (8, 44321, 2, 2);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (9, 349921, 1, 3);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (10, 23551, 4, 3);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (11, 34421, 3, 3);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (12, 384321, 2, 3);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (13, 34521, 1, 4);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (14, 32312551, 4, 4);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (15, 341121, 3, 4);
insert into carriages(id, carriage_number, carriage_type_id, train_id) values (16, 32214321, 2, 4);


insert into localities(id, name) values (1, 'Bishkek');
insert into localities(id, name) values (2, 'Moscow');
insert into localities(id, name) values (3, 'Cholpon-Ata');
insert into localities(id, name) values (4, 'Almaty');



