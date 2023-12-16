package umc.blue.converter;

import org.springframework.data.domain.Page;
import umc.blue.domain.Member;
import umc.blue.domain.Mission;
import umc.blue.domain.MyMission;
import umc.blue.domain.enums.MissionStatus;
import umc.blue.web.dto.MyMissionResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MyMissionResponseDTO.getMyMissionDTO toMyMissionDTO(MyMission myMission){
        return MyMissionResponseDTO.getMyMissionDTO.builder()
                .myMissionId(myMission.getId())
                .missionPoint(myMission.getMission().getMissionPoint())
                .missionPrice(myMission.getMission().getMissionPrice())
                .missionDate(myMission.getMission().getMissionDate().toString())
                .missionStatus(myMission.getMissionStatus().toString())
                .build();
    }

    public static MyMissionResponseDTO.getMyMissionListDTO toMyMissionListDTO(Page<MyMission> myMissionList) {

        List<MyMissionResponseDTO.getMyMissionDTO> myMissionDTOList = myMissionList.stream()
                .map(MyMissionConverter::toMyMissionDTO).collect(Collectors.toList());

        return MyMissionResponseDTO.getMyMissionListDTO.builder()
                .myMissionList(myMissionDTOList)
                .listSize(myMissionDTOList.size())
                .totalPage(myMissionList.getTotalPages())
                .totalElements(myMissionList.getTotalElements())
                .isFirst(myMissionList.isFirst())
                .isLast(myMissionList.isLast())
                .build();
    }

    public static MyMissionResponseDTO.missionCompleteDTO toMissionCompleteDTO(MyMission myMission){
        return MyMissionResponseDTO.missionCompleteDTO.builder()
                .myMissionId(myMission.getId())
                .updatedAt(myMission.getUpdatedAt())
                .missionStatus(myMission.getMissionStatus())
                .build();
    }
}
