-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.17-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for rms
CREATE DATABASE IF NOT EXISTS `rms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rms`;

-- Dumping structure for table rms.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` longtext,
  `city` varchar(255) DEFAULT NULL,
  `date_added` datetime NOT NULL,
  `division` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `emp_status` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(60) NOT NULL,
  `gender` int(11) NOT NULL,
  `hired_date` date NOT NULL,
  `job_family` varchar(255) NOT NULL,
  `last_modified` datetime NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `marital_status` int(11) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `street_address` varchar(255) DEFAULT NULL,
  `sub_division` varchar(255) DEFAULT NULL,
  `suspend_date` date DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `UK_fopic1oh5oln2khj8eat6ino0` (`email`),
  UNIQUE KEY `UK_buf2qp04xpwfp5qq355706h4a` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.family_members
CREATE TABLE IF NOT EXISTS `family_members` (
  `fam_id` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `gender` int(11) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `relation` int(11) NOT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`fam_id`),
  KEY `FKf3pvaaf4sim9wote1sblqxndy` (`emp_id`),
  CONSTRAINT `FKf3pvaaf4sim9wote1sblqxndy` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.grades
CREATE TABLE IF NOT EXISTS `grades` (
  `grade_id` varchar(255) NOT NULL,
  `ds` int(11) NOT NULL,
  `end_date` date DEFAULT NULL,
  `grade` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`grade_id`),
  KEY `FKkyi4cr0awkplpj85je0hs3gkl` (`emp_id`),
  CONSTRAINT `FKkyi4cr0awkplpj85je0hs3gkl` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.office_locations
CREATE TABLE IF NOT EXISTS `office_locations` (
  `loc_id` varchar(255) NOT NULL,
  `end_date` date DEFAULT NULL,
  `office_location` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`loc_id`),
  KEY `FKkkk2sgdocfmfn90xqpkyp9bdc` (`emp_id`),
  CONSTRAINT `FKkkk2sgdocfmfn90xqpkyp9bdc` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.projects
CREATE TABLE IF NOT EXISTS `projects` (
  `project_id` varchar(255) NOT NULL,
  `end_date` date DEFAULT NULL,
  `job_desc` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `start_date` date NOT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FK1vb52nfqopectvb1rwsq0x95j` (`emp_id`),
  CONSTRAINT `FK1vb52nfqopectvb1rwsq0x95j` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.ref_division
