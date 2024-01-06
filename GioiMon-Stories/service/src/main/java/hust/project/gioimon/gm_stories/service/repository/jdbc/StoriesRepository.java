package hust.project.gioimon.gm_stories.service.repository.jdbc;

import hust.project.gioimon.gm_stories.service.model.dto.response.SampleStoryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Repository
@RequiredArgsConstructor
public class StoriesRepository extends BaseRepository {
    private final ChaptersRepository chaptersRepository;
    public Page<SampleStoryDTO> getFilteredListStories(long categoryId, int writingState, int page, int size, String sortBy){
        StringBuilder sqlBuilder = new StringBuilder("""
                SELECT T1.ID AS ID, T1.TITLE AS TITLE, T1.LINK AS LINK, T1.PICTURE AS PICTURE, T1.CATEGORY_ID AS CATEGORY_ID, T1.LAST_UPDATE_DATE
                FROM (
                SELECT S.ID AS ID, S.TITLE AS TITLE, S.LINK AS LINK, S.PICTURE AS PICTURE, S.LAST_UPDATE_DATE, SC.CATEGORY_ID AS CATEGORY_ID
                FROM stories S
                JOIN stories_categories SC ON SC.STORY_ID = S.ID
                WHERE\s
                	(CASE WHEN :WRITING_STATE = 0 THEN :WRITING_STATE ELSE S.WRITING_STATE END
                	)
                	= :WRITING_STATE
                ) T1
                JOIN categories C ON T1.CATEGORY_ID = C.ID
                WHERE 
                (CASE WHEN :CATEGORY_ID = 0 THEN :CATEGORY_ID ELSE C.ID END
                	)
                	= :CATEGORY_ID 
                GROUP BY ID
         """);

        Map<String, Object> params = new HashMap<>();
        params.put("CATEGORY_ID", categoryId);
        params.put("WRITING_STATE", writingState);
        Page<SampleStoryDTO> sampleStoryDTOS = getPage(sqlBuilder.toString(), params, page, size, SampleStoryDTO.class);
        sampleStoryDTOS.stream().forEach(story -> story.setChapters(chaptersRepository.getListChapters(story.getId(), 0, 3)));
//        List<SampleStoryDTO> stories = getListData(sqlBuilder.toString(), params, SampleStoryDTO.class, page, size);
//        stories.stream().forEach(story -> story.setChapters(chaptersRepository.getListChapters(story.getId(), 0, 3)));
        return sampleStoryDTOS;
    }
    public List<SampleStoryDTO> getSuggestedListStories(){
        //TODO: LOGIC SUGGESTION HERE
        StringBuilder sql = new StringBuilder("""
                    SELECT * FROM stories LIMIT 10
                """);
        List<SampleStoryDTO> results = getListData(sql.toString(), null, SampleStoryDTO.class);
        results.stream().forEach(story -> story.setChapters(chaptersRepository.getListChapters(story.getId(), 0, 3)));
        return results;
    }
}
