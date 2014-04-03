Spring-Boot-Security-Example
============================    

---

##Creating tables in mysql  

---  
    
#### Create a basic table to try simple add user request using Spring Boot, Hibernate and MySQl

    CREATE TABLE `USER_DETAILS` (
      `id` int(6) NOT NULL AUTO_INCREMENT,
      `uuid` varchar(40) NOT NULL,
      `email` varchar(40) NOT NULL,
      PRIMARY KEY (`id`)
    );
    
---

#### Create a tables to try spring security using Admin roles and Admin users

    CREATE TABLE `ADMIN_ROLES` (
      `id` int(6) NOT NULL AUTO_INCREMENT,
      `role` varchar(20) NOT NULL,
      PRIMARY KEY (`id`)
    );

    CREATE TABLE `ADMIN_USERS` (
      `id` int(6) NOT NULL AUTO_INCREMENT,
      `login` varchar(20) NOT NULL,
      `password` varchar(20) NOT NULL,
      PRIMARY KEY (`id`)
    ); 

    //This table is used to join/map ADMIN _USERS and ADMIN_ROLES 
    CREATE TABLE `USER_ROLES` (
      `user_id` int(6) NOT NULL,
      `role_id` int(6) NOT NULL,
      KEY `user` (`user_id`),
      KEY `role` (`role_id`)
    );
