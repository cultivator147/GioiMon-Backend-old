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

CREATE TABLE profiles
(
    user_id               BIGINT primary KEY,
    nickname             VARCHAR(200),
    picture              VARCHAR(2048),
    date_of_birth        VARCHAR(100),
    zodiac               VARCHAR(100),
    gender               VARCHAR(50),
    introduction         VARCHAR(500),
    onboard              TINYINT DEFAULT 0,
    location             VARCHAR(200),
    additional_information JSON
--                                hobbies VARCHAR(100),height VARCHAR(20),career JSON,education VARCHAR(50),
--                                hometown VARCHAR(200),living_in VARCHAR(200), sexual_orientation VARCHAR(100),drinking VARCHAR(100),
    --                                religion VARCHAR(100), smoking VARCHAR(100),children VARCHAR(100), favourite_place VARCHAR(200),
--                                political VARCHAR(100),language VARCHAR(100), location VARCHAR(200)
);


