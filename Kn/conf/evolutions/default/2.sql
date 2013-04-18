
# --- !Ups


ALTER TABLE article ALTER COLUMN body CLOB;
ALTER TABLE article ALTER COLUMN created_date DATE;
ALTER TABLE article ALTER COLUMN modified_date DATE;

# --- !Downs

ALTER TABLE article ALTER COLUMN body varchar(255);
ALTER TABLE article ALTER COLUMN created_date varchar(255);
ALTER TABLE article ALTER COLUMN modified_date varchar(255);