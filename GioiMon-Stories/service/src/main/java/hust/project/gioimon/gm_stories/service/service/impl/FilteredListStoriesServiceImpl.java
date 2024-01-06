package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.SampleStoryDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.StoriesRepository;
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
    private final StoriesRepository storiesRepository;
    @Override
    public Page<SampleStoryDTO> getFilteredListStories(long categoryId, int writingState, int page, int size, String sortBy) {
        return storiesRepository.getFilteredListStories(categoryId, writingState, page, size, sortBy);
    }

    @Override
    public List<SampleStoryDTO> getSuggestedListStories() {
        return storiesRepository.getSuggestedListStories();
    }
}
