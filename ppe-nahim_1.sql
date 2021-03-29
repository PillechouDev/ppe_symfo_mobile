-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  mer. 24 mars 2021 à 07:29
-- Version du serveur :  5.7.28
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ppe-nahim`
--

-- --------------------------------------------------------

--
-- Structure de la table `injection`
--

DROP TABLE IF EXISTS `injection`;
CREATE TABLE IF NOT EXISTS `injection` (
  `IdInjection` int(11) NOT NULL AUTO_INCREMENT,
  `prenomPatient` varchar(50) DEFAULT NULL,
  `nomPatient` varchar(50) DEFAULT NULL,
  `dateInjection` datetime DEFAULT NULL,
  `IdVaccin` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdInjection`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `injection`
--

INSERT INTO `injection` (`IdInjection`, `prenomPatient`, `nomPatient`, `dateInjection`, `IdVaccin`) VALUES
(59, 'romain', 'pani', '2021-03-24 00:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`username`, `password`, `id`) VALUES
('romain', 'romain', 1);

-- --------------------------------------------------------

--
-- Structure de la table `vaccin`
--

DROP TABLE IF EXISTS `vaccin`;
CREATE TABLE IF NOT EXISTS `vaccin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `dose` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vaccin`
--

INSERT INTO `vaccin` (`id`, `nom`, `dose`) VALUES
(1, 'Pfizer', 97),
(2, 'Astra Zeneca', 149),
(3, 'Moderna', 498);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
