package umc.blue.service.MyMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.domain.Member;
import umc.blue.domain.MyMission;
import umc.blue.domain.enums.MissionStatus;
import umc.blue.repository.MemberRepository;
import umc.blue.repository.MyMissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyMissionQueryServiceImpl implements MyMissionQueryService{
    private final MyMissionRepository myMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<MyMission> getMyMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<MyMission> MyMissionPage = myMissionRepository.findAllByMemberAndMissionStatus(member, MissionStatus.DOING, PageRequest.of(page, 10));
        return MyMissionPage;
    }
}
