package umc.blue.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.blue.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MyMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class challengeMissionResultDTO{
        Long myMissionId;
        LocalDate createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getMyMissionDTO {
        Long myMissionId;
        int missionPoint;
        int missionPrice;
        String missionDate;
        String missionStatus;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getMyMissionListDTO {
        List<MyMissionResponseDTO.getMyMissionDTO> myMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class missionCompleteDTO {
        Long myMissionId;
        LocalDateTime updatedAt;
        MissionStatus missionStatus;
    }
}
