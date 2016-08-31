-- Sample Data.
-- mysql -u root -p testdb < testdb.sql

DROP TABLE IF EXISTS `TEST`;
DROP TABLE IF EXISTS `FRUIT`;

CREATE TABLE `TEST` (
  `name` char(20) NOT NULL COMMENT 'name',
  `tel` char(20) DEFAULT NULL COMMENT 'tel',
  `addr` char(20) NOT NULL COMMENT 'address'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `FRUIT` (
  `name` char(20) NOT NULL COMMENT 'name',
  `color` char(20) DEFAULT NULL COMMENT 'color',
  `size` char(20) NOT NULL COMMENT 'size'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `TEST` WRITE;
INSERT INTO `TEST` VALUES ('one','111-111-1111','address1'),('two','222-222-2222','address2'),('three','333-333-3333','address3'),('four','444-444-4444','address4');
UNLOCK TABLES;

LOCK TABLES `FRUIT` WRITE;
INSERT INTO `FRUIT` VALUES ('apple','red','medium'),('strawberry','red','tiny'),('melon','green','huge');
UNLOCK TABLES;