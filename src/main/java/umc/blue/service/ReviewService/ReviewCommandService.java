package umc.blue.service.ReviewService;

import umc.blue.domain.Review;
import umc.blue.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.addReviewDTO request);
}
