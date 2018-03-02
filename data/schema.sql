CREATE TABLE `razor`.`userinfo` (
  `Id` varchar(36) NOT NULL ,
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


  CREATE TABLE `roles` (
  `Id` VARCHAR (36) NOT NULL ,
  `Name` varchar(45) NOT NULL,
  `Status` int(11) NOT NULL DEFAULT '0',
  `CreateDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `userrole` (
  `UserId` VARCHAR (36) NOT NULL,
  `RoeId` VARCHAR (36) NOT NULL,
  `CreateDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`UserId`,`RoeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;