# Pharm Proj

##Create database
Execute in terminal:
####sudo docker run --name=mysqltest --env="MYSQL_ROOT_PASSWORD=root" -p 3306:3306 -d mysql:5.5
then open mysqlWorkbench and connect to localhost:3306, user: root, password: root or in terminal execute:
####mysql -u root -p
type 'root'
and execute below script:

DROP DATABASE IF EXISTS Pharm;
CREATE DATABASE Pharm CHAR
SET utf8 COLLATE utf8_general_ci;



##Swagger
Url for swagger: localhost:8080/swagger-ui.html
