create table sec_user(
  username varchar(100) primary key,
  password varchar(255)
);
create table sec_role(
  rolename varchar(100) primary key,
  prompt varchar(255)
);
create table sec_role_user(
  username varchar(100) not null,
  rolename varchar(100) not null,
  constraint ru_id primary key(username,rolename)
);
alter table sec_role_user add constraint fk_user foreign key(username) references sec_user(username);
alter table sec_role_user add constraint fk_role foreign key(rolename) references sec_role(rolename);  