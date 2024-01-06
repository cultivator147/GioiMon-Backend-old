-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.3.0-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for gm_stories
DROP DATABASE IF EXISTS `gm_stories`;
CREATE DATABASE IF NOT EXISTS `gm_stories` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `gm_stories`;

-- Dumping structure for table gm_stories.categories
DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID danh mục',
  `NAME` varchar(200) DEFAULT NULL COMMENT 'Tên danh mục',
  `DESCRIPTION` varchar(2048) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tất cả danh mục truyện';

-- Dumping data for table gm_stories.categories: ~16 rows (approximately)
DELETE FROM `categories`;
INSERT INTO `categories` (`ID`, `NAME`, `DESCRIPTION`) VALUES
	(1, 'ACTION', 'Thể loại này thường có nội dung về đánh nhau, bạo lực, hỗn loạn, với diễn biến nhanh'),
	(2, 'ADULT', 'Thể loại Adult đề cập đến vấn đề nhạy cảm, chỉ dành cho tuổi 17+'),
	(3, 'ADVENTURE', 'Thể loại phiêu lưu, mạo hiểm, thường là hành trình của các nhân vật'),
	(4, 'ANIME', 'Truyện đã được chuyển thể thành film Anime'),
	(5, 'Chuyển sinh', 'Thể loại này là những câu chuyện về người ở một thế giới này xuyên đến một thế giới khác, có thể là thế giới mang phong cách trung cổ với kiếm sĩ và ma thuật, hay thế giới trong game, hoặc có thể là bạn chết ở nơi này và được chuyển sinh đến nơi khác'),
	(6, 'COMEDY', 'Thể loại có nội dung trong sáng và cảm động, thường có các tình tiết gây cười, các xung đột nhẹ nhàng'),
	(7, 'COMIC', 'Truyện tranh Châu Âu và Châu Mĩ'),
	(8, 'COOKING', 'Thể loại có nội dung về nấu ăn, ẩm thực'),
	(9, 'Cổ đại', 'Truyện có nội dung xảy ra ở thời cổ đại phong kiến.'),
	(10, 'Doujinshi', 'Thể loại truyện phóng tác do fan hay có thể cả những Mangaka khác với tác giả truyện gốc. Tác giả vẽ Doujinshi thường dựa trên những nhân vật gốc để viết ra những câu chuyện theo sở thích của mình'),
	(11, 'Drama', 'Thể loại mang đến cho người xem những cảm xúc khác nhau: buồn bã, căng thẳng thậm chí là bi phẫn'),
	(12, 'Đam mỹ', 'Truyện tình cảm giữa nam và nam.'),
	(13, 'Ecchi', 'Thường có những tình huống nhạy cảm nhằm lôi cuốn người xem'),
	(14, 'Fantasy', 'Thể loại xuất phát từ trí tưởng tượng phong phú, từ pháp thuật đến thế giới trong mơ thậm chí là những câu chuyện thần tiên'),
	(15, 'Gender Bender', 'Là một thể loại trong đó giới tính của nhân vật bị lẫn lộn: nam hoá thành nữ, nữ hóa thành nam...'),
	(16, 'Harem', 'hể loại truyện tình cảm, lãng mạn mà trong đó, nhiều nhân vật nữ thích một nam nhân vật chính hoặc ngược lại');

-- Dumping structure for table gm_stories.stories
DROP TABLE IF EXISTS `stories`;
CREATE TABLE IF NOT EXISTS `stories` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID truyện',
  `TITLE` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'Tên truyện',
  `CONTENT_TYPE` binary(1) NOT NULL DEFAULT '1' COMMENT 'Thể loại truyện tranh/chữ. 1 - Truyện tranh   2 - Truyện chữ',
  `INTRODUCTION` text DEFAULT NULL,
  `GENDER` binary(1) NOT NULL DEFAULT '0' COMMENT '0 - Cả 2. 1 - Nam. 2 - Nữ',
  `WRITING_STATE` binary(1) NOT NULL DEFAULT '1' COMMENT '1 - UNCOMPLETE. 2 - COMPLETE. -1 : CANCEL',
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `CHAPTER_QUANTITY` bigint(20) NOT NULL DEFAULT 1,
  `FLAG_STATUS` binary(1) NOT NULL DEFAULT '1' COMMENT 'Trạng thái bị xóa/hiển thị của truyện. 1 - Active   0 - Inactive',
  `PICTURE` varchar(2048) DEFAULT 'https://st.nettruyenus.com/data/comics/28/tro-thanh-nguoi-giam-dinh-chat-doc-cho-t-9371.jpg',
  `link` varchar(2048) DEFAULT '/',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Thông tin cơ bản của truyện';

