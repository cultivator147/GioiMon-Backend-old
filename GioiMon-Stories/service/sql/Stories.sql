CREATE DATABASE `GM_STORIES` /*!40100 COLLATE 'utf8mb4_general_ci' */

--          Table STORIES
DROP TABLE IF EXISTS STORIES;
CREATE TABLE STORIES(
    ID BIGINT PRIMARY KEY  AUTO_INCREMENT COMMENT 'ID truyện' ,
    TITLE NVARCHAR(200) NOT NULL COMMENT 'Tên truyện' COLLATE 'utf8mb3_general_ci',
    PICTURE VARCHAR(2048) DEFAULT 'https://st.nettruyenus.com/data/comics/28/tro-thanh-nguoi-giam-dinh-chat-doc-cho-t-9371.jpg',
    CONTENT_TYPE BINARY NOT NULL DEFAULT 1 COMMENT 'Thể loại truyện tranh/chữ. 1 - Truyện tranh   2 - Truyện chữ',
    INTRODUCTION TEXT,
    LINK VARCHAR(2048) NOT NULL DEFAULT '/',
    GENDER BINARY NOT NULL DEFAULT 0 COMMENT '0 - Cả 2. 1 - Nam. 2 - Nữ',
    WRITING_STATE BINARY NOT NULL DEFAULT 1 COMMENT '0 - All; 1 - UNCOMPLETE. 2 - COMPLETE. -1 : CANCEL',
    LAST_UPDATE_DATE DATETIME,
    CHAPTER_QUANTITY BIGINT NOT NULL DEFAULT 1,
    FLAG_STATUS BINARY NOT NULL DEFAULT 1  COMMENT 'Trạng thái bị xóa/hiển thị của truyện. 1 - Active   0 - Inactive'
)
COMMENT='Thông tin cơ bản của truyện'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

--          Table STORIES_CHAPTERS
DROP TABLE IF EXISTS STORIES_CHAPTERS;
CREATE TABLE STORIES_CHAPTERS(
    CHAPTER_NUMBER BIGINT NOT NULL COMMENT 'Số thứ tự chương truyện',
    CHAPTER_NAME VARCHAR(2048),
    STORY_ID BIGINT NOT NULL COMMENT 'ID của truyện',
    LINK VARCHAR(200) COMMENT 'Đường link của chương truyện',
    CONTENT TEXT NOT NULL COMMENT 'Nội dung truyện, có thể là đường link các hình ảnh hoặc văn bản',
    UPDATE_DATE DATETIME COMMENT 'Thời gian update chương',
    VIEWS BIGINT NOT NULL DEFAULT 0 COMMENT 'Lượt xem chương',
    FLAG_STATUS BINARY NOT NULL DEFAULT 1 COMMENT 'Trạng thái hoạt động của chương. 1 - Active   0 - Inactive',
    SCOPE BINARY NOT NULL DEFAULT 1 COMMENT 'Phạm vi đọc của chương. 1 - Public   2 - Private (Mở khóa thì mới đọc được)'
)
COMMENT='Các chapters của truyện'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

--          Table CATEGORIES
DROP TABLE IF EXISTS CATEGORIES;
CREATE TABLE CATEGORIES
    ID  BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID danh mục',
    NAME VARCHAR(200) COMMENT 'Tên danh mục',
    DESCRIPTION NVARCHAR(2048)
)
COMMENT='Tất cả danh mục truyện'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

--          Table STORIES_CATEGORIES
DROP TABLE IF EXISTS STORIES_CATEGORIES;
CREATE TABLE STORIES_CATEGORIES(
    STORY_ID BIGINT COMMENT 'ID truyện',
    CATEGORY_ID BIGINT COMMENT 'ID danh mục'
)
COMMENT='Danh mục của từng truyện'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

--          Table AUTHORS
DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(
    ID  BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID author',
    NAME VARCHAR(200) COMMENT 'Tên author',
    DESCRIPTION NVARCHAR(2048)
)
COMMENT='Tất cả authors'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

--          Table AUTHORS_STORIES
DROP TABLE IF EXISTS STORIES_AUTHORS;
CREATE TABLE STORIES_AUTHORS(
    AUTHOR_ID  BIGINT,
    STORY_ID BIGINT
);


--          CONSTRAINTS
ALTER TABLE STORIES_CHAPTERS ADD CONSTRAINT FK_STORIES_CHAPTERS FOREIGN KEY (STORY_ID) REFERENCES STORIES(ID);
ALTER TABLE STORIES_CHAPTERS ADD CONSTRAINT PK_STORIES_CHAPTERS PRIMARY KEY (CHAPTER_NUMBER, STORY_ID, FLAG_STATUS);
ALTER TABLE STORIES_CATEGORIES ADD CONSTRAINT FK_STORIES FOREIGN KEY (STORY_ID) REFERENCES STORIES(ID);
ALTER TABLE STORIES_CATEGORIES ADD CONSTRAINT FK_CATEGORIES FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES(ID);
ALTER TABLE STORIES_AUTHORS ADD CONSTRAINT FK_AUTHOR_ID FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(ID);
ALTER TABLE STORIES_AUTHORS ADD CONSTRAINT FK_STORIE_ID FOREIGN KEY (STORY_ID) REFERENCES STORIES(ID);



