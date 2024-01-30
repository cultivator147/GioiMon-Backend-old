package hust.project.gioimon.gm_stories.service.service;

import hust.project.gioimon.gm_stories.service.model.dto.response.ContentDTO;
import hust.project.gioimon.gm_stories.service.model.dto.response.DetailStoryDTO;

public interface StoryService {
    DetailStoryDTO getDetail(int storyId);
    String getTitle(long storyId);
    ContentDTO getContent(long storyId, long chapterNumber);
}
