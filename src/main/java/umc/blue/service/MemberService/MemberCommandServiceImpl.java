package umc.blue.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.apiPayload.code.status.ErrorStatus;
import umc.blue.apiPayload.exception.handler.FoodHandler;
import umc.blue.converter.MemberConverter;
import umc.blue.converter.MemberPreferConverter;
import umc.blue.domain.Food;
import umc.blue.domain.Member;
import umc.blue.domain.MemberPrefer;
import umc.blue.repository.FoodRepository;
import umc.blue.repository.MemberRespository;
import umc.blue.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRespository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);
        List<Food> foodList = request.getPreferList().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodList);
        memberPreferList.forEach(memberPrefer -> {
            memberPrefer.setMember(newMember);
        });

        return memberRepository.save(newMember);
    }
}
