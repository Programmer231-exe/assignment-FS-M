CREATE DATABASE `online_transaction` 


USE online_transaction;


CREATE TABLE `people` (
  `people_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` char(25) NOT NULL,
  `middle_name` char(25) DEFAULT NULL,
  `last_name` char(25) NOT NULL,
  `dob` date NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `phone_num` char(15) NOT NULL,
  PRIMARY KEY (`people_id`),
  UNIQUE KEY `email_id` (`email_id`),
  UNIQUE KEY `phone_num` (`phone_num`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1

CREATE TABLE `address` (
  `people_address_id` int(11) NOT NULL AUTO_INCREMENT,
  `door_no` char(10) NOT NULL,
  `street_name` varchar(255) NOT NULL,
  `city` varchar(100) NOT NULL,
  `district` varchar(199) NOT NULL,
  `state` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `pincode` char(10) NOT NULL,
  PRIMARY KEY (`people_address_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`people_address_id`) REFERENCES `people` (`people_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1


CREATE TABLE `bank_details` (
  `bank_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(255) NOT NULL,
  `branch_name` varchar(255) NOT NULL,
  `branch_location` varchar(255) NOT NULL,
  `district` varchar(199) NOT NULL,
  `state` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `pincode` char(10) NOT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1


CREATE TABLE `bank_users_details` (
  `bank_id` int(11) NOT NULL,
  `bank_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_account_number` bigint(20) NOT NULL,
  `bank_people_id` int(11) NOT NULL,
  `bank_debit_card` bigint(20) NOT NULL,
  `account_balance` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`bank_user_id`),
  UNIQUE KEY `bank_account_number` (`bank_account_number`),
  UNIQUE KEY `bank_debit_card` (`bank_debit_card`),
  KEY `bank_people_id` (`bank_people_id`),
  CONSTRAINT `bank_users_details_ibfk_1` FOREIGN KEY (`bank_people_id`) REFERENCES `people` (`people_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1


CREATE TABLE `online_banker` (
  `online_banker_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `account_id` int(11) NOT NULL,
  PRIMARY KEY (`online_banker_id`),
  UNIQUE KEY `user_name` (`user_name`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `online_banker_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `bank_users_details` (`bank_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1


CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user` varchar(100) NOT NULL,
  `to_user` varchar(100) NOT NULL,
  `amount` double NOT NULL,
  `status` char(20) NOT NULL DEFAULT 'SUCCESSFUL',
  `time_of_transaction` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `from_user` (`from_user`),
  KEY `to_user` (`to_user`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`from_user`) REFERENCES `online_banker` (`user_name`),
  CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`to_user`) REFERENCES `online_banker` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=369 DEFAULT CHARSET=latin1

