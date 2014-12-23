-- phpMyAdmin SQL Dump
-- version 4.2.0
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 23 Décembre 2014 à 00:31
-- Version du serveur :  5.6.17
-- Version de PHP :  5.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projetPOO`
--

-- --------------------------------------------------------

--
-- Structure de la table `telephone`
--

CREATE TABLE IF NOT EXISTS `telephone` (
`phoneID` int(11) NOT NULL,
  `phoneName` varchar(45) NOT NULL,
  `phonePrice` float(5,2) NOT NULL,
  `phonePicturePath` varchar(256) NOT NULL,
  `phoneScreenSize` float(5,2) NOT NULL,
  `phoneBrand` varchar(45) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `telephone`
--

INSERT INTO `telephone` (`phoneID`, `phoneName`, `phonePrice`, `phonePicturePath`, `phoneScreenSize`, `phoneBrand`) VALUES
(1, 'LG G3', 400.99, 'lg_lg3.jpg', 5.50, 'LG'),
(2, 'iPhone 6', 850.50, 'iphone6.jpg', 5.20, 'Apple'),
(3, 'Galaxy s3', 300.00, 'galaxy_s3.jpg', 5.00, 'Samsung'),
(4, 'Galaxy s4', 400.00, 'galaxy_s4.jpg', 5.40, 'Samsung'),
(5, 'Nokia 3310', 10.00, 'nokia_3310.jpg', 2.50, 'Nokia'),
(6, 'OnePlus', 250.00, 'one_plus.jpg', 5.40, 'One');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `telephone`
--
ALTER TABLE `telephone`
 ADD PRIMARY KEY (`phoneID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `telephone`
--
ALTER TABLE `telephone`
MODIFY `phoneID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
