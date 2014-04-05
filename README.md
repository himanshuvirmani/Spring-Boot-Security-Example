Spring-Boot-Security-Example
============================    

This project is a combination of spring boot rest web services, spring-security and spring boot jar to war implementations using Java Springs, Hibernate and MySQL. I decided to add this to public github because it took me some effort to get things running as there are limited examples of Spring Boot available. Also while since most examples on internet as of today use standard xml configurations for servlet mapping, hibernate configurations etc., it was difficult to map those in Spring Boot as it used annotations for basically everything. 

This project can serve as a template or starting point as it contains both of a simple webservice and spring mvc. Find below some projects that I referenced while creating this template example. 

- https://spring.io/guides/gs/rest-service/

- https://spring.io/guides/gs/convert-jar-to-war/

- https://github.com/Fruzenshtein/security-spr

---

# Other Dependencies (Apart from code here)



##Creating tables in mysql  

  
#### Create a basic table to try simple add user request using Spring Boot, Hibernate and MySQl.

    mysql> CREATE TABLE `USER_DETAILS` (
      `id` int(6) NOT NULL AUTO_INCREMENT,
      `uuid` varchar(40) NOT NULL,
      `email` varchar(40) NOT NULL,
      PRIMARY KEY (`id`)
    );
    
---

#### Create below tables to try spring security using Admin roles and Admin users.

    mysql> CREATE TABLE `ADMIN_ROLES` (
      `id` int(6) NOT NULL AUTO_INCREMENT,
      `role` varchar(20) NOT NULL,
      PRIMARY KEY (`id`)
    );

    mysql> CREATE TABLE `ADMIN_USERS` (
      `id` int(6) NOT NULL AUTO_INCREMENT,
      `login` varchar(20) NOT NULL,
      `password` varchar(20) NOT NULL,
      PRIMARY KEY (`id`)
    ); 

    //This table is used to join/map ADMIN _USERS and ADMIN_ROLES 
    mysql> CREATE TABLE `USER_ROLES` (
      `user_id` int(6) NOT NULL,
      `role_id` int(6) NOT NULL,
      KEY `user` (`user_id`),
      KEY `role` (`role_id`)
    );

    mysql> INSERT INTO ADMIN_ROLES (role) VALUES ('ADMIN'), ('MODERATOR');
    
    mysql> INSERT INTO ADMIN_USERS (login, password) VALUES ('mod', 'mod123'), ('admin', 'admin123');
    
    mysql> INSERT INTO USER_ROLES (user_id, role_id) VALUES (1, 2), (2, 1);
