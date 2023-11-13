package hust.project.gioimon.gm_administrator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckPermissionDTO implements Serializable {
    private boolean result;
}
