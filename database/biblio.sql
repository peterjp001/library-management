-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 22 juil. 2022 à 16:52
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `biblio`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

CREATE TABLE `adherent` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `cin_nif` varchar(30) NOT NULL,
  `sexe` varchar(20) NOT NULL,
  `date_naissance` varchar(20) NOT NULL,
  `adresse` varchar(200) NOT NULL,
  `telephone` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `profession` varchar(30) NOT NULL,
  `statut` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adherent`
--

INSERT INTO `adherent` (`id`, `nom`, `prenom`, `cin_nif`, `sexe`, `date_naissance`, `adresse`, `telephone`, `email`, `profession`, `statut`) VALUES
(4, 'Tibertson', 'Steeve', '3009-0092344', 'masculin', '2022-05-12', 'Bon Repos', '1234', 'steeve@gmail.com', 'informaticien', 'Etudiant'),
(5, 'Jean Pierre', 'Louis Peterson', '930-0999-99', 'masculin', '1998-07-15', 'Delmas 33', '48423991', 'jeanpierrepeterson01@gmail.com', 'informatique', 'Etudiant'),
(6, 'Jean Pierre', 'Louis Wendy', '3009-0092344', 'masculin', '2000-12-23', 'Bon Repos', '44776830', 'wendy@gmail.com', 'informaticien', 'Etudiant');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `id` int(11) NOT NULL,
  `titre` varchar(30) NOT NULL,
  `auteur` varchar(200) NOT NULL,
  `date_parution` varchar(30) NOT NULL,
  `resume` text NOT NULL,
  `categorie` varchar(20) NOT NULL,
  `quantite` int(11) NOT NULL,
  `etat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `titre`, `auteur`, `date_parution`, `resume`, `categorie`, `quantite`, `etat`) VALUES
(1, 'Gouverneurs de la rosee', 'Jacques Roumain', '1944-05-10', 'Si Je savais', 'Roman ', 89, 'Neuf'),
(2, 'Masters of the dew', 'Jacques Roumain', '2022-07-13', 'iughigiugih', 'Roman ', 10, 'Neuf'),
(3, 'Choucoune', 'Oswald Durant', '2022-07-13', 'oihohi', 'Poeme ', 18, 'Neuf'),
(4, 'Cric? Crac!', 'Georges Sylvain', '2022-07-28', 'dfrgrgtrhth', 'Poeme', 0, 'Neuf');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `id_livre` int(11) NOT NULL,
  `id_adherent` int(11) NOT NULL,
  `statut` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `id_livre`, `id_adherent`, `statut`) VALUES
(1, 2, 5, 1),
(2, 4, 6, 1);

-- --------------------------------------------------------

--
-- Structure de la table `transaction_livre`
--

CREATE TABLE `transaction_livre` (
  `id` int(11) NOT NULL,
  `id_livre` int(11) NOT NULL,
  `id_adherent` int(11) NOT NULL,
  `date_pret` date NOT NULL,
  `date_retour` date NOT NULL,
  `statut_pret` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `transaction_livre`
--

INSERT INTO `transaction_livre` (`id`, `id_livre`, `id_adherent`, `date_pret`, `date_retour`, `statut_pret`) VALUES
(10, 3, 5, '2022-07-03', '2022-07-15', 1),
(11, 1, 6, '2022-07-14', '2022-07-21', 0),
(12, 3, 4, '2022-07-14', '2022-07-22', 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` text NOT NULL,
  `niveau` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `niveau`) VALUES
(1, 'admin', 'admin', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `transaction_livre`
--
ALTER TABLE `transaction_livre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adherent`
--
ALTER TABLE `adherent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `transaction_livre`
--
ALTER TABLE `transaction_livre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
