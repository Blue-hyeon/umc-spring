package umc.blue.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.blue.apiPayload.code.BaseErrorCode;
import umc.blue.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;
    public ErrorReasonDTO getReason(){
        return this.code.getReason();
    }
    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
