CREATE TABLE `discount`(
  `id_discount` INTEGER(11) NOT NULL DEFAULT 0,
  `discount_percentage` VARCHAR(20) NULL,
  `count_discount` VARCHAR(20) NULL,
  PRIMARY KEY USING BTREE (`id_discount`)
)
;

CREATE TABLE `customer`(
  `id_customer` INTEGER(11) NOT NULL DEFAULT 0,
  `name` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `surname` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `comment` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `id_discount` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`id_customer`, `id_discount`),
  KEY `R_8` USING BTREE (`id_discount`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`id_discount`) REFERENCES `discount` (`id_discount`)
)
;

CREATE TABLE `orders`(
  `id_order` INTEGER(11) NOT NULL DEFAULT 0,
  `arrival_date` DATE DEFAULT NULL,
  `release_date` DATE DEFAULT NULL,
  `id_customer` INTEGER(11) NOT NULL,
  `id_discount` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`id_order`, `id_customer`, `id_discount`),
  KEY `R_12` USING BTREE (`id_customer`, `id_discount`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_customer`, `id_discount`) REFERENCES `customer` (`id_customer`, `id_discount`)
)
;

CREATE TABLE `hotel_room`(
  `id_hotel_room` CHAR(18) COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `capacity` INTEGER(11) DEFAULT NULL,
  `comfort` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `price` INTEGER(11) DEFAULT NULL,
  `booking` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `id_order` INTEGER(11) DEFAULT NULL,
  `id_customer` INTEGER(11) DEFAULT NULL,
  `id_discount` INTEGER(11) DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id_hotel_room`),
  KEY `tmp_ems_index_178` USING BTREE (`id_order`, `id_customer`, `id_discount`),
  CONSTRAINT `hotel_room_ibfk_1` FOREIGN KEY (`id_order`, `id_customer`, `id_discount`) REFERENCES `orders` (`id_order`, `id_customer`, `id_discount`)
)
;