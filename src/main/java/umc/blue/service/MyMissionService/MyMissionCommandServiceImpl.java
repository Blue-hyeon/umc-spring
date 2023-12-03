package umc.blue.service.MyMispusionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.apiPayload.code.status.ErrorStatus;
import umc.blue.apiPayload.exception.handler.MissionHandler;
import umc.blue.converter.MyMissionConverter;
import umc.blue.domain.Member;
import umc.blue.domain.Mission;
import umc.blue.domain.MyMission;
import umc.blue.repository.MemberRepository;
import umc.blue.repository.MissionRepository;
import umc.blue.repository.MyMissionRepository;
import umc.blue.service.MyMissionService.MyMissionCommandService;
import umc.blue.web.dto.MyMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyMissionCommandServiceImpl implements MyMissionCommandService {
    private final MyMissionRepository myMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MyMission challengeMission(MyMissionRequestDTO.challengeMission request) {

        if(myMissionRepository.existsById(request.getMissionId())) {
            throw new MissionHandler(ErrorStatus.MY_MISSION_IS_EXIST);
        }

        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        Member member = memberRepository.findById(Long.valueOf(1)).orElseThrow();

        MyMission newMyMission = MyMissionConverter.toMyMission(mission, member);

        return myMissionRepository.save(newMyMission);
    }

}
