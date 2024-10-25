package com.myweb.recursos;

public class ApiConn {
    private static String apiKey = "18bb35e7c2325903b5ec1158";
    private static String apiWeb = "https://v6.exchangerate-api.com/v6/";
    private static String apiVersion = "latest";
    private static String baseCode = "USD";

    public static String ApiConect (){
        return apiWeb + apiKey + "/" + apiVersion + "/" + baseCode;
    }










}
