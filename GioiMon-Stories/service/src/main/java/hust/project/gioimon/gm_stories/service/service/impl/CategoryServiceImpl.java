package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.CategoryDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.CategoryRepository;
import hust.project.gioimon.gm_stories.service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryDTO> get(long storyId) {
        return categoryRepository.getCategory(storyId);
    }

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.getAll();
    }
}
