-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           10.5.8-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour bestioles
DROP DATABASE IF EXISTS `bestioles`;
CREATE DATABASE IF NOT EXISTS `bestioles` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bestioles`;

-- Listage de la structure de la table bestioles. animal
DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SPECIE` int(11) NOT NULL DEFAULT 0,
  `NAME` varchar(50) NOT NULL DEFAULT '0',
  `COLOR` varchar(50) NOT NULL DEFAULT '0',
  `SEX` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_animal_specie` (`ID_SPECIE`),
  CONSTRAINT `FK_animal_specie` FOREIGN KEY (`ID_SPECIE`) REFERENCES `specie` (`ID`),
  CONSTRAINT `FKk60fmmjc49n3ufxm4cgxat86m` FOREIGN KEY (`ID_SPECIE`) REFERENCES `specie` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Listage des données de la table bestioles.animal : ~6 rows (environ)
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` (`ID`, `ID_SPECIE`, `NAME`, `COLOR`, `SEX`) VALUES
	(1, 1, 'Max', 'Gris tacheté', 'M'),
	(2, 2, 'Médor', 'Blanc', 'M'),
	(3, 1, 'Loulou', 'Noir', 'F'),
	(4, 2, 'Zia', 'Brun', 'F'),
	(5, 3, 'Lou', 'Blanc', 'F'),
	(6, 1, 'Minouchette', 'Roux', 'M');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;

-- Listage de la structure de la table bestioles. person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(50) NOT NULL DEFAULT '0',
  `LASTNAME` varchar(50) NOT NULL DEFAULT '0',
  `AGE` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Listage des données de la table bestioles.person : ~8 rows (environ)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`ID`, `FIRSTNAME`, `LASTNAME`, `AGE`) VALUES
	(1, 'Henri', 'Lamarque', 22),
	(2, 'Sylvie', 'Lamarque', 24),
	(3, 'Jean', 'Vintroi', 55),
	(4, 'Paul', 'Demaine', 80),
	(5, 'Sophie', 'Nero', 45),
	(6, 'Pierre', 'Sansane', 17),
	(7, 'John', 'Mangolo', 33),
	(8, 'Bill', 'Wagner', 26);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- Listage de la structure de la table bestioles. person__animal
DROP TABLE IF EXISTS `person__animal`;
CREATE TABLE IF NOT EXISTS `person__animal` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PERSON_ID` int(11) NOT NULL DEFAULT 0,
  `ANIMAL_ID` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  KEY `FK_PERSON__ANIMAL_person` (`PERSON_ID`),
  KEY `FK_PERSON__ANIMAL_animal` (`ANIMAL_ID`),
  CONSTRAINT `FK2lmehlbu29pd5ivnb3oi3xxfr` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`),
  CONSTRAINT `FK_PERSON__ANIMAL_animal` FOREIGN KEY (`ANIMAL_ID`) REFERENCES `animal` (`ID`),
  CONSTRAINT `FK_PERSON__ANIMAL_person` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`),
  CONSTRAINT `FKqiwiskcc3qsnadv6c9n8ummn3` FOREIGN KEY (`ANIMAL_ID`) REFERENCES `animal` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Listage des données de la table bestioles.person__animal : ~7 rows (environ)
/*!40000 ALTER TABLE `person__animal` DISABLE KEYS */;
INSERT INTO `person__animal` (`ID`, `PERSON_ID`, `ANIMAL_ID`) VALUES
	(3, 2, 1),
	(5, 2, 5),
	(6, 3, 3),
	(8, 4, 2),
	(9, 5, 4),
	(10, 7, 1),
	(11, 8, 6);
/*!40000 ALTER TABLE `person__animal` ENABLE KEYS */;

-- Listage de la structure de la table bestioles. specie
DROP TABLE IF EXISTS `specie`;
CREATE TABLE IF NOT EXISTS `specie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMON_NAME` varchar(50) NOT NULL DEFAULT '0',
  `LATIN_NAME` varchar(127) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- Listage des données de la table bestioles.specie : ~3 rows (environ)
/*!40000 ALTER TABLE `specie` DISABLE KEYS */;
INSERT INTO `specie` (`ID`, `COMMON_NAME`, `LATIN_NAME`) VALUES
	(1, 'Chat', 'Felis silvestris catus'),
	(2, 'Chien', 'Canis lupus familiaris'),
	(3, 'Lapin', 'Oryctolagus cuniculus');
/*!40000 ALTER TABLE `specie` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
