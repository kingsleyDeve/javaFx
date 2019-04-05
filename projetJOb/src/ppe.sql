-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 27 Mai 2018 à 13:37
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ppe`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `idadministrateur` int(11) NOT NULL,
  `administrateur_siret` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `administrateur_mdp` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `gerer_jeunes` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `gerer_offres` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `gerer_partenaires` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `gerer_administrateurs` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Contenu de la table `administrateur`
--

INSERT INTO `administrateur` (`idadministrateur`, `administrateur_siret`, `administrateur_mdp`, `gerer_jeunes`, `gerer_offres`, `gerer_partenaires`, `gerer_administrateurs`) VALUES
(1, '1234', 'azer', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `idadresse` int(11) NOT NULL,
  `ville` char(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `cp` int(11) DEFAULT NULL,
  `rue` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `idjeune` int(11) DEFAULT NULL,
  `idpartenaire` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `idformation` int(11) NOT NULL,
  `type_formation` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Structure de la table `intituler`
--

CREATE TABLE `intituler` (
  `idoffre` int(11) NOT NULL,
  `idformation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Structure de la table `jeune`
--

CREATE TABLE `jeune` (
  `idjeune` int(11) NOT NULL,
  `nom` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `prenom` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `login` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `jeune_mdp` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `idadresse` int(11) DEFAULT NULL,
  `idformation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Contenu de la table `jeune`
--

INSERT INTO `jeune` (`idjeune`, `nom`, `prenom`, `login`, `jeune_mdp`, `idadresse`, `idformation`) VALUES
(1, 're', 'az', 'az', 're', NULL, NULL),
(2, '', '', '', '', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `localiser`
--

CREATE TABLE `localiser` (
  `idjeune` int(11) NOT NULL,
  `idadresse` int(11) NOT NULL,
  `idpartenaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `idoffre` int(11) NOT NULL,
  `type_contrat` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `emploi` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `idpartenaire` int(11) DEFAULT NULL,
  `idformation` int(11) DEFAULT NULL,
  `idadresse` int(11) DEFAULT NULL,
  `dateoffre` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Contenu de la table `offre`
--

INSERT INTO `offre` (`idoffre`, `type_contrat`, `emploi`, `idpartenaire`, `idformation`, `idadresse`, `dateoffre`) VALUES
(1, 'cdi', 'developpement web', 1, NULL, NULL, '2018-03-06'),
(2, 'cdd', 'dev', 1, NULL, NULL, '2018-04-03'),
(3, 'yu', 'az', 2, NULL, NULL, '1970-01-01'),
(4, 'cdi', 'reza', 1, NULL, NULL, '2018-05-10'),
(5, 'hffe', 'gffegb', 1, NULL, NULL, '2018-05-23');

-- --------------------------------------------------------

--
-- Structure de la table `partenaire`
--

CREATE TABLE `partenaire` (
  `idpartenaire` int(11) NOT NULL,
  `partenaire_siret` int(11) DEFAULT NULL,
  `partenaire_mdp` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `idadresse` int(11) DEFAULT NULL,
  `partenaire_nom` varchar(25) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `idoffre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Contenu de la table `partenaire`
--

INSERT INTO `partenaire` (`idpartenaire`, `partenaire_siret`, `partenaire_mdp`, `idadresse`, `partenaire_nom`, `idoffre`) VALUES
(1, 123456789, 'aze', NULL, 'poi', 1),
(2, 456789, 'aze', NULL, 'poy', 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`idadministrateur`);

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`idadresse`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`idformation`);

--
-- Index pour la table `intituler`
--
ALTER TABLE `intituler`
  ADD PRIMARY KEY (`idoffre`,`idformation`),
  ADD KEY `FK_intituler_idformation` (`idformation`);

--
-- Index pour la table `jeune`
--
ALTER TABLE `jeune`
  ADD PRIMARY KEY (`idjeune`),
  ADD KEY `FK_jeune_idformation` (`idformation`);

--
-- Index pour la table `localiser`
--
ALTER TABLE `localiser`
  ADD PRIMARY KEY (`idjeune`,`idadresse`,`idpartenaire`),
  ADD KEY `FK_localiser_idadresse` (`idadresse`),
  ADD KEY `FK_localiser_idpartenaire` (`idpartenaire`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`idoffre`);

--
-- Index pour la table `partenaire`
--
ALTER TABLE `partenaire`
  ADD PRIMARY KEY (`idpartenaire`),
  ADD KEY `FK_partenaire_idoffre` (`idoffre`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `idadministrateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `idadresse` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `idformation` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `jeune`
--
ALTER TABLE `jeune`
  MODIFY `idjeune` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `idoffre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `partenaire`
--
ALTER TABLE `partenaire`
  MODIFY `idpartenaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `intituler`
--
ALTER TABLE `intituler`
  ADD CONSTRAINT `FK_intituler_idformation` FOREIGN KEY (`idformation`) REFERENCES `formation` (`idformation`),
  ADD CONSTRAINT `FK_intituler_idoffre` FOREIGN KEY (`idoffre`) REFERENCES `offre` (`idoffre`);

--
-- Contraintes pour la table `jeune`
--
ALTER TABLE `jeune`
  ADD CONSTRAINT `FK_jeune_idformation` FOREIGN KEY (`idformation`) REFERENCES `formation` (`idformation`);

--
-- Contraintes pour la table `localiser`
--
ALTER TABLE `localiser`
  ADD CONSTRAINT `FK_localiser_idadresse` FOREIGN KEY (`idadresse`) REFERENCES `adresse` (`idadresse`),
  ADD CONSTRAINT `FK_localiser_idjeune` FOREIGN KEY (`idjeune`) REFERENCES `jeune` (`idjeune`),
  ADD CONSTRAINT `FK_localiser_idpartenaire` FOREIGN KEY (`idpartenaire`) REFERENCES `partenaire` (`idpartenaire`);

--
-- Contraintes pour la table `partenaire`
--
ALTER TABLE `partenaire`
  ADD CONSTRAINT `FK_partenaire_idoffre` FOREIGN KEY (`idoffre`) REFERENCES `offre` (`idoffre`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
