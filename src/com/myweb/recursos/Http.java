/*
* Esta clase es solamente para devolver el body de una solicitud GET a un servidor http/https
* devuelve un string y estaría funcionando correctamente
* */

package com.myweb.recursos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {
    private String apiConnection = "";

    public Http() {
        this.apiConnection = ApiConn.ApiConect();
    }

    public String httpBodyResponse (){
        String body = "";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiConnection)).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            body = response.body();

        } catch ( IOException | InterruptedException e ){
            System.out.println(e.getMessage());
        }

        return body;
    }
    public int httpResponseBodyWithStatusCode (String body){
        int     statusCode = 0;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiConnection)).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            statusCode = response.statusCode();
            body = response.body();

        } catch ( IOException | InterruptedException e ){
            System.out.println(e.getMessage());
        }

        return statusCode;
    }


}
