package hust.project.gioimon.gm_stories.service.repository.jdbc;

import hust.project.gioimon.gm_stories.service.model.dto.response.AuthorDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class AuthorRepository extends BaseRepository{
    public List<AuthorDTO> getAuthors(long storyId){
        String sql = "SELECT a.* FROM authors a JOIN stories_authors sa ON a.id = sa.author_id WHERE sa.story_id = :storyId";
        Map<String, Object> params = new HashMap<>();
        params.put("storyId", storyId);
        return getListData(sql, params, AuthorDTO.class);
    }
}
