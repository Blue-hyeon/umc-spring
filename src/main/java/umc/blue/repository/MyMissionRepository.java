package umc.blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.MyMission;

import java.util.Optional;

public interface MyMissionRepository extends JpaRepository<MyMission, Long> {

    Optional<MyMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
