package pt.iscte.mei.school.features.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.features.model.Feature;

public interface FeatureRepository extends JpaRepository<Feature, String> {

    boolean existsByName(String name);

    Feature findByName(String name);

}
