package com.example.service;

import com.example.model.Response;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {

    public JsonNode index(JsonNode jsonNode){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<JsonNode> request = new HttpEntity<>(jsonNode);

        String url = "http://localhost:8080/jsonNode/submitRequest";
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.POST, request, JsonNode.class);
        return response.getBody();
    }

    public Response processRequest() {
        Response response = new Response();
        response.setResponseMessage("Data received Successfully");
        response.setResponseStatus("Success");
        return response;
    }
}
