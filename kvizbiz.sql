-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2015 at 09:34 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=72 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=72 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  ADD CONSTRAINT `fk_Pitanje_Kviz1` FOREIGN KEY (`idKviz`) REFERENCES `kviz` (`idKviz`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
