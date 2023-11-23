package umc.blue.apiPayload.exception.handler;

import umc.blue.apiPayload.code.BaseErrorCode;
import umc.blue.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
