package umc.blue.web.dto;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import umc.blue.domain.enums.Gender;
import umc.blue.domain.enums.MemberStatus;
import umc.blue.validation.annotation.ExistCategories;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDTO {
        String nickname;
        String gender;
        LocalDate birth;
        String phone;
        String userAddress;
        @ExistCategories
        List<Long> preferList;
    }
}
