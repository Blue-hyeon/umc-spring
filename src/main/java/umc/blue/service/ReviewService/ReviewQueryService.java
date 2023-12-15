package umc.blue.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.blue.domain.Review;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long storeId, Integer page);
}
