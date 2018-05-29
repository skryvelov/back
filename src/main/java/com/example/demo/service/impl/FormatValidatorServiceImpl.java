package com.example.demo.service.impl;

import com.example.demo.service.FormatValidatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class FormatValidatorServiceImpl implements FormatValidatorService {

    public boolean isXmlFormatValid(String xml) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setContentHandler(new DefaultHandler());
            InputSource source = new InputSource(new ByteArrayInputStream(xml.getBytes()));
            parser.parse(source);
            return true;
        } catch (SAXException | IOException e) {
            return false;
        }
    }

    public boolean isJsonFormatValid(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
