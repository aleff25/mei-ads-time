package pt.iscte.mei.school.curricularunits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.mei.school.curricularunits.application.CurricularUnitApplicationService;
import pt.iscte.mei.school.curricularunits.model.CurricularUnit;

import java.util.List;

@RestController
@RequestMapping(path = "/curricular-units")
public class CurricularUnitController {

    @Autowired
    private CurricularUnitApplicationService service;

    @GetMapping()
    public ResponseEntity<List<CurricularUnit>> findAll() {
        List<CurricularUnit> curricularUnits = service.searchAll();

        return ResponseEntity.ok().body(curricularUnits);
    }

}
