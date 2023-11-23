package hust.project.gioimon.gm_stories.service.service;

import hust.project.gioimon.gm_stories.service.model.dto.response.ChapterDTO;
import org.springframework.data.domain.Page;

public interface IChapterService {
    Page<ChapterDTO> getAllChapters(long storyId, int page, int size);
}
