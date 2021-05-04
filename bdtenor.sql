-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.17-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bdtenor
CREATE DATABASE IF NOT EXISTS `bdtenor` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `bdtenor`;

-- Volcando estructura para tabla bdtenor.alquila
CREATE TABLE IF NOT EXISTS `alquila` (
  `dnialum` varchar(9) NOT NULL,
  `dniprof` varchar(9) NOT NULL,
  `codins` varchar(20) NOT NULL,
  PRIMARY KEY (`dnialum`,`dniprof`,`codins`),
  KEY `codins` (`codins`),
  KEY `dniprof` (`dniprof`),
  CONSTRAINT `alquila_ibfk_1` FOREIGN KEY (`codins`) REFERENCES `instrumento` (`codins`),
  CONSTRAINT `alquila_ibfk_2` FOREIGN KEY (`dnialum`) REFERENCES `usuario` (`dni`),
  CONSTRAINT `alquila_ibfk_3` FOREIGN KEY (`dniprof`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.alquila: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `alquila` DISABLE KEYS */;
INSERT INTO `alquila` (`dnialum`, `dniprof`, `codins`) VALUES
	('16088451p', '16088756l', '03'),
	('16088451p', '16978545l', '01'),
	('16092756l', '16088756l', '02');
/*!40000 ALTER TABLE `alquila` ENABLE KEYS */;

-- Volcando estructura para tabla bdtenor.alumno
CREATE TABLE IF NOT EXISTS `alumno` (
  `dni` varchar(9) DEFAULT NULL,
  `edad` int(3) DEFAULT NULL,
  KEY `dni` (`dni`),
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.alumno: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`dni`, `edad`) VALUES
	('16092756l', 21),
	('169785214', 23),
	('169785564', 22),
	('16088451p', 19);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

-- Volcando estructura para tabla bdtenor.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `dnialum` varchar(9) DEFAULT NULL,
  `coddoc` varchar(20) DEFAULT NULL,
  KEY `coddoc` (`coddoc`),
  KEY `dnialum` (`dnialum`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`coddoc`) REFERENCES `documentacion` (`coddoc`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`dnialum`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.compra: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` (`dnialum`, `coddoc`) VALUES
	('16088756l', '01'),
	('16088756l', '02'),
	('16092756l', '04'),
	('169785214', '06');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;

-- Volcando estructura para tabla bdtenor.cursa
CREATE TABLE IF NOT EXISTS `cursa` (
  `dnialum` varchar(9) NOT NULL,
  `fechaini` date DEFAULT NULL,
  `fechafin` date DEFAULT NULL,
  `dniprof` varchar(9) NOT NULL,
  `codcurso` varchar(20) NOT NULL,
  PRIMARY KEY (`dnialum`,`dniprof`,`codcurso`),
  KEY `codcurso` (`codcurso`),
  KEY `dniprof` (`dniprof`),
  CONSTRAINT `cursa_ibfk_1` FOREIGN KEY (`codcurso`) REFERENCES `curso` (`codcurso`),
  CONSTRAINT `cursa_ibfk_2` FOREIGN KEY (`dnialum`) REFERENCES `usuario` (`dni`),
  CONSTRAINT `cursa_ibfk_3` FOREIGN KEY (`dniprof`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.cursa: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `cursa` DISABLE KEYS */;
INSERT INTO `cursa` (`dnialum`, `fechaini`, `fechafin`, `dniprof`, `codcurso`) VALUES
	('16088451p', '2005-04-20', '2021-04-20', '16088756l', '01'),
	('16092756l', '2020-04-20', '2021-04-20', '16978545l', '02'),
	('169785564', '2019-04-20', '2020-04-20', '16978545l', '03');
/*!40000 ALTER TABLE `cursa` ENABLE KEYS */;

-- Volcando estructura para tabla bdtenor.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `codcurso` varchar(20) NOT NULL,
  `nombrecur` varchar(20) DEFAULT NULL,
  `horas` int(100) DEFAULT NULL,
  PRIMARY KEY (`codcurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.curso: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`codcurso`, `nombrecur`, `horas`) VALUES
	('01', 'guitarra', 140),
	('02', 'bajo', 120),
	('03', 'guiatrra española', 250);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Volcando estructura para tabla bdtenor.documentacion
CREATE TABLE IF NOT EXISTS `documentacion` (
  `coddoc` varchar(20) NOT NULL,
  `titulo` varchar(20) DEFAULT NULL,
  `fechapub` date DEFAULT NULL,
  PRIMARY KEY (`coddoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.documentacion: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `documentacion` DISABLE KEYS */;
INSERT INTO `documentacion` (`coddoc`, `titulo`, `fechapub`) VALUES
	('01', 'musiquita', '2015-11-11'),
	('02', 'acordes basicos', '2020-11-11'),
	('03', 'acordes avanzado', '2020-11-11'),
	('04', 'acordes experto', '2020-11-11'),
	('05', 'Acustica', '2018-05-11'),
	('06', 'reververacion', '2010-05-08'),
	('07', 'Frecuencia de altavo', '2011-05-10');
/*!40000 ALTER TABLE `documentacion` ENABLE KEYS */;

-- Volcando estructura para tabla bdtenor.instrumento
CREATE TABLE IF NOT EXISTS `instrumento` (
  `codins` varchar(20) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codins`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.instrumento: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `instrumento` DISABLE KEYS */;
INSERT INTO `instrumento` (`codins`, `tipo`, `nombre`) VALUES
	('01', 'cuerda', 'guitarra'),
	('02', 'cuerda', 'bajo'),
	('03', 'cuerda', 'guitarra Española');
/*!40000 ALTER TABLE `instrumento` ENABLE KEYS */;

-- Volcando estructura para tabla bdtenor.profesor
CREATE TABLE IF NOT EXISTS `profesor` (
  `dni` varchar(9) DEFAULT NULL,
  `titulacion` varchar(20) DEFAULT NULL,
  KEY `dni` (`dni`),
  CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.profesor: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` (`dni`, `titulacion`) VALUES
	('16088756l', 'bajo'),
	('16978545l', 'guitarra');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;

-- Volcando estructura para tabla bdtenor.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `fijo` int(9) DEFAULT NULL,
  `movil` int(9) DEFAULT NULL,
  `contraseña` varchar(9) DEFAULT NULL,
  `fechanac` date DEFAULT NULL,
  `admin` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla bdtenor.usuario: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`dni`, `nombre`, `fijo`, `movil`, `contraseña`, `fechanac`, `admin`) VALUES
	('16088451p', 'silvia', 965320584, 632478023, '16088451p', '2001-04-20', 0),
	('16088756l', 'paco', 956856200, 630856716, '16088756l', '1996-11-11', 0),
	('16092756l', 'patricia', 956456231, 630963258, '16092756l', '2000-05-17', 0),
	('169785214', 'jonathan', 965896235, 663145896, '16978545l', '1998-11-11', 0),
	('16978523l', 'alex', 965321456, 693145963, '16978523l', '1988-11-11', 1),
	('16978545l', 'ibai', 965321456, 693145985, '16978545l', '1996-11-11', 0),
	('169785564', 'daniel', 965896235, 663145896, '16978545l', '1999-11-11', 0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
