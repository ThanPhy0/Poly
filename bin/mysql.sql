show database;

create table `today` (
`id` int auto_increment not null,
`datetime` varchar(30),
`name` varchar(20),
`cp` int(20),
`myan` int(20),
`simee` int(20),
`invest` int(20),
`profit` int(20),
`price` int(20),
primary key(`id`)
);

select * from today;

select * from today where id = 1;


show tables;

select id from today;

drop table today;

DELETE FROM today WHERE id = 7;

alter table today auto_increment=1;


create table `person` (
`id` int not null auto_increment,
`name` varchar(50),
`age` int(3),
primary key (`id`)
);

select * from person;








//after delete a row auto adjust it!

set @autoid :=0;
update today set id = @autoid := (@autoid+1);
alter table today auto_increment = 1;