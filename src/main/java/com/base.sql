create database avion;
alter database avion owner to postgres;
\c avion postgres;

create table utilisateur(
    iduser serial primary key,
    identifiant varchar(25) not null,
    pwd varchar(100) not null
);

create table avion(
    idavion serial primary key,
    ref varchar(25) not null,
    nom varchar(25) not null,
    photo bytea
);
insert into avion( ref, nom) values
                                 ('AV001','A220-100/300'),
                                 ('AV004','A319'),
                                 ('AV006','A319neo'),
                                 ('AV002','A320-100/200'),
                                 ('AV005','A320neo')


create table entretien(
    identretien serial primary key,
    dates date not null,
    description varchar(50) not null,
    idavion int not null,
    foreign key(idavion) references avion(idavion)
);
insert into entretien (idavion, dates, description) values (1, '2022-09-07','pneu');
insert into entretien (idavion, dates, description) values (2, '2022-09-03','vidange');
insert into entretien (idavion, dates, description) values (3, '2022-04-21','pneu');
insert into entretien (idavion, dates, description) values (4, '2022-08-22','moteur');
insert into entretien (idavion, dates, description) values (5, '2022-12-18','pneu');
insert into entretien (idavion, dates, description) values (1, '2022-10-26','moteur');
insert into entretien (idavion, dates, description) values (1, '2022-05-26','vidange');
insert into entretien (idavion, dates, description) values (2, '2022-11-15','vidange');
insert into entretien (idavion, dates, description) values (5, '2022-04-15','pneu');
insert into entretien (idavion, dates, description) values (4, '2022-04-05','moteur');

create table deplacement(
    iddeplacement serial primary key,
    idavion int not null,
    datedepart timestamp not null,
    debutkm int not null,
    foreign key (idavion) references avion(idavion)
);
insert into deplacement (idavion, datedepart,debutkm) values (2, '2022-05-13 04:54:28',0);
insert into deplacement (idavion, datedepart,debutkm) values (3, '2022-06-14 16:08:45',0);
insert into deplacement (idavion, datedepart,debutkm) values (1, '2022-04-23 05:33:12',0);
insert into deplacement (idavion, datedepart,debutkm) values (4, '2022-03-22 15:34:30',0);
insert into deplacement (idavion, datedepart,debutkm) values (2, '2022-07-17 00:20:17',1000);
insert into deplacement (idavion, datedepart,debutkm) values (3, '2022-11-12 18:59:47',500);
insert into deplacement (idavion, datedepart,debutkm) values (5, '2022-11-14 18:40:27',0);
insert into deplacement (idavion, datedepart,debutkm) values (5, '2022-11-30 21:25:01',500);
insert into deplacement (idavion, datedepart,debutkm) values (4, '2022-11-12 17:59:57',500);
insert into deplacement (idavion, datedepart,debutkm) values (1, '2022-10-12 02:24:01',600);

create table kilometrage(
    idkilometrage serial primary key,
    iddeplacement int not null,
    datearrive timestamp not null,
    finkm int not null,
    foreign key (idDeplacement) references deplacement(idDeplacement)
);
insert into kilometrage (finkm,datearrive, iddeplacement) values (700, '2022-10-13 02:24:01', 10);
insert into kilometrage (finkm,datearrive, iddeplacement) values (1000,'2022-05-14 04:54:28', 1);
insert into kilometrage (finkm,datearrive, iddeplacement) values (500, '2022-06-15 16:08:45', 2);
insert into kilometrage (finkm,datearrive, iddeplacement) values (1500,'2022-11-16 17:59:57', 9);
insert into kilometrage (finkm,datearrive, iddeplacement) values (1500, '2022-12-01 21:25:01', 8);
insert into kilometrage (finkm,datearrive, iddeplacement) values (600,'2022-04-24 05:33:12', 3);
insert into kilometrage (finkm,datearrive, iddeplacement) values (500,'2022-03-23 15:34:30', 4);
insert into kilometrage (finkm,datearrive, iddeplacement) values (500,'2022-11-15 18:40:27', 7);
insert into kilometrage (finkm,datearrive, iddeplacement) values (2000,'2022-07-18 00:20:17', 5);
insert into kilometrage (finkm,datearrive, iddeplacement) values (700, '2022-11-13 18:59:47', 6);


create table token(
    iduser int not null,
    token varchar(100) primary key,
    datecreation timestamp not null,
    duree double precision not null,
    foreign key (iduser) references utilisateur(iduser)
);

create table expiration(
    token varchar(100) not null,
    dateexpiration timestamp not null,
    foreign key (token) references token(token)
);

create table assurance(
    idassurance serial primary key,
    idavion int not null,
    datedebut date not null,
    duree int not null,
    foreign key (idavion) references avion(idavion)
);
insert into assurance (idavion,duree,datedebut) values (1,8,'2022-12-16 15:41:52');
insert into assurance (idavion,duree,datedebut) values (2,3,'2022-03-28 09:53:14');
insert into assurance (idavion,duree,datedebut) values (3,6,'2022-12-07 13:49:53');
insert into assurance (idavion,duree,datedebut) values (4,10,'2022-07-28 21:42:50');
insert into assurance (idavion,duree,datedebut) values (5,7,'2022-04-01 16:37:46');

insert into utilisateur(identifiant,pwd) values ('Rakoto','rakoto');
insert into utilisateur(identifiant,pwd) values ('admin','admin');

create or replace view detailavionkilometrage as
select idkilometrage,avion.*,datedepart,debutkm,datearrive,finkm
from avion,kilometrage,deplacement where avion.idavion=deplacement.idavion and deplacement.iddeplacement=kilometrage.iddeplacement;

create or replace view detailavionentretien as
select identretien,avion.*,dates,description
from avion,entretien where avion.idavion=entretien.idavion;

create or replace view v_assurance as
select idassurance,avion.*,assurance.datedebut,assurance.duree from avion,assurance where avion.idavion=assurance.idavion;

Create or replace function expire(datedebut date,duree int)
returns int
language plpgsql
as
$$
declare val int;
declare moispasse int;
declare s varchar;
Begin
select (current_date - datedebut)/30 into moispasse;
select duree - moispasse into val ;
return val;
End;
$$;

Create or replace function fin(datedebut date,duree int)
returns date
language plpgsql
as
$$
declare val date;
declare inter interval;
Begin
select concat(duree, ' months') into inter;
select (datedebut + inter ) into val;
return val;
End;
$$;


create or replace view ass as
select idavion,max(datedebut) datedebut from v_assurance group by idavion ;

create or replace view expireAssurance as
select v_assurance.*,expire(ass.datedebut,duree),fin(ass.datedebut,duree) from v_assurance,ass where ass.idavion=v_assurance.idavion and ass.datedebut=v_assurance.datedebut ;


select * from detailavionkilometrage