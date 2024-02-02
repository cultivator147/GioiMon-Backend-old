package hust.project.gioimon.adm_service.controllers;

import hust.project.gioimon.adm_client.model.ResponseData;
import hust.project.gioimon.adm_service.model.dto.request.LoginRequestDTO;
import hust.project.gioimon.adm_service.model.dto.response.LoginResponseDTO;
import hust.project.gioimon.adm_service.service.AuthenticationService;
import hust.project.gioimon.adm_service.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<ResponseData<LoginResponseDTO>> login(@RequestBody LoginRequestDTO rqDTO){
        return BaseResponse.success(authenticationService.login(rqDTO));
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseData<LoginResponseDTO>> register(@RequestBody  LoginRequestDTO rqDTO){
        return BaseResponse.success(authenticationService.register(rqDTO));

    }

}
