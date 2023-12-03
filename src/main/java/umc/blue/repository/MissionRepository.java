package umc.blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
