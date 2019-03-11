-- database initialization script

-- build the database
CREATE DATABASE seckill;

-- use the database
use seckill;

-- create table for stock
CREATE TABLE seckill (
`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'item stock id',
`name` varchar(120) NOT NULL COMMENT 'item name',
`number` int NOT NULL COMMENT 'item stock number',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'seckill create time',
`start_time` TIMESTAMP NOT NULL COMMENT 'seckill start time',
`end_time` TIMESTAMP NOT NULL COMMENT 'seckill end time',
PRIMARY KEY (seckill_id),
KEY idx_create_time(create_time),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='seckill stock table';

-- initial data
INSERT into seckill(name, number, start_time, end_time)
VALUES
  ('$100 for ipad', 400, '2019-03-01 00:00:00', '2019-03-02 00:00:00'),
  ('$150 for iphone8', 300, '2019-03-01 00:00:00', '2019-03-02 00:00:00'),
  ('$250 for iphoneX', 200, '2019-03-01 00:00:00', '2019-03-02 00:00:00'),
  ('$900 for MacBookPro', 100, '2019-03-01 00:00:00', '2019-03-02 00:00:00');

-- successful seckill table
-- user login information
CREATE TABLE success_killed (
`seckill_id` BIGINT NOT NULL COMMENT 'item seckilled id',
`user_phone` BIGINT NOT NULL COMMENT 'user phone number',
`state` TINYINT NOT NULL DEFAULT -1 COMMENT 'State: -1:invalid 0:success 1:paid 2:shipped',
`create_time` TIMESTAMP NOT NULL COMMENT 'purchase create time',
PRIMARY KEY(seckill_id, user_phone), /*union/*联合主键*/ key*/
KEY idx_create_time(create_time)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='seckill success information table';

-- connect mysql
-- mysql -uroot -p