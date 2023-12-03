package umc.blue.apiPayload.exception.handler;

import umc.blue.apiPayload.code.BaseErrorCode;
import umc.blue.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {
    public FoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
