package umc.blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
