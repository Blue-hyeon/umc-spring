package umc.blue.converter;

import org.springframework.data.domain.Page;
import umc.blue.domain.Mission;
import umc.blue.domain.Store;
import umc.blue.web.dto.MissionRequestDTO;
import umc.blue.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.getMissionDTO toGetMissionDTO(Mission mission){
        return MissionResponseDTO.getMissionDTO.builder()
                .missionId(mission.getId())
                .missionPoint(mission.getMissionPoint())
                .missionPrice(mission.getMissionPrice())
                .missionDate(mission.getMissionDate())
                .identifier(mission.getIdentifier())
                .build();
    }

    public static MissionResponseDTO.getMissionListDTO toGetMissionListDTO(Page<Mission> missionList) {

    List<MissionResponseDTO.getMissionDTO> missionDTOList = missionList.stream()
                .map(MissionConverter::toGetMissionDTO).collect(Collectors.toList());

        return MissionResponseDTO.getMissionListDTO.builder()
                .missionList(missionDTOList)
                .listSize(missionDTOList.size())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .build();
    }
}
