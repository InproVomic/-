create table user_info(
  `id` int not null auto_increment,
  `user_name` varchar(128) not null,
  `password` varchar(128) not null,
  `delete_flag` tinyint(4) null default 0,
  `create_time` datetime default  now(),
  `update_time` datetime default  now() on update now(),
    primary key (`id`),
    unique index `user_name_UNIQUE` (`user_name` ASC)
)ENGINE = INNODB DEFAULT CHARACTER SET = utf8mb4 COMMENT = '用户表';

CREATE TABLE `book_info`(
    `id` int(11) not null auto_increment,
    `book_name` varchar(127) not null,
    `author` varchar(127) not null,
    `count` int(11) not null,
    `price` decimal(7,2) not null,
    `publish` varchar(256) not null,
    `status` tinyint(4) default 1 comment  '0-无效，1-正常，2-不允许借阅',
    `create_time` datetime default now(),
    `update_time` datetime default now() on update now(),
    primary key (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;