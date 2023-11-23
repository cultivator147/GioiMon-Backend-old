package hust.project.gioimon.gm_stories.client.model;

import lombok.Data;

import java.util.List;
@Data
public class BaseResultSelect<T> {
    private Long count;
    private List<T> listData;
}
