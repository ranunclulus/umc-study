package com.example.study.converter;

import com.example.study.web.dto.TempRequest;
import com.example.study.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test")
                .build();
    }
}
