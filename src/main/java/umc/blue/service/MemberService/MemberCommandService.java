package umc.blue.service.MemberService;

import umc.blue.domain.Member;
import umc.blue.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
