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
public class  DetailStoryDTO {
    private String id;
    private String title;
    private int contentType;
    private String introduction;
    private String gender;
    private long views;
    private long comments;
    private long loves;
    private int writingState;
    private Date lastUpdateDate;
    private long chapterQuantity;
    private List<ChapterDTO> chapters;
    private List<CategoryDTO> categories;
//    private List<AuthorDTO> authors;
}
