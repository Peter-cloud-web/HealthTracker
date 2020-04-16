package com.moringa.healthtrackerapp.Network;

public class APIUtils {

    private APIUtils(){}

    public static final String BASE_URL = "https://hcts.herokuapp.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
