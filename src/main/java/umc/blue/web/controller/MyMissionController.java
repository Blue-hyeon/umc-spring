package umc.blue.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.blue.apiPayload.ApiResponse;
import umc.blue.converter.MyMissionConverter;
import umc.blue.domain.MyMission;
import umc.blue.service.MyMissionService.MyMissionCommandService;
import umc.blue.service.MyMissionService.MyMissionQueryService;
import umc.blue.validation.annotation.CheckPage;
import umc.blue.web.dto.MyMissionRequestDTO;
import umc.blue.web.dto.MyMissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my-missions")
public class MyMissionController {
    private final MyMissionCommandService myMissionCommandService;
    private final MyMissionQueryService myMissionQueryService;

    @PostMapping("/")
    public ApiResponse<MyMissionResponseDTO.challengeMissionResultDTO> challengMission(@RequestBody @Valid MyMissionRequestDTO.challengeMission request){
        MyMission myMission = myMissionCommandService.challengeMission(request);

        return ApiResponse.onSuccess(MyMissionConverter.toChallengeResultDTO(myMission));
    }

    @GetMapping("/doing-missions")
    @Operation(summary = "특정 유저의 진행중인 미션 목록 조회 API", description = "특정 유저의 진행중인 미션 목록을 조회하며, 페이징을 포함. query String으로 page 번호 필요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<MyMissionResponseDTO.getMyMissionListDTO> getDoingMissionList(@RequestHeader Long memberId, @CheckPage @RequestParam("page") int page){

        Page<MyMission> myMissions = myMissionQueryService.getMyMissionList(memberId, page-1);

        return ApiResponse.onSuccess(MyMissionConverter.toMyMissionListDTO(myMissions));
    }

    @PatchMapping("/{myMissionId}/done")
    @Operation(summary = "미션 도전 완료 API", description = "미션을 완료하는 API. 완료할 미션 ID와 유저 ID 필요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MyMissionResponseDTO.missionCompleteDTO> completeMyMission(@RequestHeader Long memberId, @PathVariable("myMissionId") Long myMissionId){

        MyMission myMission = myMissionQueryService.completeMyMission(myMissionId, memberId);

        return ApiResponse.onSuccess(MyMissionConverter.toMissionCompleteDTO(myMission));
    }
}
