SET MODE MySQL;

INSERT INTO `medicines` VALUES (1,'Crocin',2,'2018-07-16 07:20:53','2018-07-16 07:20:53'),(2,'Pan40',2,'2018-07-16 07:39:48','2018-07-16 07:39:48');
INSERT INTO `patient` VALUES (1,'Ritesh',27,1,'2018-07-16 07:11:23','2018-07-16 07:11:23');
INSERT INTO `prescription` VALUES (1,1,1,'2018-07-16 07:09:22','2018-07-16 07:09:22');
INSERT INTO `prescription_medicine_mapping` VALUES (1,1,1,1),(2,1,2,2);
INSERT INTO `prescription_requestors` VALUES (1,'Tarla Shah',1,1,'2018-07-16 07:23:56','2018-07-16 07:23:56');
INSERT INTO `prescription_requestors_type_reference` VALUES (1,'Docter'),(2,'Pharmacist');
