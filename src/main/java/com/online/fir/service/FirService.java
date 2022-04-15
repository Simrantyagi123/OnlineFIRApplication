package com.online.fir.service;

import com.online.fir.model.entity.FirDetail;
import com.online.fir.model.entity.Station;
import com.online.fir.repository.FirDetailRepository;
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
public class FirService {
    FirDetailRepository firDetailRepository;

    public FirDetail createFIR(FirDetail firDetail) {
        try {
            firDetailRepository.insert(firDetail);
            log.info("FIR Details successfully saved");
        }catch (Exception e)
        {
            log.error("Exception occurred while saving FIR details :",e);
            throw e;
        }
        return firDetail;
    }

    public List<FirDetail> getAllFirDetails(){
        List<FirDetail> firDetails;
        try {
            firDetails = firDetailRepository.findAll();
            log.info("FIR Details successfully fetched");
        }catch (Exception e)
        {
            log.error("Exception occurred while fetching FIR details :",e);
            throw e;
        }
        return firDetails;
    }

    public FirDetail getFirDetailById(String firId){
        FirDetail firDetail;
        try {
            firDetail = firDetailRepository.findByFirId(firId);
            log.info("FIR Details successfully fetched");
        }catch (Exception e)
        {
            log.error("Exception occurred while fetching FIR details by id: {} : {}", e, firId);
            throw e;
        }
        return firDetail;
    }
}
