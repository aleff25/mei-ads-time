package pt.iscte.mei.school.features.application;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pt.iscte.mei.school.features.model.Feature;
import pt.iscte.mei.school.features.repository.FeatureRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class FeatureApplicationService {

    private final FeatureRepository repository;

    public List<Feature> searchAll() {
        log.info("Searching all features");

        return repository.findAll();
    }

    public Feature saveIfNotExists(Feature feature) {
        String name = feature.getName();
        if (!repository.existsByName(name)) {
            return repository.save(feature);
        }

        return repository.findByName(name);
    }
}
