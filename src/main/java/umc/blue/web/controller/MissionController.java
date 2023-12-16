package umc.blue.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.blue.apiPayload.ApiResponse;
import umc.blue.converter.MissionConverter;
import umc.blue.converter.ReviewConverter;
import umc.blue.domain.Mission;
import umc.blue.domain.Review;
import umc.blue.service.MissionService.MissionCommandService;
import umc.blue.service.MissionService.MissionQueryService;
import umc.blue.validation.annotation.CheckPage;
import umc.blue.validation.annotation.ExistStore;
import umc.blue.web.dto.MissionRequestDTO;
import umc.blue.web.dto.MissionResponseDTO;
import umc.blue.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.addMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.addMissionDTO request){
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }

    @GetMapping("/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하며, 페이징을 포함. query String으로 page 번호 필요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<MissionResponseDTO.getMissionListDTO> getMissionList(@ExistStore @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page) {

        Page<Mission> missionList = missionQueryService.getMissionList(storeId, page-1);

        return ApiResponse.onSuccess(MissionConverter.toGetMissionListDTO(missionList));
    }

}
