package umc.blue.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.blue.apiPayload.code.status.ErrorStatus;
import umc.blue.apiPayload.exception.handler.StoreHandler;
import umc.blue.converter.MissionConverter;
import umc.blue.domain.Mission;
import umc.blue.domain.Store;
import umc.blue.repository.MissionRepository;
import umc.blue.repository.StoreRepository;
import umc.blue.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.addMissionDTO request) {
        Long random = System.currentTimeMillis();
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, random, store);

        return missionRepository.save(newMission);
    }
}
