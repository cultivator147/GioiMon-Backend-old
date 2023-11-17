package hust.project.gioimon.adm_service.service;

import hust.project.gioimon.adm_service.model.dto.request.LoginRequestDTO;
import hust.project.gioimon.adm_service.model.dto.response.LoginResponseDTO;

public interface AuthenticationService {
    LoginResponseDTO login(LoginRequestDTO rqDTO);
    LoginResponseDTO register(LoginRequestDTO rqDTO);

}
