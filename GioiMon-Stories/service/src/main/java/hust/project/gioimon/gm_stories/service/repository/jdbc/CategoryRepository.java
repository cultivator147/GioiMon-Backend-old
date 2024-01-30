package hust.project.gioimon.gm_stories.service.repository.jdbc;

import hust.project.gioimon.gm_stories.service.model.dto.response.CategoryDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CategoryRepository extends BaseRepository {
    public List<CategoryDTO> getCategory(long storyId){
        String sql = """
                    SELECT * FROM categories 
                    JOIN stories_categories ON categories.ID = stories_categories.CATEGORY_ID 
                    WHERE stories_categories.STORY_ID = :storyId
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("storyId", storyId);
        return getListData(sql, params, CategoryDTO.class);
    }
    public List<CategoryDTO> getAll(){
        String sql = "SELECT * FROM categories";
        return getListData(sql, null, CategoryDTO.class);
    }

}
