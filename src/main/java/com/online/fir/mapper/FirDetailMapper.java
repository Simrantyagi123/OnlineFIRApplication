package com.online.fir.mapper;

import com.online.fir.model.dto.FirDetailDto;
import com.online.fir.model.dto.StationDto;
import com.online.fir.model.entity.FirDetail;
import com.online.fir.model.entity.Station;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FirDetailMapper {
    public static FirDetailDto toApi(FirDetail firDetail) {
        if (firDetail == null)
            return null;
        else {
            return FirDetailDto.builder()
                    .name(firDetail.getName())
                    .gender(firDetail.getGender())
                    .crimeDetails(firDetail.getCrimeDetails())
                    .complainerName(firDetail.getComplainerName())
                    .address(firDetail.getAddress())
                    .complainerPhone(firDetail.getComplainerPhone()).build();
        }
    }

    public static FirDetail toEntity(FirDetailDto firDetailDto) {
        if (firDetailDto == null)
            return null;
        else {
            return FirDetail.builder()
                    .name(firDetailDto.getName())
                    .gender(firDetailDto.getGender())
                    .crimeDetails(firDetailDto.getCrimeDetails())
                    .complainerName(firDetailDto.getComplainerName())
                    .address(firDetailDto.getAddress())
                    .complainerPhone(firDetailDto.getComplainerPhone()).build();
        }
    }
}
