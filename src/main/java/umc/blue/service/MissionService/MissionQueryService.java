package umc.blue.service.MissionService;

import org.springframework.data.domain.Page;
import umc.blue.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMissionList(Long storeId, Integer page);
}
