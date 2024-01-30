package hust.project.gioimon.gm_stories.service.controllers;

import hust.project.gioimon.gm_stories.client.model.ResponseData;
import hust.project.gioimon.gm_stories.service.model.dto.response.ContentDTO;
import hust.project.gioimon.gm_stories.service.service.ChapterService;
import hust.project.gioimon.gm_stories.service.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0/chapter/")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ChapterController {
    private final ChapterService chapterService;

}
