package hust.project.gioimon.gm_stories.service.controllers;

import hust.project.gioimon.gm_stories.client.model.ResponseData;
import hust.project.gioimon.gm_stories.service.model.dto.response.ContentDTO;
import hust.project.gioimon.gm_stories.service.model.dto.response.DetailStoryDTO;
import hust.project.gioimon.gm_stories.service.model.dto.response.HistoryDTO;
import hust.project.gioimon.gm_stories.service.service.StoryService;
import hust.project.gioimon.gm_stories.service.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0/story/")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class StoryController {
    private final StoryService storyService;
    @GetMapping("/detail")
    public ResponseEntity<ResponseData<DetailStoryDTO>> getDetail(@RequestParam("story_id") int storyId){
        return BaseResponse.success(storyService.getDetail(storyId));
    }
    @GetMapping("/content")
    public ResponseEntity<ResponseData<ContentDTO>> getContent(@RequestParam long story_id, @RequestParam long chapter_number){
        return BaseResponse.success(storyService.getContent(story_id, chapter_number));
    }
    @PostMapping("/history")
    public ResponseEntity<ResponseData<HistoryDTO>> logHistory(@RequestHeader(name = "user_id")long userId, @RequestHeader(name = "Authorization")String token, @RequestBody HistoryDTO historyDTO){
        return BaseResponse.success(storyService.logHistory(userId, historyDTO.getStory_id(), historyDTO.getChapter_number()));
    }
}
