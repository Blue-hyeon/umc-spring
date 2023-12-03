package umc.blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
