package umc.blue.service.MyMissionService;

import org.springframework.data.domain.Page;
import umc.blue.domain.MyMission;

public interface MyMissionQueryService {
    Page<MyMission> getMyMissionList(Long memberId, Integer page);
}
