package com.online.fir.constant;

public final class Constants {
    private Constants() {
    }
    public static final String BASE_URL = "/fir/api";
    public static final String STATION = "/station";
    public static final String USER = "/user";
    public static final String LOGIN = "/login";
    public static final String FIR = "/firdetail";
    public static final String GET_BY_NAME = "/{name}";
    public static final String GET_BY_ID = "/{firId}";
    public static final String TECHNICAL_ERROR_MSG = "We are facing some technical issue. Please try after some time";
    public static final String USER_NOT_FOUND = "Username/Password is not correct";
    public static final String STATION_NOT_FOUND = "There is no station with this name";
}
