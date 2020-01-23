CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `addres` varchar(100) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
