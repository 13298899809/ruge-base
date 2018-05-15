create database db_mybatis;

-- auto-generated definition
create table tbl_employee
(
  id        int          not null
  comment '主鍵'
    primary key,
  lase_name varchar(255) null,
  gender    char         null,
  email     varchar(255) null
);



