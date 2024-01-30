package hust.project.gioimon.gm_stories.service.repository.jdbc;

import hust.project.gioimon.gm_stories.service.model.dto.response.DetailStoryDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StoryRepository extends BaseRepository{
    public DetailStoryDTO get(int storyId){
        String sql = """
                    SELECT * FROM stories WHERE id = :storyId
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("storyId", storyId);
        DetailStoryDTO result = queryForObject(sql, params, DetailStoryDTO.class);
        result.setWritingState(writingState(Integer.parseInt(result.getWritingState())));
        return result;
    }
    private String writingState(int writingState){
        return writingState == 2 ? "Đang ra" : writingState == 1 ? "Hoàn thành" : "Ngừng ra";
    }
    public String getTitle(long storyId){
        String sql = "SELECT title FROM stories WHERE id = :storyId";
        Map<String, Object> params = new HashMap<>();
        params.put("storyId", storyId);
        return queryForObject(sql, params, String.class);
    }
}
