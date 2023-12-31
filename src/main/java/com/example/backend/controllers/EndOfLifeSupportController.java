package com.example.backend.controllers;

import com.example.backend.clients.EndOfLifeClient;
import com.example.backend.domain.Software;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EndOfLifeSupportController {

    Logger logger = LoggerFactory.getLogger(EndOfLifeSupportController.class);

    @Autowired
    EndOfLifeClient endOfLifeClient;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("Health check method called");
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/all-products")
    public ResponseEntity<String[]> getAllProducts() {
        logger.info("accessed all products");
        return endOfLifeClient.getAllProducts();
    }

    @GetMapping("/single-cycle-details/{product}/{cycle}")
    public ResponseEntity<Software> getSingleCycleDetails(@PathVariable("product") String product, @PathVariable("cycle") String cycle) {
        logger.info("accessed getSingleCycleDetails");
        ResponseEntity<Software> singleCycleDetails = endOfLifeClient.getSingleCycleDetails(cycle, product);
        System.out.println(singleCycleDetails.getBody());
        return singleCycleDetails;
    }

    @GetMapping("/get-all-details/{product}")
    public ResponseEntity<List<Software>> getAllDetails(@PathVariable("product") String product) {
        logger.info("accessed all products by product id");
        return endOfLifeClient.getAllDetails(product);
    }

}
