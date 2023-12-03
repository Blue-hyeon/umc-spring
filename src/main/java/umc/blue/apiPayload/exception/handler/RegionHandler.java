package umc.blue.apiPayload.exception.handler;

import umc.blue.apiPayload.code.BaseErrorCode;
import umc.blue.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
