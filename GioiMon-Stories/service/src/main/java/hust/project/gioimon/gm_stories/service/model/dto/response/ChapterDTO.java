package hust.project.gioimon.gm_stories.service.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterDTO {
    private String chapterNumber;
    private String chapterName;
    private String picture;
    private String[] content;
    private Date updateDate;
    private long views;
    private int scope;
}

