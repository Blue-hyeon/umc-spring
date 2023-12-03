package umc.blue.service.StoreService;

import umc.blue.domain.Store;
import umc.blue.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store addStore(StoreRequestDTO.addDTO request);
}
