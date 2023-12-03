package umc.blue.web.dto;

import lombok.Getter;
import umc.blue.validation.annotation.ExistStore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MissionRequestDTO {
    @Getter
    public static class addMissionDTO {
        @NotNull
        int missionPoint;
        @NotNull
        int missionPrice;
        @NotBlank
        String missionDate;
        @ExistStore
        Long storeId;
    }
}
