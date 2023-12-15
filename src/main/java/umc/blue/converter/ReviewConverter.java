package umc.blue.converter;

import org.springframework.data.domain.Page;
import umc.blue.domain.Member;
import umc.blue.domain.Review;
import umc.blue.domain.Store;
import umc.blue.web.dto.ReviewRequestDTO;
import umc.blue.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .reviewContent(review.getReviewContent())
                .reviewStar(review.getReviewStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .memberName(review.getMember().getNickname())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList) {

        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .reviewList(reviewPreviewDTOList)
                .listSize(reviewPreviewDTOList.size())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .isFirst(reviewList.isLast())
                .isLast(reviewList.isFirst())
                .build();
    }
}
