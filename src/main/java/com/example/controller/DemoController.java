package com.example.controller;

import com.example.model.Request;
import com.example.model.Response;
import com.example.service.DemoService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/jsonNode")
public class DemoController {

    @Autowired
    DemoService demoService;

    @PostMapping()
    public JsonNode index(@RequestBody JsonNode jsonNode) {
        log.info("Received JSON ={}", jsonNode);
        return demoService.index(jsonNode);

    }

    @PostMapping(value = "/submitRequest")
    public Response processRequest(@RequestBody Request request) {
        log.info("Request ={}", request);
        return demoService.processRequest();
    }
}
