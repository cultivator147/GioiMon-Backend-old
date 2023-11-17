package hust.project.gioimon.adm_service.model.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    public String username;
    public String password;
}
