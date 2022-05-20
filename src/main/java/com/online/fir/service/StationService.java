package com.online.fir.service;

import com.online.fir.constant.Constants;
import com.online.fir.model.entity.Station;
import com.online.fir.repository.StationRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Slf4j
public class StationService {
    StationRepository stationRepository;

    public Station createStation(Station station) {
        try {
            stationRepository.insert(station);
            log.info("Station Details successfully saved");
        } catch (Exception e) {
            log.error("Exception occurred while saving station details :", e);
            throw e;
        }
        return station;
    }

    public List<Station> getAllStations() {
        List<Station> stations;
        try {
            stations = stationRepository.findAll();
            log.info("Station Details successfully fetched");
        } catch (Exception e) {
            log.error("Exception occurred while fetching Station details :", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return stations;
    }

    public Station getStationByName(String name) {
        Station station;
        station = stationRepository.findByName(name);
        log.info("Station Details successfully fetched");
        if (Objects.isNull(station))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.STATION_NOT_FOUND);
        return station;
    }
}
