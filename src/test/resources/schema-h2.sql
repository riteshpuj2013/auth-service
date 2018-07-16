SET MODE MySQL;
DROP TABLE IF EXISTS `medicines`;
CREATE TABLE `medicines` (`id` int(11) NOT NULL AUTO_INCREMENT,`name` varchar(255) NOT NULL,`price` double NOT NULL,`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`id`));
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (`id` int(11) NOT NULL AUTO_INCREMENT,`name` varchar(255) NOT NULL,`age` tinyint(3) NOT NULL,`is_active` tinyint(1) NOT NULL DEFAULT '1',`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`id`));
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (`id` int(11) NOT NULL AUTO_INCREMENT,`patient_id` int(11) NOT NULL,`doctor_id` int(11) NOT NULL,`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`id`));
DROP TABLE IF EXISTS `prescription_medicine_mapping`;
CREATE TABLE `prescription_medicine_mapping` (`id` int(11) NOT NULL AUTO_INCREMENT,`prescription_id` int(11) NOT NULL,`medicine_id` int(11) NOT NULL,`dosage_per_day` tinyint(1) NOT NULL DEFAULT '1',PRIMARY KEY (`id`));
DROP TABLE IF EXISTS `prescription_request`;
CREATE TABLE `prescription_request` (`id` int(11) NOT NULL AUTO_INCREMENT,`requester_id` int(11) NOT NULL,`prescription_id` int(11) NOT NULL,`is_access` tinyint(1) NOT NULL DEFAULT '0',`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`id`));
DROP TABLE IF EXISTS `prescription_requestors`;
CREATE TABLE `prescription_requestors` (`id` int(11) NOT NULL AUTO_INCREMENT,`name` varchar(255) NOT NULL,`type` tinyint(2) NOT NULL,`is_active` tinyint(2) NOT NULL DEFAULT '1',`created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,`updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`id`));
DROP TABLE IF EXISTS `prescription_requestors_type_reference`;
CREATE TABLE `prescription_requestors_type_reference` (`id` tinyint(3) NOT NULL AUTO_INCREMENT,`info` varchar(255) NOT NULL,PRIMARY KEY (`id`));
