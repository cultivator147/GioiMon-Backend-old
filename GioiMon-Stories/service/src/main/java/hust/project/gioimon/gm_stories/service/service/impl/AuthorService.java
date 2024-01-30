package hust.project.gioimon.gm_stories.service.service.impl;

import hust.project.gioimon.gm_stories.service.model.dto.response.AuthorDTO;
import hust.project.gioimon.gm_stories.service.repository.jdbc.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    public List<AuthorDTO> get(long storyId){
        return authorRepository.getAuthors(storyId);
    }
}
