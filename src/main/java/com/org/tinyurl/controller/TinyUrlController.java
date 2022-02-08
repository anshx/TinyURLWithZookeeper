package com.org.tinyurl.controller;

import com.org.tinyurl.exception.NodeNotFoundException;
import com.org.tinyurl.service.TinyURLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TinyUrlController {

    @Autowired
    private TinyURLService tinyURLService;

    @GetMapping("/tinyURL")
    public ResponseEntity<String> getTinyUrl(@RequestParam("originalURL") String originalURL) {
        String ans = "";
        try {
            ans = "http://tinyURL.com/" + tinyURLService.getTinyURL(originalURL);
        }catch (NodeNotFoundException ex) {
            log.error("Error occured while getting node info..");
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body(ans);
    }

}
