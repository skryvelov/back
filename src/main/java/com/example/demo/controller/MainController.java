package com.example.demo.controller;

import com.example.demo.service.FormatValidatorService;
import com.example.demo.service.impl.FormatValidatorServiceImpl;
import com.sun.xml.internal.ws.api.pipe.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private static final String CONTENT_TYPE = "Content-Type";

    @Autowired
    private FormatValidatorService formatValidatorService;

    @PostMapping(value = "/check", consumes={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public boolean isValidInputDataFormat(@RequestBody String data, @RequestHeader(CONTENT_TYPE) String contentType) {
        if (contentType.equals(MediaType.APPLICATION_JSON_VALUE)) {
            return formatValidatorService.isJsonFormatValid(data);
        }
        if (contentType.equals(MediaType.APPLICATION_XML_VALUE)) {
            return formatValidatorService.isXmlFormatValid(data);
        }
        return false;
    }


}
