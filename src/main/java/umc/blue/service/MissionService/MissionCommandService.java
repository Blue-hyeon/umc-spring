package umc.blue.service.MissionService;

import umc.blue.domain.Mission;
import umc.blue.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(MissionRequestDTO.addMissionDTO request);
}
