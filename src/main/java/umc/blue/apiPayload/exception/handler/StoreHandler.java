package umc.blue.apiPayload.exception.handler;

import umc.blue.apiPayload.code.BaseErrorCode;
import umc.blue.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
