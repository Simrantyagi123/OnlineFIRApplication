package com.online.fir.mapper;

import com.online.fir.model.dto.StationDto;
import com.online.fir.model.entity.Station;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StationMapper {
    public static StationDto toApi(Station station) {
        if (station == null)
            return null;
        else {
            return StationDto.builder()
                    .name(station.getName())
                    .state(station.getState())
                    .address(station.getAddress())
                    .district(station.getDistrict())
                    .inchargeName(station.getInchargeName())
                    .phone(station.getPhone()).build();
        }
    }

    public static Station toEntity(StationDto stationDto) {
        if (stationDto == null)
            return null;
        else {
            return Station.builder()
                    .name(stationDto.getName())
                    .state(stationDto.getState())
                    .address(stationDto.getAddress())
                    .district(stationDto.getDistrict())
                    .inchargeName(stationDto.getInchargeName())
                    .phone(stationDto.getPhone()).build();
        }
    }
}
