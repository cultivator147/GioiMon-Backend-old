package hust.project.gioimon.gm_stories.service.service;

import hust.project.gioimon.gm_stories.service.model.dto.response.SampleStoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FilteredListStoriesService {
    Page<SampleStoryDTO> getFilteredListStories(long categoryId, int writingState,String keyword, int page, int size, String sortBy);
    List<SampleStoryDTO> getSuggestedListStories();
    Page<SampleStoryDTO> getTopStories(long categoryId, int page, int size, String sortBy);
     List<SampleStoryDTO> leaderboard(String type);
    Page<SampleStoryDTO> search(String keyword,int page, int size);


}
