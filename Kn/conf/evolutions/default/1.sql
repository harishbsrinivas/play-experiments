# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  id                        bigint not null,
  title                     varchar(255),
  author                    varchar(255),
  created_date              varchar(255),
  modified_date             varchar(255),
  body                      varchar(255),
  view_count                integer,
  fav_count                 integer,
  rating                    integer,
  constraint pk_article primary key (id))
;

create sequence article_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists article_seq;

