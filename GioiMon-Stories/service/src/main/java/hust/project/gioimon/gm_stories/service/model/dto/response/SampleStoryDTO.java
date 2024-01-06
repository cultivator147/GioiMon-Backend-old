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
public class SampleStoryDTO {
    private long id;
    private String title;
    private String link;
    private String picture;
    private Date lastUpdateDate;
    private long views;
    private long comments;
    private long loves;
    private List<ChapterDTO> chapters;
}