-- Dumping data for table gm_stories.stories: ~6 rows (approximately)
DELETE FROM `stories`;
INSERT INTO `stories` (`ID`, `TITLE`, `CONTENT_TYPE`, `INTRODUCTION`, `GENDER`, `WRITING_STATE`, `LAST_UPDATE_DATE`, `CHAPTER_QUANTITY`, `FLAG_STATUS`, `PICTURE`, `link`) VALUES
	(1, 'Già thiên', _binary 0x31, 'Già thiên', _binary 0x30, _binary 0x32, '2022-11-17 21:15:05', 200, _binary 0x31, 'https://st.nettruyenus.com/data/comics/130/su-phu-cua-ta-moi-khi-den-dai-nan-moi-do-9195.jpg', 'https://www.nettruyenus.com/truyen-tranh/su-phu-cua-ta-moi-khi-den-dai-nan-moi-dot-pha-76930'),
	(2, 'Tối cường thần thoại đế hoàng', _binary 0x31, 'Tần quân', _binary 0x30, _binary 0x32, '2022-11-18 21:15:05', 300, _binary 0x31, 'https://st.nettruyenus.com/data/comics/239/pha-bo-gioi-han.jpg', 'https://www.nettruyenus.com/truyen-tranh/pha-bo-gioi-han-358314'),
	(3, 'Cung quỷ kiếm thần', _binary 0x31, 'Nguỵ Tấn', _binary 0x30, _binary 0x32, '2022-11-18 21:12:05', 300, _binary 0x31, 'https://st.nettruyenus.com/data/comics/229/cung-quy-kiem-than.jpg', 'https://www.nettruyenus.com/truyen-tranh/cung-quy-kiem-than-360691'),
	(4, 'ANH TRAI TÔI ĐẾN TỪ NÚI SÂU', _binary 0x31, 'Già thiên', _binary 0x30, _binary 0x32, '2022-11-17 21:15:05', 200, _binary 0x31, 'https://st.nettruyenus.com/data/comics/69/anh-trai-toi-den-tu-nui-sau.jpg', 'https://www.nettruyenus.com/truyen-tranh/anh-trai-toi-den-tu-nui-sau-87621'),
	(5, 'NÓNG LÒNG MUỐN GIÀY VÒ EM', _binary 0x31, 'GIÀY VÒ EM', _binary 0x30, _binary 0x32, '2022-11-18 21:15:05', 300, _binary 0x31, 'https://st.nettruyenus.com/data/comics/81/nong-long-muon-giay-vo-em.jpg', 'https://www.nettruyenus.com/truyen-tranh/nong-long-muon-giay-vo-em-99153'),
	(6, 'NGÀY NÀO ĐÓ TRỞ THÀNH CÔNG CHÚA TẾ PHẨM', _binary 0x31, 'CÔNG CHÚA', _binary 0x30, _binary 0x32, '2022-11-18 21:12:05', 300, _binary 0x31, 'https://st.nettruyenus.com/data/comics/186/ngay-nao-do-tro-thanh-cong-chua-te-pham.jpg', 'https://www.nettruyenus.com/truyen-tranh/ngay-nao-do-tro-thanh-cong-chua-te-pham-526664');

