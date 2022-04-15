package com.online.fir.mapper;

import com.online.fir.model.dto.FirDetailDto;
import com.online.fir.model.dto.UserDto;
import com.online.fir.model.entity.FirDetail;
import com.online.fir.model.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static UserDto toApi(User user) {
        if (user == null)
            return null;
        else {
            return UserDto.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .phone(user.getPhone())
                    .password(user.getPassword()).build();
        }
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null)
            return null;
        else {
            return User.builder()
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .phone(userDto.getPhone())
                    .password(userDto.getPassword()).build();
        }
    }
}
