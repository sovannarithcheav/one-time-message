package com.otm.service;

import com.otm.model.dto.OtmDTO;
import org.springframework.http.ResponseEntity;

import java.io.InvalidObjectException;

public interface IOtmService {

    ResponseEntity post(OtmDTO otm) throws InvalidObjectException;

    ResponseEntity get(String uuid);

}
