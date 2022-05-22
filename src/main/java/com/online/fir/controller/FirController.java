package com.online.fir.controller;

import com.online.fir.constant.Constants;
import com.online.fir.exception.GenericException;
import com.online.fir.mapper.FirDetailMapper;
import com.online.fir.mapper.StationMapper;
import com.online.fir.model.dto.FirDetailDto;
import com.online.fir.model.dto.StationDto;
import com.online.fir.model.entity.FirDetail;
import com.online.fir.model.entity.Station;
import com.online.fir.service.FirService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.BASE_URL)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
@CrossOrigin("*")
public class FirController {

    FirService firService;

    @PostMapping(Constants.FIR)
    @ResponseStatus(HttpStatus.CREATED)
    public FirDetailDto createFIR(@RequestBody @Valid FirDetailDto firDetailDto) {
        try {
            log.info("Inside FirController : createFIR");
            FirDetail firDetail = FirDetailMapper.toEntity(firDetailDto);
            return FirDetailMapper.toApi(firService.createFIR(firDetail));
        }catch (Exception e)
        {
            throw new GenericException(HttpStatus.BAD_REQUEST, Constants.TECHNICAL_ERROR_MSG);
        }
    }

    @GetMapping(Constants.FIR)
    @ResponseStatus(HttpStatus.OK)
    public List<FirDetailDto> getAllFirDetails(){
        try {
            log.info("Inside FirController : getAllFirDetails");
            List<FirDetail> firDetails = firService.getAllFirDetails();
            return firDetails.stream().map(FirDetailMapper::toApi).collect(Collectors.toList());
        }catch (Exception e)
        {
            throw new GenericException(HttpStatus.BAD_REQUEST, Constants.TECHNICAL_ERROR_MSG);
        }
    }

    @GetMapping(Constants.FIR+Constants.GET_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public FirDetailDto getFirDetailById(@PathVariable String firId) {
        try {
            log.info("Inside FirController : getFirDetailById");
            return FirDetailMapper.toApi(firService.getFirDetailById(firId));
        } catch (Exception e) {
            throw new GenericException(HttpStatus.BAD_REQUEST, Constants.TECHNICAL_ERROR_MSG);
        }
    }
}
