package com.example.backend.clients;

import com.example.backend.domain.Software;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Service
public class EndOfLifeClient {


    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String[]> getAllProducts() {
       return restTemplate.getForEntity("https://endoflife.date/api/all.json", String[].class);
    }

    public ResponseEntity<Software> getSingleCycleDetails(String cycle, String product) {
        StringJoiner stringJoiner = new StringJoiner("/","", ".json");
        stringJoiner.add("https://endoflife.date/api")
                .add(product)
                .add(cycle);
        return restTemplate.getForEntity(stringJoiner.toString(), Software.class);
    }

    public ResponseEntity<List<Software>> getAllDetails(String product) {
        StringJoiner stringJoiner = new StringJoiner("/","", ".json");
        stringJoiner.add("https://endoflife.date/api")
                .add(product);
        ResponseEntity<Software[]> forEntity = restTemplate.getForEntity(stringJoiner.toString(), Software[].class);
        System.out.println(Arrays.toString(forEntity.getBody()));
        return new ResponseEntity<>(Arrays.asList(Objects.requireNonNull(forEntity.getBody())), HttpStatus.OK);
    }
}
