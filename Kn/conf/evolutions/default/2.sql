
# --- !Ups


ALTER TABLE article ALTER COLUMN body CLOB;

# --- !Downs

ALTER TABLE article ALTER COLUMN body varchar(255);
