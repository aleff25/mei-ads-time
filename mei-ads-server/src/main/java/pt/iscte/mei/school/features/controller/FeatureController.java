package pt.iscte.mei.school.features.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.mei.school.features.application.FeatureApplicationService;
import pt.iscte.mei.school.features.model.Feature;

import java.util.List;

@RestController
@RequestMapping(path = "/features")
public class FeatureController {

    private FeatureApplicationService service;

    @GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public List<Feature> getAll() {
        return service.searchAll();
    }

}
