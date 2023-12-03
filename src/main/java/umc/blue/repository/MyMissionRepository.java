package umc.blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.MyMission;

public interface MyMissionRepository extends JpaRepository<MyMission, Long> {
}
