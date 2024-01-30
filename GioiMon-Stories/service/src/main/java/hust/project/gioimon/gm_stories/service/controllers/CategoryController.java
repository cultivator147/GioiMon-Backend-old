package hust.project.gioimon.gm_stories.service.controllers;

import hust.project.gioimon.gm_stories.client.model.ResponseData;
import hust.project.gioimon.gm_stories.service.constant.FilterConstants;
import hust.project.gioimon.gm_stories.service.model.dto.response.CategoryDTO;
import hust.project.gioimon.gm_stories.service.model.dto.response.SampleStoryDTO;
import hust.project.gioimon.gm_stories.service.service.CategoryService;
import hust.project.gioimon.gm_stories.service.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0/category")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping()
    public ResponseEntity<ResponseData<List<CategoryDTO>>> getAll(

    ) {
        return BaseResponse.success(categoryService.getAll());
    }
}
