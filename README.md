# shardingjdbc-learning

## 数据库

### shardUser：用户信息库。user_$不做分库，只做分表

    CREATE TABLE `user_1` (
    `user_id` bigint(20) NOT NULL COMMENT '用户id',
    `user_name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
    `tel` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电话',
    PRIMARY KEY (`user_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表1';
    
    CREATE TABLE `user_2` (
    `user_id` bigint(20) NOT NULL COMMENT '用户id',
    `user_name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
    `tel` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电话',
    PRIMARY KEY (`user_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表2';


### shardShip：业务数据库。分库、分表。shardShip1、shardShip2

    CREATE TABLE `ship_1` (
    `ship_id` bigint(20) NOT NULL COMMENT '战舰id',
    `user_id` bigint(20) NOT NULL COMMENT '所属用户id',
    `type` int(11) NOT NULL COMMENT '战舰类型',
    `ship_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '战舰名称',
    `status` int(11) NOT NULL DEFAULT '1' COMMENT '战舰状态'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='战舰信息表1';
    
    CREATE TABLE `ship_2` (
    `ship_id` bigint(20) NOT NULL COMMENT '战舰id',
    `user_id` bigint(20) NOT NULL COMMENT '所属用户id',
    `type` int(11) NOT NULL COMMENT '战舰类型',
    `ship_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '战舰名称',
    `status` int(11) NOT NULL DEFAULT '1' COMMENT '战舰状态'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='战舰信息表2';
    
    CREATE TABLE `ship_equipment_1` (
    `ship_equipment_id` bigint(20) NOT NULL COMMENT '装备id',
    `ship_id` bigint(20) NOT NULL COMMENT '战舰id',
    `type` int(11) NOT NULL COMMENT '装备类型',
    `name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '装备名称',
    `status` int(11) NOT NULL COMMENT '装备状态',
    PRIMARY KEY (`ship_equipment_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='战舰装备表1';
    
    CREATE TABLE `ship_equipment_2` (
    `ship_equipment_id` bigint(20) NOT NULL COMMENT '装备id',
    `ship_id` bigint(20) NOT NULL COMMENT '战舰id',
    `type` int(11) NOT NULL COMMENT '装备类型',
    `name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '装备名称',
    `status` int(11) NOT NULL COMMENT '装备状态',
    PRIMARY KEY (`ship_equipment_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='战舰装备表2';

### 广播表：字典表dictionary

    CREATE TABLE `dictionary` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `type` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '字典类型名称',
    `key` int(11) DEFAULT NULL COMMENT '字典键',
    `value` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '字典值',
    `enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '启用状态',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典定义表';