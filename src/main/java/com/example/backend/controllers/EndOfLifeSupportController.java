package com.example.backend.controllers;

import com.example.backend.clients.EndOfLifeClient;
import com.example.backend.domain.Software;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EndOfLifeSupportController {

    @Autowired
    EndOfLifeClient endOfLifeClient;

    @GetMapping("/all-products")
    public ResponseEntity<String[]> getAllProducts() {
        return endOfLifeClient.getAllProducts();
    }

    @GetMapping("/single-cycle-details/{product}/{cycle}")
    public ResponseEntity<Software> getSingleCycleDetails(@PathVariable("product") String product, @PathVariable("cycle") String cycle) {
        ResponseEntity<Software> singleCycleDetails = endOfLifeClient.getSingleCycleDetails(cycle, product);
        System.out.println(singleCycleDetails.getBody());
        return singleCycleDetails;
    }

    @GetMapping("/get-all-details/{product}")
    public ResponseEntity<List<Software>> getAllDetails(@PathVariable("product") String product) {
        return endOfLifeClient.getAllDetails(product);
    }

}
