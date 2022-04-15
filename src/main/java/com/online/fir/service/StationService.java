package com.online.fir.service;

import com.online.fir.model.entity.FirDetail;
import com.online.fir.model.entity.Station;
import com.online.fir.repository.StationRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        }catch (Exception e)
        {
            log.error("Exception occurred while saving station details :",e);
            throw e;
        }
        return station;
    }

    public List<Station> getAllStations(){
        List<Station> stations;
        try {
            stations = stationRepository.findAll();
            log.info("Station Details successfully fetched");
        }catch (Exception e)
        {
            log.error("Exception occurred while fetching Station details :",e);
            throw e;
        }
        return stations;
    }

    public Station getStationByName(String name){
        Station station;
        try {
            station = stationRepository.findByName(name);
            log.info("Station Details successfully fetched");
        }catch (Exception e)
        {
            log.error("Exception occurred while fetching Station details by name: {} : {}", e, name);
            throw e;
        }
        return station;
    }
}
