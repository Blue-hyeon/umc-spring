package umc.blue.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.apiPayload.code.status.ErrorStatus;
import umc.blue.apiPayload.exception.handler.FoodHandler;
import umc.blue.apiPayload.exception.handler.RegionHandler;
import umc.blue.converter.StoreConverter;
import umc.blue.domain.Region;
import umc.blue.domain.Store;
import umc.blue.repository.RegionRepository;
import umc.blue.repository.StoreRepository;
import umc.blue.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.addDTO request) {
        Region findRegion = regionRepository.findById(request.getRegionId()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, findRegion);

        return storeRepository.save(newStore);
    }
}
