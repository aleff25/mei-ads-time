package pt.iscte.mei.school.curricularunits.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.iscte.mei.school.curricularunits.model.CurricularUnit;
import pt.iscte.mei.school.curricularunits.repository.CurricularUnitRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class CurricularUnitApplicationService {

    private final CurricularUnitRepository repository;

    public List<CurricularUnit> searchAll() {
        log.info("Searching all curricular units");
        return repository.findAll();
    }

    public List<CurricularUnit> searchByName(String name) {
        log.info("Searching course by name = {}", name);

        return repository.findAllByNameLikeIgnoreCase(name);
    }

    public CurricularUnit saveIfNotExists(CurricularUnit curricularUnit) {
        String name = curricularUnit.getName();
        if (!repository.existsByName(name)) {
            return repository.save(curricularUnit);
        }

        return repository.findByName(name);
    }
}