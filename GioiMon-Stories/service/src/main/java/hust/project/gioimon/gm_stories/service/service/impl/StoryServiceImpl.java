package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.*;
import hust.project.gioimon.gm_stories.service.repository.jdbc.StoryRepository;
import hust.project.gioimon.gm_stories.service.service.CategoryService;
import hust.project.gioimon.gm_stories.service.service.ChapterService;
import hust.project.gioimon.gm_stories.service.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {
    private final StoryRepository storyRepository;
    private final CategoryService categoryService;
    private final ChapterService chapterService;
    private final AuthorService authorService;

    @Override
    public DetailStoryDTO getDetail(int storyId) {
        DetailStoryDTO detailStoryDTO =  storyRepository.get(storyId);
        detailStoryDTO.setCategories(categoryService.get(storyId));
        List<ChapterDTO> chapters = chapterService.getAll(storyId);
        detailStoryDTO.setChapters(chapters);
        AtomicLong views = new AtomicLong();
        chapters.forEach(c -> views.addAndGet(c.getViews()));
        detailStoryDTO.setViews(views.get());
        detailStoryDTO.setAuthors(authorService.get(storyId));
        return detailStoryDTO;
    }
    public String getTitle(long storyId){
        return storyRepository.getTitle(storyId);
    }
    public ContentDTO getContent(long storyId, long chapterNumber){
        String[] images =  chapterService.getImages(storyId, chapterNumber);
        String title = storyRepository.getTitle(storyId);
        long quantity = chapterService.getQuantity(storyId);
        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setChapterQuantity(quantity);
        contentDTO.setTitle(title);
        contentDTO.setImages(images);
        return contentDTO;
    }
    @Override
    public HistoryDTO logHistory(long userId, long storyId, long chapterNumber) {
        chapterService.plusView(storyId, chapterNumber);
        return storyRepository.logHistory(userId, storyId, chapterNumber);
    }
}
