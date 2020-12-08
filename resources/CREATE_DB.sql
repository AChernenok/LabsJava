create DATABASE myjdbc;

use myjdbc;

CREATE TABLE IF NOT EXISTS `myjdbc`.`cast` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthdate` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS films (
  `id` INT NOT NULL AUTO_INCREMENT,
  `filmname` VARCHAR(45) NOT NULL,
  `castid` INT NOT NULL,
  `releasedate` VARCHAR(25) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `castid_idx` (`castid` ASC) VISIBLE,
  CONSTRAINT `castid`
    FOREIGN KEY (`castid`)
    REFERENCES `myjdbc`.`cast` (`id`));