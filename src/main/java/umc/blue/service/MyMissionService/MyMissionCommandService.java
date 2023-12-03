package umc.blue.service.MyMissionService;

import umc.blue.domain.MyMission;
import umc.blue.web.dto.MyMissionRequestDTO;

public interface MyMissionCommandService {

    MyMission challengeMission(MyMissionRequestDTO.challengeMission request);
}
