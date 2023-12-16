package umc.blue.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.Member;
import umc.blue.domain.MyMission;
import umc.blue.domain.enums.MissionStatus;

import java.util.Optional;

public interface MyMissionRepository extends JpaRepository<MyMission, Long> {

    Optional<MyMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MyMission> findAllByMemberAndMissionStatus(Member member, MissionStatus missionStatus, PageRequest pageRequest);
}
