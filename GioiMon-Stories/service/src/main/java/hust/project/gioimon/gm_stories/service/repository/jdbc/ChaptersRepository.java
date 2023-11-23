package hust.project.gioimon.gm_stories.service.repository.jdbc;

import hust.project.gioimon.gm_stories.service.model.dto.response.ChapterDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChaptersRepository extends BaseRepository{
    public Page<ChapterDTO> getListChaptersPagination(long storyId, int page, int size){
        String sql = """
                    SELECT CHAPTER_NUMBER, CHAPTER_NAME, LINK, UPDATE_DATE, VIEWS
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
                    SELECT  CHAPTER_NUMBER, CHAPTER_NAME, LINK, UPDATE_DATE, VIEWS
                    FROM stories_chapters
                    WHERE FLAG_STATUS = 1
                    AND STORY_ID = :STORY_ID
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("STORY_ID", storyId);
        return getListData(sql, params, ChapterDTO.class, page, size);
    }
}
