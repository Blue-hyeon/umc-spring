package umc.blue.converter;

import umc.blue.domain.Member;
import umc.blue.domain.enums.Gender;
import umc.blue.domain.enums.MemberStatus;
import umc.blue.web.dto.MemberRequestDTO;
import umc.blue.web.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request){

        Gender gender = null;

        switch (request.getGender()){
            case "MALE":
                gender = Gender.MALE;
                break;
            case "FEMALE":
                gender = Gender.FEMALE;
                break;
            default:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .nickname(request.getNickname())
                .userAddress(request.getUserAddress())
                .birth(request.getBirth())
                .phone(request.getPhone())
                .gender(gender)
                .point(0)
                .status(MemberStatus.valueOf("ACTIVE"))
                .memberPreferList(new ArrayList<>())
                .build();

    }
}
