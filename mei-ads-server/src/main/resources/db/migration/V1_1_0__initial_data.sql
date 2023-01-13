
CREATE TABLE IF NOT EXISTS classrooms (
    id varchar(255) not null,
    capacity integer not null,
    name varchar(255),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS courses (
    id varchar(255) not null,
    capacity integer not null,
    capacity_used integer not null,
    location varchar(255),
    name varchar(255),
    shift integer,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS course_curricular_units (
    course_id varchar(255) not null,
    curricular_units varchar(255)
);


CREATE TABLE IF NOT EXISTS curricular_units (
    id varchar(255) not null,
    name varchar(255),
    primary key (id)
);

insert into courses values ( '68835901-12e2-46df-bd41-b4f1f0536f69', 50, 25, 'Edificio 2', 'MEI', 0 );
insert into courses values ( 'cd4c4961-8b69-4b42-bbab-a8106522360e', 50, 40, 'Edificio 2', 'Administração Pública', 0 );
insert into courses values ( '592c2a09-137a-4565-bc0f-0e151f3d3733', 50, 18, 'Edificio 2', 'BI', 0 );
insert into courses values ( 'ebaff3de-6fe6-4dc9-b8cf-a584faf6a916', 50, 10, 'Edificio 2', 'Arquitetura', 0 );


insert into  curricular_units values ( '492066f1-4cc0-4b62-8e99-def335dcfcb8', 'ADS' );
insert into  curricular_units values ( '10fbbb5c-044e-4ace-bb53-c11dc3f57ad3', 'EUVI' );
insert into  curricular_units values ( '90fe09c0-aab6-4b32-bf52-a74533c58582', 'CYBER' );
insert into  curricular_units values ( 'e3916260-5321-4208-85b5-f09f0541d49b', 'IAA' );

insert into course_curricular_units values ( '68835901-12e2-46df-bd41-b4f1f0536f69', '492066f1-4cc0-4b62-8e99-def335dcfcb8' );
insert into course_curricular_units values ( '68835901-12e2-46df-bd41-b4f1f0536f69', '10fbbb5c-044e-4ace-bb53-c11dc3f57ad3' );
insert into course_curricular_units values ( '68835901-12e2-46df-bd41-b4f1f0536f69', '90fe09c0-aab6-4b32-bf52-a74533c58582' );
insert into course_curricular_units values ( '68835901-12e2-46df-bd41-b4f1f0536f69', 'e3916260-5321-4208-85b5-f09f0541d49b' );

insert into classrooms values ('0f7f4ddf-e719-4d5c-99cd-05c0e95e62e1', 60, 'Sala 01');
insert into classrooms values ('b4c60fd0-3b3d-4796-a28d-ab46854091c8', 60, 'Sala 02');
insert into classrooms values ('19db7570-741c-4b5e-9921-57e86dc18a1b', 60, 'Sala 03');
insert into classrooms values ('19ce6008-22ba-4994-83c2-46c6a0fd7c54', 60, 'Sala04');