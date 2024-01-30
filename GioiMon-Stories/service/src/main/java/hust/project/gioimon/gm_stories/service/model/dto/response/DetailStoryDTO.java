package hust.project.gioimon.gm_stories.service.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  DetailStoryDTO extends SampleStoryDTO{
    private int contentType;
    private String introduction;
    private String gender;
    private String writingState;
    private long chapterQuantity;
    private List<CategoryDTO> categories;
    private List<AuthorDTO> authors;
}
