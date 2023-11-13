package hust.project.gioimon.gm_administrator.controllers;

import hust.project.gioimon.gm_administrator.check_permission.CheckPermissionAnno;
import hust.project.gioimon.gm_administrator.model.ResponseData;
import hust.project.gioimon.gm_administrator.utils.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/public")
public class DemoController {
    @GetMapping(value = "/demo")
    @CheckPermissionAnno(uri = "https://public/demo")
    public ResponseEntity<ResponseData<Object>> demo(){
        return BaseResponse.success(new ArrayList<>());
    }

}