CREATE TABLE IF NOT EXISTS `ref_division` (
  `div_code` varchar(255) NOT NULL,
  `division` varchar(255) NOT NULL,
  `job_family` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`div_code`),
  KEY `FKholx18apjdr9oj73047ueiemv` (`job_family`),
  CONSTRAINT `FKholx18apjdr9oj73047ueiemv` FOREIGN KEY (`job_family`) REFERENCES `ref_job_family` (`jf_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.ref_jf_level
CREATE TABLE IF NOT EXISTS `ref_jf_level` (
  `level_id` varchar(255) NOT NULL,
  `grade` varchar(255) NOT NULL,
  `max_ds` int(11) NOT NULL,
  `min_ds` int(11) NOT NULL,
  `job_family` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`level_id`),
  KEY `FKpdcfm6nffd0j3gekjr8bi8gdy` (`job_family`),
  CONSTRAINT `FKpdcfm6nffd0j3gekjr8bi8gdy` FOREIGN KEY (`job_family`) REFERENCES `ref_job_family` (`jf_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.ref_job_family
CREATE TABLE IF NOT EXISTS `ref_job_family` (
  `jf_code` varchar(255) NOT NULL,
  `job_family` varchar(255) NOT NULL,
  `max_ds` int(11) NOT NULL,
  `min_ds` int(11) NOT NULL,
  PRIMARY KEY (`jf_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.ref_office_address
CREATE TABLE IF NOT EXISTS `ref_office_address` (
  `address_id` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `post_code` varchar(255) NOT NULL,
  `province` varchar(255) NOT NULL,
  `street_address` varchar(255) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table rms.ref_subdivision
CREATE TABLE IF NOT EXISTS `ref_subdivision` (
  `sub_div_code` varchar(255) NOT NULL,
  `sub_division` varchar(255) NOT NULL,
  `division` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sub_div_code`),
  KEY `FK6stbygfapbcgp78otv2qwpke3` (`division`),
  CONSTRAINT `FK6stbygfapbcgp78otv2qwpke3` FOREIGN KEY (`division`) REFERENCES `ref_division` (`div_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


insert into ref_job_family values ('SE', 'Software Engineer', 22, 1);
insert into ref_job_family values ('ADM', 'Administration', 22, 1);
insert into ref_job_family values ('CON', 'Consultant', 22, 1);
insert into ref_job_family values ('FA', 'Finance and accounting', 22, 1);
insert into ref_job_family values ('DSG', 'Designer', 22, 1);
insert into ref_job_family values ('IT', 'IT', 22, 1);
insert into ref_job_family values ('MJF', 'Management', 22, 1);
insert into ref_job_family values ('TR', 'Trainer', 22, 1);
insert into ref_job_family values ('SQ', 'Software Quality', 22, 1);

insert into ref_division values ('CDC', 'CDC', 'SE');
insert into ref_division values ('SWDG', 'SWD Green', 'SE');
insert into ref_division values ('SWDB', 'SWD Blue', 'SE');
insert into ref_division values ('SWDR', 'SWD Red', 'SE');
insert into ref_division values ('TRD', 'Training and Development', 'TR');

insert into ref_subdivision values ('CDC-JAVA', 'Java Bootcamp', 'CDC');
insert into ref_subdivision values ('CDC-PHP', 'PHP Bootcamp', 'CDC');
insert into ref_subdivision values ('BC-1', 'Business Communication 1', 'TRD');
insert into ref_subdivision values ('BC-2', 'Business Communication 2', 'TRD');

insert into ref_jf_level values ('SE-JP', 'SE-JP', 3, 1, 'SE');
insert into ref_jf_level values ('SE-PG', 'SE-PG', 7, 4, 'SE');
insert into ref_jf_level values ('SE-AP', 'SE-AP', 13, 8, 'SE');
insert into ref_jf_level values ('SE-AN', 'SE-AN', 22, 14, 'SE');
insert into ref_jf_level values ('TR-1', 'TR-1', 3, 1, 'TR');
insert into ref_jf_level values ('TR-2', 'TR-2', 7, 4, 'TR');
insert into ref_jf_level values ('TR-3', 'TR-3', 13, 8, 'TR');
insert into ref_jf_level values ('TR-4', 'TR-4', 22, 14, 'TR');
insert into ref_jf_level values ('FA-1', 'FA-1', 3, 1, 'FA');
insert into ref_jf_level values ('FA-2', 'FA-2', 7, 4, 'FA');
insert into ref_jf_level values ('FA-3', 'FA-3', 13, 8, 'FA');
insert into ref_jf_level values ('FA-4', 'FA-4', 22, 14, 'FA');

INSERT INTO ref_office_address VALUES ('Bandung', 'Bandung', '40164', 'Jawa Barat', 'Jl Surya Sumantri no 8D');
INSERT INTO ref_office_address VALUES ('Yogyakarta', 'Umbulharjo', '55165', 'Yogyakarta', 'Jln Sidobali No 2, Muja Muju');
INSERT INTO ref_office_address VALUES ('Bali-Suwung', 'Suwung', '80223', 'Bali', 'Jln Bypass Ngurah Rai gg. Mina Utama No. 1');


drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);

drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(255)
);

drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);

drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(255), authentication LONG VARBINARY
);

drop table if exists oauth_approvals;
create table oauth_approvals (
    userId VARCHAR(255),
    clientId VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

drop table if exists client_details;
create table client_details (
  appId VARCHAR(255) PRIMARY KEY,
  resourceIds VARCHAR(255),
  appSecret VARCHAR(255),
  scope VARCHAR(255),
  grantTypes VARCHAR(255),
  redirectUrl VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(255)
);

INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `access_token_validity`) values
    ('client1', 'rms-resource', 'secret', 'READ_EMPLOYEES', 'password', 3600),
    ('client2', 'rms-resource', 'secret', 'READ_EMPLOYEE', 'password', 3600),
    ('client3', 'rms-resource', 'secret', 'CREATE_EMPLOYEE', 'password', 3600),
    ('client4', 'rms-resource', 'secret', 'READ_EMPLOYEE,READ_EMPLOYEES,CREATE_EMPLOYEE', 'password', 3600);