package hust.project.gioimon.gm_stories.service.service;

import hust.project.gioimon.gm_stories.service.model.dto.response.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDTO> get(long storyId);
    List<CategoryDTO> getAll();
}
