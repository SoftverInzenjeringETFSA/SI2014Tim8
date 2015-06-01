-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2015 at 07:34 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tim8`
--
-- Create Database
CREATE DATABASE  IF NOT EXISTS `tim8` /*!40100 DEFAULT CHARACTER SET utf8 */;
SET NAMES 'utf8';
USE `tim8`;

--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `idAdministrator` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idAdministrator`),
  UNIQUE KEY `idAdministrator_UNIQUE` (`idAdministrator`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=124 ;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`idAdministrator`, `username`, `password`, `telefon`, `email`) VALUES
(106, 'faruk', '9ff41dc4b232afef1d884bc1b9231c24', '061111111', 'fljuca1@etf.unsa.ba'),
(107, 'toni', 'aefe34008e63f1eb205dc4c4b8322253', '061111112', 'tmilicevic1@etf.unsa.ba'),
(108, 'orhan', '061cd5c17399f24dd6fabccb96c57462', '061111113', 'oljubuncic1@etf.unsa.ba'),
(109, 'edis', '0d0c0642e3505cda308f747b9b192fe3', '061111114', 'ekunic1@etf.unsa.ba'),
(110, 'josip', '8e55bbc08589b717d080fab27b50f07d', '061111115', 'jkvesic1@etf.unsa.ba'),
(111, 'amina', 'bd82dd2a8b944f131d0a53bc1b473029', '061111116', 'akadrispahic1@etf.unsa.ba'),
(112, 'muhamed', '87941c253d1b8c5257788d91344013ab', '061111117', 'mmujic1@etf.unsa.ba'),
(123, 'a', '202cb962ac59075b964b07152d234b70', '123456', 'demo@demo.demo');

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE IF NOT EXISTS `klijent` (
  `idKlijent` int(11) NOT NULL AUTO_INCREMENT,
  `telefon` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datumPrijave` date NOT NULL,
  `idKviz` int(11) DEFAULT NULL,
  PRIMARY KEY (`idKlijent`),
  UNIQUE KEY `idKlijent_UNIQUE` (`idKlijent`),
  KEY `fk_Klijent_Kviz1_idx` (`idKviz`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=123 ;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`idKlijent`, `telefon`, `email`, `datumPrijave`, `idKviz`) VALUES
(105, '', 'klijent1@mail.edu', '2015-05-31', 1),
(113, '225883', 'brega@live.com', '2015-06-01', 4),
(114, '6666666', 'johny@mail.edu', '2015-06-01', 5),
(115, '123321', 'milan@hotmail.com', '2015-06-01', 5),
(116, '987123', 'magi@live.com', '2015-06-01', 4),
(117, '6969696', 'nirvana@gmail.com', '2015-06-01', 5),
(118, '112113', 'himzo.partybreaker@live.edu', '2015-06-01', 5),
(119, '654321', 'mick@yahoo.com', '2015-06-01', 5),
(120, '000111', 'gile@live.com', '2015-06-01', 4),
(121, '123456', 'davorin@gmail.com', '2015-06-01', 5),
(122, '123412', 'zele@hotmail.com', '2015-06-01', 5);

-- --------------------------------------------------------

--
-- Table structure for table `klijent_odgovor`
--

CREATE TABLE IF NOT EXISTS `klijent_odgovor` (
  `idKlijentOdgovor` int(11) NOT NULL AUTO_INCREMENT,
  `idKlijent` int(11) DEFAULT NULL,
  `idOdgovor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idKlijentOdgovor`),
  UNIQUE KEY `idOsobaKvizPitanjeOdgovor_UNIQUE` (`idKlijentOdgovor`),
  KEY `fk_Klijent_Odgovor_Klijent1_idx` (`idKlijent`),
  KEY `fk_Klijent_Odgovor_Odgovor1_idx` (`idOdgovor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=178 ;

--
-- Dumping data for table `klijent_odgovor`
--

INSERT INTO `klijent_odgovor` (`idKlijentOdgovor`, `idKlijent`, `idOdgovor`) VALUES
(76, 105, 4),
(77, 105, 6),
(78, 105, 7),
(79, 105, 10),
(80, 105, 48),
(81, 113, 49),
(82, 113, 56),
(83, 113, 62),
(84, 113, 67),
(85, 113, 64),
(86, 113, 52),
(87, 113, 65),
(88, 113, 57),
(89, 113, 66),
(90, 113, 59),
(91, 114, 75),
(92, 114, 74),
(93, 114, 77),
(94, 114, 82),
(95, 114, 91),
(96, 114, 96),
(97, 114, 76),
(98, 114, 89),
(99, 114, 92),
(100, 114, 97),
(101, 114, 68),
(102, 114, 86),
(103, 115, 92),
(104, 115, 70),
(105, 115, 88),
(106, 115, 113),
(107, 115, 68),
(108, 115, 86),
(109, 115, 90),
(110, 115, 112),
(111, 115, 78),
(112, 116, 60),
(113, 116, 49),
(114, 116, 61),
(115, 116, 54),
(116, 116, 115),
(117, 116, 56),
(118, 116, 58),
(119, 116, 63),
(120, 116, 114),
(121, 117, 90),
(122, 117, 92),
(123, 117, 84),
(124, 117, 71),
(125, 117, 72),
(126, 117, 116),
(127, 117, 68),
(128, 117, 73),
(129, 117, 117),
(130, 117, 87),
(131, 117, 88),
(132, 118, 78),
(133, 118, 86),
(134, 118, 74),
(135, 118, 91),
(136, 118, 69),
(137, 118, 92),
(138, 118, 70),
(139, 118, 119),
(140, 118, 88),
(141, 118, 118),
(142, 119, 120),
(143, 119, 83),
(144, 119, 89),
(145, 119, 70),
(146, 119, 121),
(147, 119, 91),
(148, 119, 92),
(149, 119, 68),
(150, 119, 86),
(151, 120, 123),
(152, 120, 55),
(153, 120, 53),
(154, 120, 122),
(155, 120, 49),
(156, 120, 64),
(157, 120, 57),
(158, 121, 125),
(159, 121, 68),
(160, 121, 124),
(161, 121, 73),
(162, 121, 87),
(163, 121, 70),
(164, 121, 92),
(165, 121, 80),
(166, 121, 90),
(167, 121, 88),
(168, 122, 92),
(169, 122, 68),
(170, 122, 126),
(171, 122, 72),
(172, 122, 91),
(173, 122, 86),
(174, 122, 78),
(175, 122, 89),
(176, 122, 70),
(177, 122, 127);

-- --------------------------------------------------------

--
-- Table structure for table `kviz`
--

CREATE TABLE IF NOT EXISTS `kviz` (
  `idKviz` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `vremenskoOgranicenje` int(11) NOT NULL,
  `aktivan` tinyint(1) NOT NULL,
  `arhiviran` tinyint(1) NOT NULL,
  PRIMARY KEY (`idKviz`),
  UNIQUE KEY `idKviz_UNIQUE` (`idKviz`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `kviz`
--

INSERT INTO `kviz` (`idKviz`, `naziv`, `vremenskoOgranicenje`, `aktivan`, `arhiviran`) VALUES
(1, 'Anketa znanja', 13, 0, 1),
(3, 'Prazna anketa', 10, 1, 0),
(4, 'Android 5.0 lollipop', 15, 1, 0),
(5, 'Liga šampiona', 10, 1, 0),
(6, 'Primjer nedovršene ankete', 25, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `odgovor`
--

CREATE TABLE IF NOT EXISTS `odgovor` (
  `idOdgovor` int(11) NOT NULL AUTO_INCREMENT,
  `idPitanje` int(11) NOT NULL,
  `tekstOdgovora` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idOdgovor`),
  UNIQUE KEY `idOdgovor_UNIQUE` (`idOdgovor`),
  KEY `fk_Odgovor_Pitanje1_idx` (`idPitanje`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=128 ;

--
-- Dumping data for table `odgovor`
--

INSERT INTO `odgovor` (`idOdgovor`, `idPitanje`, `tekstOdgovora`) VALUES
(1, 1, '1'),
(2, 1, '2'),
(3, 1, '3'),
(4, 1, '4'),
(5, 1, '5'),
(6, 2, 'Plava'),
(7, 2, 'Zelena'),
(8, 2, 'Crvena'),
(9, 2, 'Neka druga'),
(10, 3, 'Tacno'),
(11, 3, 'Netacno'),
(48, 4, 'Klijent 1'),
(49, 8, 'Da'),
(50, 8, 'Ne'),
(51, 9, 'više od 6 mjeseci'),
(52, 9, 'više od 1 godine'),
(53, 9, 'više od 2 godine'),
(54, 9, 'nijedno od navedenog'),
(55, 10, 'Da'),
(56, 10, 'Ne'),
(57, 11, 'Tacno'),
(58, 11, 'Netacno'),
(59, 12, 'Facebook messenger'),
(60, 12, 'Skype'),
(61, 12, 'Youtube'),
(62, 12, 'Viber'),
(63, 12, 'Gmail'),
(64, 12, 'Livescore'),
(65, 12, 'Slappy bird'),
(66, 13, 'Sviđa mi se.'),
(67, 14, 'Veća sloboda, manje zauzimanje resursa.'),
(68, 15, 'Da'),
(69, 15, 'Ne'),
(70, 16, 'Nogomet'),
(71, 16, 'Rukomet'),
(72, 16, 'Košarka'),
(73, 16, 'Američki fudbal'),
(74, 16, 'Odbojka'),
(75, 16, 'Odbojka na pijesku'),
(76, 16, 'Sjedeća odbojka'),
(77, 16, 'Nožna odbojka'),
(78, 17, 'Nogomet'),
(79, 17, 'Košarka'),
(80, 17, 'Rukomet'),
(81, 17, 'Formula 1'),
(82, 17, 'Tenis'),
(83, 17, 'Hrvanje'),
(84, 17, 'Boks'),
(85, 17, 'Golf'),
(86, 18, 'Tacno'),
(87, 18, 'Netacno'),
(88, 19, 'Tacno'),
(89, 19, 'Netacno'),
(90, 20, 'Da'),
(91, 20, 'Ne'),
(92, 22, 'FC Barcelona'),
(93, 22, 'FC Juventus'),
(94, 22, 'Real Madrid CF'),
(95, 22, 'Neko treći'),
(96, 21, 'Prvenstveno zbog RTV takse.'),
(97, 23, 'Nije odgovoreno'),
(98, 24, 'Da'),
(99, 24, 'Da'),
(100, 24, 'Da'),
(101, 25, 'Tacno'),
(102, 25, 'Netacno'),
(103, 26, 'Da'),
(104, 26, 'Ne'),
(105, 27, 'Udžbenik'),
(106, 27, 'Skripta'),
(107, 27, 'Laboratorijske vježbe'),
(108, 27, 'Live komunikacija'),
(109, 27, 'Google'),
(110, 27, 'Yahoo'),
(111, 27, 'Nešto drugo'),
(112, 21, 'Liga prvaka je najelitnije takmičenje.'),
(113, 23, 'Nije odgovoreno'),
(114, 13, 'Ok je.'),
(115, 14, 'Lošiji interfejs.'),
(116, 21, 'U Švrakinom selu nema interneta i digitalne.'),
(117, 23, 'Talent'),
(118, 21, 'A zašto ne bi?'),
(119, 23, 'Talent, trening, odricanje.'),
(120, 21, 'Skupa Total TV.'),
(121, 23, 'Nije odgovoreno'),
(122, 13, 'Dobra je.'),
(123, 14, 'Više aplikacija.'),
(124, 21, 'Onako.'),
(125, 23, 'Nije odgovoreno'),
(126, 21, 'Zbog RTV takse.'),
(127, 23, 'Odricanje i talenat.');

-- --------------------------------------------------------

--
-- Table structure for table `osoba`
--

CREATE TABLE IF NOT EXISTS `osoba` (
  `idOsoba` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `spol` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `adresa` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `datumRodjenja` date NOT NULL,
  PRIMARY KEY (`idOsoba`),
  UNIQUE KEY `idOsoba_UNIQUE` (`idOsoba`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=124 ;

--
-- Dumping data for table `osoba`
--

INSERT INTO `osoba` (`idOsoba`, `ime`, `prezime`, `spol`, `adresa`, `datumRodjenja`) VALUES
(105, 'Klijent', 'Jedan', 'zenski', 'Buća potok 13', '1992-11-12'),
(106, 'Faruk', 'Ljuca', 'muski', 'Sarajevo', '1993-12-12'),
(107, 'Toni', 'Luca', 'muski', 'Sarajevo', '1993-12-12'),
(108, 'Orhan', 'Pamuk', 'muski', 'Sarajevo', '1993-12-12'),
(109, 'Edis', 'Kunić', 'muski', 'Sarajevo', '1993-12-12'),
(110, 'Josip', 'Kvesić', 'muski', 'Sarajevo', '1993-12-12'),
(111, 'Amina', 'Kadrispahić', 'zenski', 'Sarajevo', '1993-12-12'),
(112, 'Muhamed', 'Mujić', 'muski', 'Sarajevo', '1993-12-12'),
(113, 'Goran', 'Bregović', 'muski', 'Mejtaš', '1970-11-11'),
(114, 'Branimir', 'Štulić', 'muski', 'Amsterdam', '1969-03-01'),
(115, 'Milan', 'Mladenović', 'muski', 'Beograd', '1960-12-12'),
(116, 'Margita', 'Stefanović', 'zenski', 'Beograd', '1983-12-12'),
(117, 'Kurt', 'Cobain', 'muski', 'Švrakino selo', '1978-12-12'),
(118, 'Himzo', 'Polovina', 'muski', 'Mostar', '1947-12-12'),
(119, 'Mick', 'Jagger', 'muski', 'Wall ST', '1960-12-12'),
(120, 'Srđan', 'Gojković', 'muski', 'Beograd', '1975-12-12'),
(121, 'Davorin', 'Bogović', 'muski', 'Zagreb', '1969-12-11'),
(122, 'Sead', 'Lipovača', 'muski', 'Bihać', '1974-12-12'),
(123, 'Demo', 'Demo', 'muski', 'Demo', '2000-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `pitanje`
--

CREATE TABLE IF NOT EXISTS `pitanje` (
  `idPitanje` int(11) NOT NULL AUTO_INCREMENT,
  `tipPitanja` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `idKviz` int(11) NOT NULL,
  `tekstPitanja` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `obavezno` tinyint(1) NOT NULL,
  PRIMARY KEY (`idPitanje`),
  UNIQUE KEY `idPitanje_UNIQUE` (`idPitanje`),
  KEY `fk_Pitanje_Kviz1_idx` (`idKviz`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=30 ;

--
-- Dumping data for table `pitanje`
--

INSERT INTO `pitanje` (`idPitanje`, `tipPitanja`, `idKviz`, `tekstPitanja`, `obavezno`) VALUES
(1, '4', 1, 'Koliko je 2 i 2', 0),
(2, '3', 1, 'Koja ti je najdraza boja', 0),
(3, '2', 1, 'Da li je ovaj projekat dobar', 1),
(4, '0', 1, 'Ko je najvise radio', 1),
(8, '1', 4, 'Da li posjedujete smartphone', 1),
(9, '4', 4, 'Koliko dugo koristite smartphone', 1),
(10, '1', 4, 'Da li ste preuzeli zadnju verziju androida', 1),
(11, '2', 4, 'Android 5.0 lollipop je ispunio očekivanja', 1),
(12, '3', 4, 'Najčešće korištene aplikacije', 1),
(13, '0', 4, 'Opći dojam o novoj verziji androida', 1),
(14, '0', 4, 'Prednosti/mane u odnosu na iOs', 1),
(15, '1', 5, 'Da li pratite neku vrstu sporta', 1),
(16, '3', 5, 'Koje sportove najčešće pratite?', 1),
(17, '4', 5, 'Omiljeni sport', 1),
(18, '2', 5, 'Državne televizije nedovoljno prenose sport', 1),
(19, '2', 5, 'Sportski TV kanali su preskupi', 1),
(20, '1', 5, 'Da li se nogomet previše favorizira', 1),
(21, '0', 5, 'Zašto bi FTV trebao prenositi Ligu šampiona', 1),
(22, '4', 5, 'Ko će pobijediti u Berlinu', 1),
(23, '0', 5, 'Šta je ključ uspjeha u sportu', 0),
(24, '4', 6, 'Da li ste zadovoljni projektom', 0),
(25, '2', 6, 'Projekat je bio prezahtjevan', 1),
(26, '1', 6, 'Da li vam se sviđa Java', 1),
(27, '3', 6, 'Osnovna literatura', 1),
(28, '0', 6, 'Mišljene o predmetu', 1),
(29, '0', 6, 'Mišljene o timu', 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `fk_Administrator_Osoba1` FOREIGN KEY (`idAdministrator`) REFERENCES `osoba` (`idOsoba`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `klijent`
--
ALTER TABLE `klijent`
  ADD CONSTRAINT `fk_Klijent_Kviz1` FOREIGN KEY (`idKviz`) REFERENCES `kviz` (`idKviz`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Klijent_Osoba1` FOREIGN KEY (`idKlijent`) REFERENCES `osoba` (`idOsoba`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `klijent_odgovor`
--
ALTER TABLE `klijent_odgovor`
  ADD CONSTRAINT `fk_Klijent_Odgovor_Klijent1` FOREIGN KEY (`idKlijent`) REFERENCES `klijent` (`idKlijent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Klijent_Odgovor_Odgovor1` FOREIGN KEY (`idOdgovor`) REFERENCES `odgovor` (`idOdgovor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `odgovor`
--
ALTER TABLE `odgovor`
  ADD CONSTRAINT `fk_Odgovor_Pitanje1` FOREIGN KEY (`idPitanje`) REFERENCES `pitanje` (`idPitanje`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `pitanje`
--
ALTER TABLE `pitanje`
  ADD CONSTRAINT `fk_Pitanje_Kviz1` FOREIGN KEY (`idKviz`) REFERENCES `kviz` (`idKviz`) ON DELETE CASCADE ON UPDATE NO ACTION;

-- Add database user
CREATE USER 'EtfSI2014'@'localhost' IDENTIFIED BY '2014SIEtf';
GRANT USAGE ON *.* TO 'EtfSI2014'@'localhost' IDENTIFIED BY '2014SIEtf' WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
GRANT ALL PRIVILEGES ON `tim8`.* TO 'EtfSI2014'@'localhost';


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
