package umc.blue.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.domain.Member;
import umc.blue.domain.Review;
import umc.blue.domain.Store;
import umc.blue.repository.MemberRepository;
import umc.blue.repository.ReviewRepository;
import umc.blue.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Review> getUserReviewList(Long userId, Integer page) {
        Member member = memberRepository.findById(userId).get();

        Page<Review> UserPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return UserPage;
    }
}
