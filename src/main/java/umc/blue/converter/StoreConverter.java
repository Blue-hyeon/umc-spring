package umc.blue.converter;

import umc.blue.domain.Region;
import umc.blue.domain.Store;
import umc.blue.web.dto.StoreRequestDTO;
import umc.blue.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.addResultDTO toAddResultDTO(Store store) {
        return StoreResponseDTO.addResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addDTO request, Region region) {
        return Store.builder()
                .storeName(request.getStoreName())
                .storeAddress(request.getStoreAddress())
                .storePhone(request.getStorePhone())
                .openTime(request.getOpenTime())
                .closeTime(request.getCloseTime())
                .rating(5.0F)
                .region(region)
                .build();
    }

}
