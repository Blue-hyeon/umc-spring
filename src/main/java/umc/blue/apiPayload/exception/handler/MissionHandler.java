package umc.blue.apiPayload.exception.handler;

import umc.blue.apiPayload.code.BaseErrorCode;
import umc.blue.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
