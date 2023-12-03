package umc.blue.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.blue.apiPayload.ApiResponse;
import umc.blue.converter.MyMissionConverter;
import umc.blue.domain.MyMission;
import umc.blue.service.MyMissionService.MyMissionCommandService;
import umc.blue.web.dto.MyMissionRequestDTO;
import umc.blue.web.dto.MyMissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my-missions")
public class MyMissionController {
    private final MyMissionCommandService myMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MyMissionResponseDTO.challengeMissionResultDTO> challengMission(@RequestBody @Valid MyMissionRequestDTO.challengeMission request){
        MyMission myMission = myMissionCommandService.challengeMission(request);

        return ApiResponse.onSuccess(MyMissionConverter.toChallengeResultDTO(myMission));
    }
}
