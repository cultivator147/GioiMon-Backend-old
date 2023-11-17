package hust.project.gioimon.adm_service.service;

import hust.project.gioimon.adm_service.model.dto.request.LoginRequestDTO;
import hust.project.gioimon.adm_service.model.dto.response.LoginResponseDTO;
import hust.project.gioimon.adm_service.repository.jdbc.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserRepository userRepository;

    @Override
    public LoginResponseDTO register(LoginRequestDTO rqDTO) {
        String username = rqDTO.username;
        String password = rqDTO.password;
        return userRepository.addUser(username, password);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO rqDTO) {
        String username = rqDTO.username;
        String password = rqDTO.password;
        return userRepository.getUser(username, password);
    }
}
