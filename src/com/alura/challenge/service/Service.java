package com.alura.challenge.service;

import com.alura.challenge.dto.Request;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Service {
    String url;

    public Service(){
        this.url = "https://v6.exchangerate-api.com/v6/"+System.getenv("API_KEY")+"/latest/";
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Request consult(String type_currency){
        Gson gson = new Gson();
        URI url_final = URI.create(this.url + type_currency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(url_final).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Error en la solicitud HTTP " + response.statusCode());
                return null;
            }
            Request reqDto = gson.fromJson(response.body(),Request.class);
            if (!"success".equals(reqDto.result())) {
                System.out.println("Error en la solicitud " + reqDto.result());
                return null;
            }
            return reqDto;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No encontre esa moneda");
        }
    }
}
