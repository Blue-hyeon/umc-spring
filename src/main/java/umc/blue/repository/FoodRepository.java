package umc.blue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.blue.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
