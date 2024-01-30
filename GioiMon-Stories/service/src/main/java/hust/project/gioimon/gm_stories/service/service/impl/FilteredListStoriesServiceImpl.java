package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.SampleStoryDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.ListStoriesRepository;
import hust.project.gioimon.gm_stories.service.service.FilteredListStoriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class FilteredListStoriesServiceImpl implements FilteredListStoriesService {
    private final ListStoriesRepository listStoriesRepository;
    @Override
    public Page<SampleStoryDTO> getFilteredListStories(long categoryId, int writingState, int page, int size, String sortBy) {
        return listStoriesRepository.getFilteredListStories(categoryId, writingState, page, size, sortBy);
    }

    @Override
    public List<SampleStoryDTO> getSuggestedListStories() {
        return listStoriesRepository.getSuggestedListStories();
    }

    @Override
    public Page<SampleStoryDTO> getTopStories(long categoryId, int page, int size, String sortBy) {
        return listStoriesRepository.getFilteredListStories(categoryId, 1, page, size, sortBy);
    }
}
