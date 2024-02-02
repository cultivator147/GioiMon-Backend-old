package hust.project.gioimon.adm_service.service;

import hust.project.gioimon.adm_service.model.dto.request.Profile;
import hust.project.gioimon.adm_service.repository.jdbc.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    public Profile getProfile(long userId){
        return profileRepository.getProfile(userId);
    }
}
