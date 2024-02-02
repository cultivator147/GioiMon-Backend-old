package hust.project.gioimon.adm_service.controllers;

import hust.project.gioimon.adm_client.model.ResponseData;
import hust.project.gioimon.adm_service.model.dto.request.Profile;
import hust.project.gioimon.adm_service.service.ProfileService;
import hust.project.gioimon.adm_service.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0/user/profile")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ProfileController {
    private final ProfileService profileService;
    @GetMapping("")
    public ResponseEntity<ResponseData<Profile>> login(@RequestHeader(name = "user_id") long userId){
        return BaseResponse.success(profileService.getProfile(userId));
    }
}
