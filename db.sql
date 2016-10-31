/*
SQLyog Ultimate v8.82 
MySQL - 5.5.5-10.1.13-MariaDB : Database - db_wms_gt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_wms_gt` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_wms_gt`;

/*Table structure for table `estado_tarea` */

DROP TABLE IF EXISTS `estado_tarea`;

CREATE TABLE `estado_tarea` (
  `id_estado_tarea` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` longtext,
  PRIMARY KEY (`id_estado_tarea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estado_tarea` */

/*Table structure for table `prioridad` */

DROP TABLE IF EXISTS `prioridad`;

CREATE TABLE `prioridad` (
  `id_prioridad` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` longtext,
  PRIMARY KEY (`id_prioridad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `prioridad` */

insert  into `prioridad`(`id_prioridad`,`nombre`,`descripcion`) values (1,'Alta','Prioridad Extremadamente Urgente'),(2,'Media','Prioridad no tan máxima a atender'),(3,'Baja','Prioridad muy poco importante');

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id_rol` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `rol` */

insert  into `rol`(`id_rol`,`nombre`) values (1,'GRS-GT-ADMIN'),(2,'GRS-GT-OPER');

/*Table structure for table `solucion_tarea` */

DROP TABLE IF EXISTS `solucion_tarea`;

CREATE TABLE `solucion_tarea` (
  `id_solucion_tarea` int(10) NOT NULL AUTO_INCREMENT,
  `id_tarea` int(10) DEFAULT NULL,
  `codigo` varchar(360) DEFAULT NULL,
  PRIMARY KEY (`id_solucion_tarea`),
  KEY `FK_solucion_tarea` (`id_tarea`),
  CONSTRAINT `FK_solucion_tarea` FOREIGN KEY (`id_tarea`) REFERENCES `tarea` (`id_tarea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `solucion_tarea` */

/*Table structure for table `tarea` */

DROP TABLE IF EXISTS `tarea`;

CREATE TABLE `tarea` (
  `id_tarea` int(10) NOT NULL AUTO_INCREMENT,
  `DocNum` int(11) DEFAULT NULL,
  `estado_id_estado` int(11) DEFAULT NULL,
  `tipo_tarea_id_tipo_tarea` int(11) DEFAULT NULL,
  `fecha_asignacion` varchar(64) DEFAULT NULL,
  `fecha_inicio` varchar(64) DEFAULT NULL,
  `fecha_fin` varchar(64) DEFAULT NULL,
  `Comentario` longtext,
  `prioridad_id_prioridad` int(10) DEFAULT NULL,
  `usuario_id_usuario` int(10) DEFAULT NULL,
  `usuario_id_usuario_asignado` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `FK_tarea_estado` (`estado_id_estado`),
  KEY `FK_tarea_tipo` (`tipo_tarea_id_tipo_tarea`),
  KEY `FK_tarea_prioridad` (`prioridad_id_prioridad`),
  KEY `FK_tarea_usuario_asignado` (`usuario_id_usuario_asignado`),
  KEY `FK_tarea` (`usuario_id_usuario`),
  CONSTRAINT `FK_tarea` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK_tarea_estado` FOREIGN KEY (`estado_id_estado`) REFERENCES `estado_tarea` (`id_estado_tarea`),
  CONSTRAINT `FK_tarea_prioridad` FOREIGN KEY (`prioridad_id_prioridad`) REFERENCES `prioridad` (`id_prioridad`),
  CONSTRAINT `FK_tarea_tipo` FOREIGN KEY (`tipo_tarea_id_tipo_tarea`) REFERENCES `tipo_tarea` (`id_tipo_tarea`),
  CONSTRAINT `FK_tarea_usuario_asignado` FOREIGN KEY (`usuario_id_usuario_asignado`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tarea` */

/*Table structure for table `tipo_tarea` */

DROP TABLE IF EXISTS `tipo_tarea`;

CREATE TABLE `tipo_tarea` (
  `id_tipo_tarea` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `descripcion` longtext,
  PRIMARY KEY (`id_tipo_tarea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_tarea` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) DEFAULT NULL,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) DEFAULT NULL,
  `correo` varchar(128) DEFAULT NULL,
  `habilitado` tinyint(1) DEFAULT NULL,
  `rol_id_rol` int(10) DEFAULT NULL,
  `pais` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`,`username`),
  KEY `FK_usuario` (`rol_id_rol`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`rol_id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`id_usuario`,`nombre`,`username`,`password`,`correo`,`habilitado`,`rol_id_rol`,`pais`) values (1,'Francisco Retana','retana','202cb962ac59075b964b07152d234b70','inforetana@gmail.com',1,1,'Guatemala'),(2,'Juan Perez','oper1',NULL,'jp@gmail.com',1,2,'Guatemala'),(3,'Mario Schulz','oper2',NULL,'ms@gmail.com',1,2,'Guatemala');

/* Procedure structure for procedure `sp_autenticarUsuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_autenticarUsuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_autenticarUsuario`(IN _nick VARCHAR(128),in _contrasena VARCHAR(128))
BEGIN
	SELECT  id_usuario,nombre,nick,correo,id_rol FROM USUARIO  U WHERE U.`nick`=_nick and U.`contrasena`=md5(_contrasena);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_registroUsuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_registroUsuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registroUsuario`(IN _nombre VARCHAR(128), IN _nick VARCHAR(128), IN _contraseña VARCHAR(128), IN _correo VARCHAR(128),in _id_rol INT)
BEGIN
	INSERT INTO `db_wms_gt`.`usuario`
	VALUES (null,
		_nombre,
		_nick,
		md5(_contraseña),
		_correo,
		_id_rol);
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
