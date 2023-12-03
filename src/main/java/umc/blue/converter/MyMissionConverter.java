package umc.blue.converter;

import umc.blue.domain.Member;
import umc.blue.domain.Mission;
import umc.blue.domain.MyMission;
import umc.blue.domain.enums.MissionStatus;
import umc.blue.web.dto.MyMissionResponseDTO;

import java.time.LocalDate;

public class MyMissionConverter {
    public static MyMissionResponseDTO.challengeMissionResultDTO toChallengeResultDTO(MyMission myMission){
        return MyMissionResponseDTO.challengeMissionResultDTO.builder()
                .myMissionId(myMission.getId())
                .createdAt(LocalDate.now())
                .build();
    }

    public static MyMission toMyMission(Mission mission, Member member){
        return MyMission.builder()
                .mission(mission)
                .member(member)
                .missionStatus(MissionStatus.DOING)
                .build();
    }
}
