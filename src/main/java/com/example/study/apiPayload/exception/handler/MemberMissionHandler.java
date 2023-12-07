package com.example.study.apiPayload.exception.handler;

import com.example.study.apiPayload.code.BaseErrorCode;
import com.example.study.apiPayload.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {

    public MemberMissionHandler(BaseErrorCode code) {
        super(code);
    }
}