-- Dumping structure for table gm_stories.stories_categories
DROP TABLE IF EXISTS `stories_categories`;
CREATE TABLE IF NOT EXISTS `stories_categories` (
  `STORY_ID` bigint(20) DEFAULT NULL COMMENT 'ID truyện',
  `CATEGORY_ID` bigint(20) DEFAULT NULL COMMENT 'ID danh mục',
  KEY `FK_STORIES` (`STORY_ID`),
  KEY `FK_CATEGORIES` (`CATEGORY_ID`),
  CONSTRAINT `FK_CATEGORIES` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `categories` (`ID`),
  CONSTRAINT `FK_STORIES` FOREIGN KEY (`STORY_ID`) REFERENCES `stories` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Danh mục của từng truyện';

-- Dumping data for table gm_stories.stories_categories: ~10 rows (approximately)
DELETE FROM `stories_categories`;
INSERT INTO `stories_categories` (`STORY_ID`, `CATEGORY_ID`) VALUES
	(1, 1),
	(1, 5),
	(3, 9),
	(2, 1),
	(2, 5),
	(4, 3),
	(5, 5),
	(6, 6),
	(4, 7),
	(5, 4);

-- Dumping structure for table gm_stories.stories_chapters
DROP TABLE IF EXISTS `stories_chapters`;
CREATE TABLE IF NOT EXISTS `stories_chapters` (
  `CHAPTER_NUMBER` bigint(20) NOT NULL COMMENT 'Số thứ tự chương truyện',
  `STORY_ID` bigint(20) NOT NULL COMMENT 'ID của truyện',
  `LINK` varchar(200) DEFAULT NULL COMMENT 'Đường link của chương truyện',
  `CONTENT` text NOT NULL COMMENT 'Nội dung truyện, có thể là đường link các hình ảnh hoặc văn bản',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT 'Thời gian update chương',
  `VIEWS` bigint(20) NOT NULL DEFAULT 0 COMMENT 'Lượt xem chương',
  `FLAG_STATUS` binary(1) NOT NULL DEFAULT '1' COMMENT 'Trạng thái hoạt động của chương. 1 - Active   0 - Inactive',
  `SCOPE` binary(1) NOT NULL DEFAULT '1' COMMENT 'Phạm vi đọc của chương. 1 - Public   2 - Private (Mở khóa thì mới đọc được)',
  `CHAPTER_NAME` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`CHAPTER_NUMBER`,`STORY_ID`,`FLAG_STATUS`),
  KEY `FK_STORIES_CHAPTERS` (`STORY_ID`),
  CONSTRAINT `FK_STORIES_CHAPTERS` FOREIGN KEY (`STORY_ID`) REFERENCES `stories` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Các chapters của truyện';

-- Dumping data for table gm_stories.stories_chapters: ~6 rows (approximately)
DELETE FROM `stories_chapters`;
INSERT INTO `stories_chapters` (`CHAPTER_NUMBER`, `STORY_ID`, `LINK`, `CONTENT`, `UPDATE_DATE`, `VIEWS`, `FLAG_STATUS`, `SCOPE`, `CHAPTER_NAME`) VALUES
	(1, 1, 'https://www.nettruyenus.com/truyen-tranh/gia-thien/chap-1/56459', 'Không có', '2023-11-17 21:18:45', 2, _binary 0x31, _binary 0x31, NULL),
	(1, 2, 'https://nettruyenco.vn/truyen-tranh/toi-cuong-than-thoai-de-hoang/chuong-1/648857', 'Không có', '2023-11-18 01:00:58', 4, _binary 0x31, _binary 0x31, NULL),
	(1, 4, 'https://www.nettruyenus.com/truyen-tranh/gia-thien/chap-1/56459', 'Không có', '2023-11-17 21:18:45', 2, _binary 0x31, _binary 0x31, NULL),
	(1, 5, 'https://nettruyenco.vn/truyen-tranh/toi-cuong-than-thoai-de-hoang/chuong-1/648857', 'Không có', '2023-11-18 01:00:58', 4, _binary 0x31, _binary 0x31, NULL),
	(1, 6, 'https://www.nettruyenus.com/truyen-tranh/gia-thien/chap-2/56460', 'Không có', '2023-11-18 21:19:56', 1, _binary 0x31, _binary 0x31, NULL),
	(2, 1, 'https://www.nettruyenus.com/truyen-tranh/gia-thien/chap-2/56460', 'Không có', '2023-11-18 21:19:56', 1, _binary 0x31, _binary 0x31, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
