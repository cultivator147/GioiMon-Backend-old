package hust.project.gioimon.gm_stories.controllers;

import hust.project.gioimon.gm_stories.model.ResponseData;
import hust.project.gioimon.gm_stories.utils.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/public")
public class DemoController {
    @GetMapping(value = "/demo")
    public ResponseEntity<ResponseData<Object>> demo(){
        return BaseResponse.success(new ArrayList<>());
    }

}
