package com.example.perside.login.api;

/**
 * Created by perside on 11/28/17.
 */

public class Api {

    private static final String ROOT_URL = "http://192.168.88.81/Testvod/includes/api.php?apicall=";

    public static final String URL_REGISTER = ROOT_URL + "register";
    public static final String URL_READ_CHANNELS = ROOT_URL + "getchannelName";
    public static final String URL_READ_CATEGORY = ROOT_URL + "getCategoryname";
    public static final String URL_READ_MOVIE = ROOT_URL + "getCategorymovie";
    public static final String URL_READ_LOGIN = ROOT_URL + "login";

}
