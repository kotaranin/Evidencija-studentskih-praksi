/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 8.0.40 : Database - evidencija_studentskih_praksi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`evidencija_studentskih_praksi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `evidencija_studentskih_praksi`;

/*Table structure for table `dnevnik` */

DROP TABLE IF EXISTS `dnevnik`;

CREATE TABLE `dnevnik` (
  `id_dnevnik` bigint unsigned NOT NULL AUTO_INCREMENT,
  `ukupno_trajanje` int NOT NULL,
  `misljenje_kompanije` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ocena` int NOT NULL,
  `datum_izdavanja` date NOT NULL,
  `id_zaposleni` bigint unsigned NOT NULL,
  `id_student` bigint unsigned NOT NULL,
  PRIMARY KEY (`id_dnevnik`),
  KEY `idZaposleni` (`id_zaposleni`),
  KEY `idStudent` (`id_student`),
  CONSTRAINT `dnevnik_ibfk_1` FOREIGN KEY (`id_zaposleni`) REFERENCES `zaposleni` (`id_zaposleni`),
  CONSTRAINT `dnevnik_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `dnevnik` */

insert  into `dnevnik`(`id_dnevnik`,`ukupno_trajanje`,`misljenje_kompanije`,`ocena`,`datum_izdavanja`,`id_zaposleni`,`id_student`) values 
(1,0,'Odličan rad i posvećenost',0,'2024-06-20',1,1),
(2,0,'Vrlo dobro, ali potrebno više prakse',0,'2024-06-18',2,2),
(3,140,'Izuzetan doprinos timu',0,'2024-06-22',3,3);

/*Table structure for table `fakultet` */

DROP TABLE IF EXISTS `fakultet`;

CREATE TABLE `fakultet` (
  `id_fakultet` bigint unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  `adresa` varchar(255) NOT NULL,
  PRIMARY KEY (`id_fakultet`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `fakultet` */

insert  into `fakultet`(`id_fakultet`,`naziv`,`adresa`) values 
(1,'Fakultet tehničkih nauka','Trg Dositeja Obradovića 6, Novi Sad'),
(2,'Fakultet organizacionih nauka','Jove Ilića 154, Beograd'),
(3,'Prirodno-matematički fakultet','Dositejeva 9, Novi Sad');

/*Table structure for table `projekat` */

DROP TABLE IF EXISTS `projekat`;

CREATE TABLE `projekat` (
  `id_projekat` bigint unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  `opis` varchar(500) NOT NULL,
  `datum_pocetka` date NOT NULL,
  `datum_zavrsetka` date DEFAULT NULL,
  PRIMARY KEY (`id_projekat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `projekat` */

insert  into `projekat`(`id_projekat`,`naziv`,`opis`,`datum_pocetka`,`datum_zavrsetka`) values 
(1,'Razvoj softvera za evidenciju praksi','Sistem za praćenje studentskih praksi','2024-01-15','2024-06-15'),
(2,'Istraživanje veštačke inteligencije','Primena AI u edukaciji','2023-10-01','2024-03-01'),
(3,'Razvoj mobilne aplikacije za studente','Mobilna aplikacija za upravljanje zadacima','2024-02-01','2024-05-01');

/*Table structure for table `stavka_dnevnika` */

DROP TABLE IF EXISTS `stavka_dnevnika`;

CREATE TABLE `stavka_dnevnika` (
  `id_dnevnik` bigint unsigned NOT NULL,
  `redni_broj` bigint unsigned NOT NULL AUTO_INCREMENT,
  `trajanje` int NOT NULL,
  `id_zadatak` bigint unsigned NOT NULL,
  PRIMARY KEY (`id_dnevnik`,`redni_broj`),
  KEY `redni_broj` (`redni_broj`),
  KEY `id_zadatak` (`id_zadatak`),
  CONSTRAINT `stavka_dnevnika_ibfk_2` FOREIGN KEY (`id_dnevnik`) REFERENCES `dnevnik` (`id_dnevnik`),
  CONSTRAINT `stavka_dnevnika_ibfk_3` FOREIGN KEY (`id_zadatak`) REFERENCES `zadatak` (`id_zadatak`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `stavka_dnevnika` */

insert  into `stavka_dnevnika`(`id_dnevnik`,`redni_broj`,`trajanje`,`id_zadatak`) values 
(1,1,5,1),
(1,2,3,2),
(2,1,6,3),
(2,2,4,4),
(3,1,7,5),
(3,2,8,1);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id_student` bigint unsigned NOT NULL AUTO_INCREMENT,
  `broj_indeksa` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `id_fakultet` bigint unsigned NOT NULL,
  PRIMARY KEY (`id_student`),
  KEY `idFakultet` (`id_fakultet`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`id_fakultet`) REFERENCES `fakultet` (`id_fakultet`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student` */

insert  into `student`(`id_student`,`broj_indeksa`,`ime`,`prezime`,`id_fakultet`) values 
(1,'2024/0001','Marko','Marković',1),
(2,'2024/0002','Ana','Anić',2),
(3,'2024/0003','Jovan','Jovanović',3),
(4,'2023/0004','Milica','Milić',1),
(5,'2023/0005','Nikola','Nikolić',2);

/*Table structure for table `uloga` */

DROP TABLE IF EXISTS `uloga`;

CREATE TABLE `uloga` (
  `id_zaposleni` bigint unsigned NOT NULL,
  `id_projekat` bigint unsigned NOT NULL,
  `naziv` varchar(100) NOT NULL,
  PRIMARY KEY (`id_zaposleni`,`id_projekat`),
  KEY `id_projekat` (`id_projekat`),
  CONSTRAINT `uloga_ibfk_3` FOREIGN KEY (`id_zaposleni`) REFERENCES `zaposleni` (`id_zaposleni`),
  CONSTRAINT `uloga_ibfk_4` FOREIGN KEY (`id_projekat`) REFERENCES `projekat` (`id_projekat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `uloga` */

insert  into `uloga`(`id_zaposleni`,`id_projekat`,`naziv`) values 
(1,1,'Mentor'),
(1,3,'Koordinator'),
(2,1,'Savetnik'),
(2,2,'Rukovodilac'),
(3,3,'Asistent');

/*Table structure for table `zadatak` */

DROP TABLE IF EXISTS `zadatak`;

CREATE TABLE `zadatak` (
  `id_zadatak` bigint unsigned NOT NULL AUTO_INCREMENT,
  `opis` varchar(255) NOT NULL,
  PRIMARY KEY (`id_zadatak`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `zadatak` */

insert  into `zadatak`(`id_zadatak`,`opis`) values 
(1,'Izrada projekta u Javi'),
(2,'Analiza podataka koristeći Python'),
(3,'Kreiranje dokumentacije za softver'),
(4,'Testiranje aplikacije'),
(5,'Razvoj korisničkog interfejsa');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `id_zaposleni` bigint unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `telefon` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lozinka` varchar(255) NOT NULL,
  PRIMARY KEY (`id_zaposleni`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`id_zaposleni`,`ime`,`prezime`,`telefon`,`email`,`lozinka`) values 
(1,'Uros','Kotaranin','061 1234567','uros@email.com','uros'),
(2,'Jovan','Jovanovic','062 1234567','jovan@email.com','jovan'),
(3,'Marko','Markovic','063 1234567','marko@email.com','marko'),
(4,'Petar','Petrović','0641234567','petar.p@gmail.com','lozinka123'),
(5,'Jelena','Jelić','0657654321','jelena.j@gmail.com','sifra123'),
(6,'Milan','Milić','0631112223','milan.m@gmail.com','pass123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
