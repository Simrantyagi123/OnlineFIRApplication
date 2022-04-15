package com.online.fir.service;

import com.online.fir.model.entity.Station;
import com.online.fir.model.entity.User;
import com.online.fir.repository.StationRepository;
import com.online.fir.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Slf4j
public class UserService {
    UserRepository userRepository;

    public User signUp(User user) {
        try {
            userRepository.insert(user);
            log.info("User Details successfully saved");
        }catch (Exception e)
        {
            log.error("Exception occurred while saving user details :",e);
            throw e;
        }
        return user;
    }
}
