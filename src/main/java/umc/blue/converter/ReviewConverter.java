package umc.blue.converter;

import umc.blue.domain.Member;
import umc.blue.domain.Review;
import umc.blue.domain.Store;
import umc.blue.web.dto.ReviewRequestDTO;
import umc.blue.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.addReviewDTO toAddReviewDTO(Review review){
        return ReviewResponseDTO.addReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.addReviewDTO request, Member member, Store store){
        return Review.builder()
                .reviewContent(request.getReviewContent())
                .reviewStar(request.getReviewStar())
                .member(member)
                .store(store)
                .build();
    }
}
