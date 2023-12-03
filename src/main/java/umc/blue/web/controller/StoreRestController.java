package umc.blue.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.blue.apiPayload.ApiResponse;
import umc.blue.converter.StoreConverter;
import umc.blue.domain.Store;
import umc.blue.service.StoreService.StoreCommandService;
import umc.blue.web.dto.StoreRequestDTO;
import umc.blue.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.addResultDTO> add(@RequestBody @Valid StoreRequestDTO.addDTO request){
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }
}
