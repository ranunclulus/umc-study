package com.example.study.apiPayload.exception.handler;

import com.example.study.apiPayload.code.BaseErrorCode;
import com.example.study.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {

    public RestaurantHandler(BaseErrorCode code) {
        super(code);
    }
}
