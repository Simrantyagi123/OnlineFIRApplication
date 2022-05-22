package com.online.fir.controller;

import com.online.fir.constant.Constants;
import com.online.fir.exception.GenericException;
import com.online.fir.mapper.StationMapper;
import com.online.fir.model.dto.StationDto;
import com.online.fir.model.entity.Station;
import com.online.fir.service.StationService;
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
public class StationController {

    StationService stationService;

    @PostMapping(Constants.STATION)
    @ResponseStatus(HttpStatus.CREATED)
    public StationDto createStation(@RequestBody @Valid StationDto stationDto) {
        try {
            log.info("Inside StationController : createStation");
            Station station = StationMapper.toEntity(stationDto);
            return StationMapper.toApi(stationService.createStation(station));
        } catch (Exception e) {
            throw new GenericException(HttpStatus.BAD_REQUEST, Constants.TECHNICAL_ERROR_MSG);
        }
    }

    @GetMapping(Constants.STATION)
    @ResponseStatus(HttpStatus.OK)
    public List<StationDto> getAllStations() {
        try {
            log.info("Inside StationController : getAllStations");
            List<Station> stations = stationService.getAllStations();
            return stations.stream().map(StationMapper::toApi).collect(Collectors.toList());
        } catch (Exception e) {
            throw new GenericException(HttpStatus.BAD_REQUEST, Constants.TECHNICAL_ERROR_MSG);
        }
    }

    @GetMapping(Constants.STATION + Constants.GET_BY_NAME)
    @ResponseStatus(HttpStatus.OK)
    public StationDto getStationByName(@PathVariable String name) {
        log.info("Inside StationController : getStationById");
        return StationMapper.toApi(stationService.getStationByName(name));
    }
}
