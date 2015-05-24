-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2015 at 06:42 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE IF NOT EXISTS tim8;

ALTER DATABASE tim8 CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE tim8;

GRANT ALL PRIVILEGES ON tim8.* To 'EtfSI2014'@'localhost' IDENTIFIED BY '2014SIEtf';

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `idAdministrator` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `telefon` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idAdministrator`),
  UNIQUE KEY `idAdministrator_UNIQUE` (`idAdministrator`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=75 ;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`idAdministrator`, `username`, `password`, `telefon`, `email`) VALUES
(73, 'admin', '98b347ae0606d2d1bc2c4e19fe3f3db3', '000', 'Admin'),
(74, 'faruk', '9ff41dc4b232afef1d884bc1b9231c24', '061111111', 'fljuca1@etf.unsa.ba');

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE IF NOT EXISTS `klijent` (
  `idKlijent` int(11) NOT NULL AUTO_INCREMENT,
  `telefon` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `datumPrijave` date NOT NULL,
  `idKviz` int(11) DEFAULT NULL,
  PRIMARY KEY (`idKlijent`),
  UNIQUE KEY `idKlijent_UNIQUE` (`idKlijent`),
  KEY `fk_Klijent_Kviz1_idx` (`idKviz`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=77 ;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`idKlijent`, `telefon`, `email`, `datumPrijave`, `idKviz`) VALUES
(75, '062222222', 'oljubuncic1@etf.unsa.ba', '2015-05-24', NULL),
(76, '063333333', 'tmilicevic1@etf.unsa.ba', '2015-05-24', NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `kviz`
--

CREATE TABLE IF NOT EXISTS `kviz` (
  `idKviz` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `vremenskoOgranicenje` int(11) NOT NULL,
  `aktivan` tinyint(1) NOT NULL,
  `arhiviran` tinyint(1) NOT NULL,
  PRIMARY KEY (`idKviz`),
  UNIQUE KEY `idKviz_UNIQUE` (`idKviz`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `kviz`
--

INSERT INTO `kviz` (`idKviz`, `naziv`, `vremenskoOgranicenje`, `aktivan`, `arhiviran`) VALUES
(1, 'Anketa znanja', 13, 1, 0),
(2, 'Druga anketa', 10, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `odgovor`
--

CREATE TABLE IF NOT EXISTS `odgovor` (
  `idOdgovor` int(11) NOT NULL AUTO_INCREMENT,
  `idPitanje` int(11) NOT NULL,
  `tekstOdgovora` varchar(45) NOT NULL,
  PRIMARY KEY (`idOdgovor`),
  UNIQUE KEY `idOdgovor_UNIQUE` (`idOdgovor`),
  KEY `fk_Odgovor_Pitanje1_idx` (`idPitanje`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

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
(12, 7, 'Tacno'),
(13, 7, 'Netacno');

-- --------------------------------------------------------

--
-- Table structure for table `osoba`
--

CREATE TABLE IF NOT EXISTS `osoba` (
  `idOsoba` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `spol` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `datumRodjenja` date NOT NULL,
  PRIMARY KEY (`idOsoba`),
  UNIQUE KEY `idOsoba_UNIQUE` (`idOsoba`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=77 ;

--
-- Dumping data for table `osoba`
--

INSERT INTO `osoba` (`idOsoba`, `ime`, `prezime`, `spol`, `adresa`, `datumRodjenja`) VALUES
(73, 'Admin', 'Admin', 'muski', 'Admin', '1993-11-28'),
(74, 'Faruk', 'Ljuca', 'muski', 'Kemala Kapetanovi?a', '1993-01-28'),
(75, 'Orhan', 'Ljubincic', 'muski', 'Neka adresa', '1999-11-11'),
(76, 'Milicevic', 'Toni', 'muski', 'Neka adresa', '1999-11-11');

-- --------------------------------------------------------

--
-- Table structure for table `pitanje`
--

CREATE TABLE IF NOT EXISTS `pitanje` (
  `idPitanje` int(11) NOT NULL AUTO_INCREMENT,
  `tipPitanja` varchar(45) NOT NULL,
  `idKviz` int(11) NOT NULL,
  `tekstPitanja` varchar(45) NOT NULL,
  `obavezno` tinyint(1) NOT NULL,
  PRIMARY KEY (`idPitanje`),
  UNIQUE KEY `idPitanje_UNIQUE` (`idPitanje`),
  KEY `fk_Pitanje_Kviz1_idx` (`idKviz`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `pitanje`
--

INSERT INTO `pitanje` (`idPitanje`, `tipPitanja`, `idKviz`, `tekstPitanja`, `obavezno`) VALUES
(1, '4', 1, 'Koliko je 2 i 2', 0),
(2, '3', 1, 'Koja ti je najdraza boja', 0),
(3, '2', 1, 'Da li je ovaj projekat dobar', 1),
(4, '0', 1, 'Ko je najvise radio', 1),
(5, '0', 2, 'Sta je po tebi static metoda', 0),
(6, '0', 2, 'Sta je po tebi public metoda', 0),
(7, '2', 2, 'Da li je danas lijep dan', 0);

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
