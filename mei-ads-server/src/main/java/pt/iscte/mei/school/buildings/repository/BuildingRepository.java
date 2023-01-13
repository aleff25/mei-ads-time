package pt.iscte.mei.school.buildings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.mei.school.buildings.model.Building;

public interface BuildingRepository extends JpaRepository<Building, String> {
}
