package com.otm.service;

import com.otm.model.dto.OtmDTO;
import com.sun.media.sound.InvalidDataException;
import org.springframework.http.ResponseEntity;

public interface IOtmService {

	ResponseEntity post(OtmDTO otm) throws InvalidDataException;

	ResponseEntity get(String uuid);

}
