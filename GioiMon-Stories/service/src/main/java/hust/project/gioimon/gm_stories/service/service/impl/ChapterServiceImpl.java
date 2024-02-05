package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.ChapterDTO;
import hust.project.gioimon.gm_stories.service.model.dto.response.ContentDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.ChaptersRepository;
import hust.project.gioimon.gm_stories.service.service.ChapterService;
import hust.project.gioimon.gm_stories.service.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChapterServiceImpl implements ChapterService {
    private final ChaptersRepository chaptersRepository;
    public Page<ChapterDTO> getPaginationChapters(long storyId, int page, int size){
        return chaptersRepository.getListChaptersPagination(storyId, page, size);
    }
    public List<ChapterDTO> getAll(long storyId){
        return chaptersRepository.getAll(storyId);
    }

    public String[] getImages(long storyId, long chapterNumber){
        return chaptersRepository.getImages(storyId, chapterNumber);
    }

    @Override
    public long getQuantity(long storyId) {
        return chaptersRepository.getQuantity(storyId);
    }
    public void plusView(long storyId, long chapterNumber){
        chaptersRepository.plusView(storyId, chapterNumber);
    }
}
