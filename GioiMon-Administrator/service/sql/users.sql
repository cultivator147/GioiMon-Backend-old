CREATE DATABASE `GM_USERS` /*!40100 COLLATE 'utf8mb4_general_ci' */
DROP TABLE IF EXIST USERS;
CREATE TABLE USERS(
    ID BIGINT AUTO_INCREMENT COMMENT 'USER ID'  COLLATE 'utf8mb4_general_ci' ,
    USERNAME NVARCHAR(200) NOT NULL COMMENT 'USERNAME' COLLATE 'utf8mb3_general_ci',
    PASSWORD NVARCHAR(200) NOT NULL COMMENT 'MK' COLLATE 'utf8mb3_general_ci',
    ACCESS_TOKEN VARCHAR(2048),
    ROLE BINARY NOT NULL DEFAULT 1 COMMENT 'ROLE NGƯỜI DÙNG. 1 LÀ USER, 2 LÀ ADMIN, 3 LÀ SUPERADMIN',
    FLAG_STATUS BINARY NOT NULL DEFAULT 1  COMMENT 'Trạng thái KHOÁ/KHÔNG KHOÁ của USER. 1 - Active   0 - Inactive',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY(`USERNAME`)
);

