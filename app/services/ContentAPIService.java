package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Image;
import org.springframework.stereotype.Service;

import java.io.*;

import java.util.Arrays;
import java.util.List;

@Service
public class ContentAPIService {

    public List<Image> readImages(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        return Arrays.asList(mapper.readValue(url, Image[].class));
    }
}
