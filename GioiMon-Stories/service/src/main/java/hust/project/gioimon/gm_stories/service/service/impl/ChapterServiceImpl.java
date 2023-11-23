package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.ChapterDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.ChaptersRepository;
import hust.project.gioimon.gm_stories.service.service.IChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChapterServiceImpl implements IChapterService {
    private final ChaptersRepository chaptersRepository;
    public Page<ChapterDTO> getAllChapters(long storyId, int page, int size){
        return chaptersRepository.getListChaptersPagination(storyId, page, size);
    }

}
