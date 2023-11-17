package hust.project.gioimon.adm_service.controllers;

import hust.project.gioimon.adm_client.model.ResponseData;
import hust.project.gioimon.adm_service.utils.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/public")
public class DemoController {
    @GetMapping(value = "/demo")
//    @CheckPermissionAnno(uri = "/public/demo")
    public ResponseEntity<ResponseData<Object>> demo(){
        return BaseResponse.success(new ArrayList<>());
    }

}
