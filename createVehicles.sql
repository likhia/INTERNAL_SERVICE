DEV :  admin / redhat
SIT :  admin / password

DB Name : mysql
Schema : cars

CREATE TABLE  vehicles (    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
                            carplate varchar(255) NOT NULL, 
                            model varchar(255) NULL, 
                            color varchar(255) NULL,  
                            enginecap varchar(255) NULL, 
                            createdyr varchar(255) NULL,
                            used varchar(255) NULL, 
                            type varchar(255) NULL,
                            user varchar(255) NULL);
