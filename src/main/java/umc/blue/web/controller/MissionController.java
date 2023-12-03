package umc.blue.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.blue.apiPayload.ApiResponse;
import umc.blue.converter.MissionConverter;
import umc.blue.domain.Mission;
import umc.blue.service.MissionService.MissionCommandService;
import umc.blue.web.dto.MissionRequestDTO;
import umc.blue.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.addMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.addMissionDTO request){
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }
}
