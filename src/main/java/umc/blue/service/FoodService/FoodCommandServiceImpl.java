package umc.blue.service.FoodService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.repository.FoodRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCommandServiceImpl implements FoodCommandService{
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Boolean existsFoodById(Long id) {
        return foodRepository.existsById(id);
    }
}
