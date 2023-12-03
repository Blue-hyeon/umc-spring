package umc.blue.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.blue.apiPayload.ApiResponse;
import umc.blue.converter.ReviewConverter;
import umc.blue.domain.Review;
import umc.blue.service.ReviewService.ReviewCommandService;
import umc.blue.web.dto.ReviewRequestDTO;
import umc.blue.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.addReviewDTO> add(@RequestBody @Valid ReviewRequestDTO.addReviewDTO request){
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewDTO(review));
    }

}
