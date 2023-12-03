package umc.blue.converter;

import umc.blue.domain.Mission;
import umc.blue.domain.Store;
import umc.blue.web.dto.MissionRequestDTO;
import umc.blue.web.dto.MissionResponseDTO;

import java.time.LocalDate;

public class MissionConverter {
    public static MissionResponseDTO.addMissionResultDTO toAddResultDTO(Mission mission){
        return MissionResponseDTO.addMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDate.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.addMissionDTO request, Long identifier, Store store){
        return Mission.builder()
                .missionPoint(request.getMissionPoint())
                .missionPrice(request.getMissionPrice())
                .missionDate(request.getMissionDate())
                .identifier(identifier)
                .store(store)
                .build();
    }
}
