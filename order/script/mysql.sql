#DROP DATABASE IF EXISTS product;
#DROP USER productuser;
#DROP USER prodinstuser;

CREATE DATABASE product CHARACTER SET utf8 COLLATE utf8_bin;
CREATE USER 'productuser'@'%' IDENTIFIED BY 'productpwd';
GRANT SELECT, INSERT, UPDATE, DELETE ON product.* TO 'productuser'@'%';
CREATE USER 'prodinstuser'@'%' IDENTIFIED BY 'productpwd';
GRANT SELECT, INSERT, UPDATE, DELETE, ALTER, CREATE, index, references ON product.* TO 'prodinstuser'@'%';
FLUSH PRIVILEGES;

