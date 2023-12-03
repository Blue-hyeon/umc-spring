package umc.blue.web.dto;

import lombok.Getter;
import umc.blue.validation.annotation.ExistMyMission;

import javax.validation.constraints.NotNull;

public class MyMissionRequestDTO {
    @Getter
    public static class challengeMission {
        @NotNull
        Long memberId;
        @ExistMyMission
        Long missionId;
    }
}
