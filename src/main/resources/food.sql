CREATE TABLE `restaurant`.`food` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(250) NULL,
  `date_serve` DATETIME NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id`));
  
  
ALTER TABLE `restaurant`.`food` 
ADD COLUMN `create_date` DATE NOT NULL AFTER `price`,
ADD COLUMN `update_date` DATE NULL AFTER `create_date`,
CHANGE COLUMN `date_serve` `date_serve` VARCHAR(20) NOT NULL ;
