package umc.blue.web.dto;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import umc.blue.domain.enums.Gender;
import umc.blue.domain.enums.MemberStatus;
import umc.blue.validation.annotation.ExistCategories;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDTO {
        @NotBlank
        String nickname;
        @NotNull
        String gender;
        @NotNull
        LocalDate birth;
        @Size(min=11, max=12)
        String phone;
        @Size(min=5, max=70)
        String userAddress;
        @ExistCategories
        List<Long> preferList;
    }
}
