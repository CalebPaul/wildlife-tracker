-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'animals'
--
-- ---

DROP TABLE IF EXISTS `animals`;

CREATE TABLE `animals` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `name` VARCHAR NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'endangered_animals'
--
-- ---

DROP TABLE IF EXISTS `endangered_animals`;

CREATE TABLE `endangered_animals` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `name` VARCHAR NULL DEFAULT NULL,
  `health` VARCHAR NULL DEFAULT NULL,
  `age` VARCHAR NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'sightings'
--
-- ---

DROP TABLE IF EXISTS `sightings`;

CREATE TABLE `sightings` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `timestamp` TIMESTAMP NULL DEFAULT NULL,
  `animal_id` INTEGER NULL DEFAULT NULL,
  `endangered_animal_id` INTEGER NULL DEFAULT NULL,
  `location` VARCHAR NULL DEFAULT NULL,
  `ranger_name` VARCHAR NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys
-- ---

ALTER TABLE `sightings` ADD FOREIGN KEY (animal_id) REFERENCES `animals` (`id`);
ALTER TABLE `sightings` ADD FOREIGN KEY (endangered_animal_id) REFERENCES `endangered_animals` (`id`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `animals` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `endangered_animals` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `sightings` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `animals` (`id`,`name`) VALUES
-- ('','');
-- INSERT INTO `endangered_animals` (`id`,`name`,`health`,`age`) VALUES
-- ('','','','');
-- INSERT INTO `sightings` (`id`,`timestamp`,`animal_id`,`endangered_animal_id`,`location`,`ranger_name`) VALUES
-- ('','','','','','');
