package hust.project.gioimon.gm_stories.service.controllers;

import hust.project.gioimon.gm_stories.client.model.ResponseData;
import hust.project.gioimon.gm_stories.service.constant.FilterConstants;
import hust.project.gioimon.gm_stories.service.model.dto.response.SampleStoryDTO;
import hust.project.gioimon.gm_stories.service.service.FilteredListStoriesService;
import hust.project.gioimon.gm_stories.service.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0/")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class StoryController {
    private final FilteredListStoriesService filteredListStoriesService;

    @GetMapping("/filtered-list-story")
    public ResponseEntity<ResponseData<Page<SampleStoryDTO>>> getFilteredListStories(
            @RequestParam(defaultValue = "0") long categoryId,
            @RequestParam(defaultValue = "0") int writingState,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "20") int size,
            @RequestParam(defaultValue = FilterConstants.SORT_BY_UPDATE_DATE) String sortBy
    ) {
        return BaseResponse.success(filteredListStoriesService.getFilteredListStories(categoryId, writingState, page, size, sortBy));
    }

    @GetMapping("/suggested-list-stories")
    public ResponseEntity<ResponseData<List<SampleStoryDTO>>> getSuggestedListStories(
    ) {
        return BaseResponse.success(filteredListStoriesService.getSuggestedListStories());
    }
    @GetMapping("/reading-history")
    public ResponseEntity<ResponseData<List<SampleStoryDTO>>> getReadingHistory(
    ) {
        return BaseResponse.success(filteredListStoriesService.getSuggestedListStories());
    }
}
