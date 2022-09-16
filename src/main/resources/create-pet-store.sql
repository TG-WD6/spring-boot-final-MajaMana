DROP DATABASE IF EXISTS `pet_store`;
CREATE DATABASE `pet_store`;
USE `pet_store`;

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `customers` VALUES (1,'Jens','jens@test.nl','testpass');
INSERT INTO `customers` VALUES (2,'Casper','casper@test.nl','testpass');

CREATE TABLE `pet_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `pet_types` VALUES (1, 'Cat');
INSERT INTO `pet_types` VALUES (2, 'Dog');

CREATE TABLE `pets` (
  `pet_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `birth_date` date,
  `type_id` int(11) DEFAULT 1 NOT NULL,
  `owner_id` int(11) DEFAULT 1 NOT NULL,
  PRIMARY KEY (`pet_id`),
  FOREIGN KEY (owner_id) references customers(customer_id),
  FOREIGN KEY (type_id) references pet_types(id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `pets` VALUES (1, 'Penny', null, 1, 1);
INSERT INTO `pets` VALUES (2, 'Five', null, 2, 1);
INSERT INTO `pets` VALUES (3, 'Bobby', null, 1, 1);
INSERT INTO `pets` VALUES (4, 'Neeltje', null, 1, 1);
INSERT INTO `pets` VALUES (5, 'Penny', null, 1, 1);
INSERT INTO `pets` VALUES (6, 'Floris', null, 1, 2);

