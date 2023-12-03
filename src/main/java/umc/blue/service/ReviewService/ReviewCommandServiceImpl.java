package umc.blue.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.apiPayload.code.status.ErrorStatus;
import umc.blue.apiPayload.exception.handler.StoreHandler;
import umc.blue.converter.ReviewConverter;
import umc.blue.domain.Member;
import umc.blue.domain.Review;
import umc.blue.domain.Store;
import umc.blue.repository.MemberRepository;
import umc.blue.repository.ReviewRepository;
import umc.blue.repository.StoreRepository;
import umc.blue.web.dto.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.addReviewDTO request) {
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Member member = memberRepository.findById(Long.valueOf(1)).orElseThrow();
        Review newReview = ReviewConverter.toReview(request, member, store);

        return reviewRepository.save(newReview);
    }


}
