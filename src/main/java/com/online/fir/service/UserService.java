package com.online.fir.service;

import com.online.fir.constant.Constants;
import com.online.fir.model.entity.User;
import com.online.fir.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

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
        } catch (Exception e) {
            log.error("Exception occurred while saving user details :", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return user;
    }

    public User login(User user) {
        User userDetail = userRepository.findByPhone(user.getPhone());
        if (Objects.nonNull(userDetail) && user.getPassword().equals(userDetail.getPassword())) {
            log.info("User is present");
            return userDetail;
        } else {
            log.info("Username/Password is not correct");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.USER_NOT_FOUND);
        }
    }
}
