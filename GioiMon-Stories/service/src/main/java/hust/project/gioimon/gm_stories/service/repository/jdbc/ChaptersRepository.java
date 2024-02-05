package hust.project.gioimon.gm_stories.service.repository.jdbc;

import hust.project.gioimon.gm_stories.service.model.dto.response.ChapterDTO;
import hust.project.gioimon.gm_stories.service.model.dto.response.ContentDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChaptersRepository extends BaseRepository{
    public Page<ChapterDTO> getListChaptersPagination(long storyId, int page, int size){
        String sql = """
                    SELECT CHAPTER_NUMBER, CHAPTER_NAME, PICTURE, UPDATE_DATE, VIEWS
                    FROM stories_chapters
                    WHERE FLAG_STATUS = 1
                    AND STORY_ID = :STORY_ID;
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("CATEGORY_ID", storyId);
        return getPage(sql, params, page, size, ChapterDTO.class);
    }
    public List<ChapterDTO> getListChapters(long storyId, int page, int size){
        String sql = """
                    SELECT  CHAPTER_NUMBER, CHAPTER_NAME, PICTURE, UPDATE_DATE, VIEWS
                    FROM stories_chapters
                    WHERE FLAG_STATUS = 1
                    AND STORY_ID = :STORY_ID
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("STORY_ID", storyId);
        return getListData(sql, params, ChapterDTO.class, page, size);
    }
    public List<ChapterDTO> getAll(long storyId){
        String sql = """
                    SELECT  CHAPTER_NUMBER, CHAPTER_NAME, PICTURE, UPDATE_DATE, VIEWS
                    FROM stories_chapters
                    WHERE FLAG_STATUS = 1
                    AND STORY_ID = :STORY_ID
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("STORY_ID", storyId);
        return getListData(sql, params, ChapterDTO.class);
    }
    public String[] getImages(long storyId, long chapterNumber){
        String sql = "SELECT content FROM stories_chapters WHERE story_id = :storyId AND chapter_number = :chapterNumber";
        Map<String, Object> params = new HashMap<>();
        params.put("storyId", storyId);
        params.put("chapterNumber", chapterNumber);
        String content =  queryForObject(sql, params, String.class);
        content = content.substring(1, content.length() - 2);
        String[] images = {};
        images = content.split(",");
        for (int i = 0; i < images.length; i++) {
            images[i] = images[i].trim().replaceAll("\"", "");
        }
        return images;
    }
    public long getQuantity(long storyId){
        String sql = "SELECT COUNT(*) AS quantity FROM stories_chapters WHERE story_id = :storyId";
        Map<String, Object> params = new HashMap<>();
        params.put("storyId", storyId);
        return  queryForObject(sql, params, Long.class);
    }
    public void plusView(long storyId, long chapterNumber){
        String sql = "UPDATE stories_chapters SET VIEWS = VIEWS + 1 WHERE STORY_ID = :storyId AND CHAPTER_NUMBER = :chapterNumber";
        Map<String, Object> params = new HashMap<>();
        params.put("storyId", storyId);
        params.put("chapterNumber", chapterNumber);
        executeSqlDatabase(sql, params);
    }
}
