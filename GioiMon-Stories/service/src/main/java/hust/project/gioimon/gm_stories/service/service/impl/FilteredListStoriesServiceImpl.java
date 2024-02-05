package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.SampleStoryDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.ListStoriesRepository;
import hust.project.gioimon.gm_stories.service.service.FilteredListStoriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class FilteredListStoriesServiceImpl implements FilteredListStoriesService {
    private final ListStoriesRepository listStoriesRepository;
    @Override
    public Page<SampleStoryDTO> getFilteredListStories(long categoryId, int writingState,String keyword, int page, int size, String sortBy) {
        System.out.println("keyword:"+ keyword);
        if(keyword.isEmpty()){
            return listStoriesRepository.getFilteredListStories(categoryId, writingState, page, size, sortBy);
        }else{
            return listStoriesRepository.search(keyword, page, size);
        }
    }

    @Override
    public List<SampleStoryDTO> getSuggestedListStories() {
        return listStoriesRepository.getSuggestedListStories();
    }

    @Override
    public Page<SampleStoryDTO> getTopStories(long categoryId, int page, int size, String sortBy) {
        return listStoriesRepository.getFilteredListStories(categoryId, 1, page, size, sortBy);
    }
    public List<SampleStoryDTO> leaderboard(String type){
        switch (type){
            case "TOP_MONTHLY":
                return listStoriesRepository.topMonthly();
            case "TOP_WEEKLY":
                return listStoriesRepository.topDaily();
            case "TOP_DAILY":
                return listStoriesRepository.topDaily();
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public Page<SampleStoryDTO> search(String keyword, int page, int size) {
        return listStoriesRepository.search(keyword, page, size);
    }
}
