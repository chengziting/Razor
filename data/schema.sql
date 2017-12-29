CREATE TABLE `razor`.`userinfo` (
  `Id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Phone` VARCHAR(11) NULL,
  `Email` VARCHAR(45) NOT NULL,
  `QQ` VARCHAR(45) NULL,
  `Status` INT NOT NULL DEFAULT 0,
  `CreateDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdateDate` DATETIME NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC));

  alter table userinfo auto_increment=1000

  CREATE TABLE `roles` (
  `Id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Status` int(11) NOT NULL DEFAULT '0',
  `CreateDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table roles auto_increment=1000

CREATE TABLE `userrole` (
  `UserId` mediumint(9) NOT NULL,
  `RoeId` mediumint(9) NOT NULL,
  `CreateDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`UserId`,`RoeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;