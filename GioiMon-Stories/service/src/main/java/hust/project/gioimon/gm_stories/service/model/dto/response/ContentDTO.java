package hust.project.gioimon.gm_stories.service.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentDTO {
    private String title;
    private String chapterName;
    private String[] images;
    private long chapterQuantity;
}
