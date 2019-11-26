package com.otm.controller;

import com.otm.model.dto.OtmDTO;
import com.otm.service.Impl.OtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InvalidObjectException;

@RestController
@RequestMapping("/otm")
public class MainController {

    @Autowired
    private OtmService otmService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postOTM(@RequestParam String message) throws InvalidObjectException {
        return otmService.post(new OtmDTO(message));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getOTM(@RequestParam String keyMessage) {
        return otmService.get(keyMessage);
    }


}
