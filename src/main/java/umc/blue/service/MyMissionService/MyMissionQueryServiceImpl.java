package umc.blue.service.MyMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.apiPayload.code.status.ErrorStatus;
import umc.blue.apiPayload.exception.handler.MissionHandler;
import umc.blue.apiPayload.exception.handler.StoreHandler;
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

    @Override
    @Transactional
    public MyMission completeMyMission(Long myMissionId, Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        MyMission myMission = myMissionRepository.findById(myMissionId).get();

        if (member.getId() != myMission.getMember().getId()) {
            throw new MissionHandler(ErrorStatus.MEMBER_IS_NOT_ALLOWED);
        }

        myMission.complete();

        return myMission;
    }
}
