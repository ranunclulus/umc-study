package com.example.study.converter;

import com.example.study.domain.MemberMission;
import com.example.study.domain.Mission;
import com.example.study.domain.Review;
import com.example.study.web.dto.MyMissionResponseDTO;
import com.example.study.web.dto.MyReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MyMissionConverter {

    public static MyMissionResponseDTO.MissionPreViewDTO missionPreViewDTO(MemberMission mission){
        return MyMissionResponseDTO.MissionPreViewDTO.builder()
                .restaurantName(mission.getMission().getRestaurant().getTitle())
                .reward(mission.getMission().getReward())
                .status(mission.getMemberMissionStatus().toString())
                .closedAt(mission.getMission().getClosedAt().toLocalDate())
                .build();
    }
    public static MyMissionResponseDTO.MissionPreViewListDTO reviewPreViewListDTO(Page<MemberMission> missionList){

        List<MyMissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MyMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MyMissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
