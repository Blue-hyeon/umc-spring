package umc.blue.web.dto;

import lombok.Getter;
import umc.blue.validation.annotation.ExistStore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReviewRequestDTO {
    @Getter
    public static class addReviewDTO {
        @Size(min=1, max=500)
        String reviewContent;
        @NotNull
        int reviewStar;
        @NotNull
        Long memberId;
        @ExistStore
        Long storeId;
    }
}
