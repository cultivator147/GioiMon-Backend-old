package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.ChapterDTO;
import hust.project.gioimon.gm_stories.service.model.dto.response.ContentDTO;
import hust.project.gioimon.gm_stories.service.model.dto.response.DetailStoryDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.StoryRepository;
import hust.project.gioimon.gm_stories.service.service.CategoryService;
import hust.project.gioimon.gm_stories.service.service.ChapterService;
import hust.project.gioimon.gm_stories.service.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setTitle(title);
        contentDTO.setImages(images);
        return contentDTO;
    }
}
