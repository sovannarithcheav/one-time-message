package com.otm.controller;

import com.otm.model.Otm;
import com.otm.model.dto.OtmDTO;
import com.otm.service.Impl.OtmService;
import com.sun.media.sound.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otm")
public class MainController {

	@Autowired
	private OtmService otmService;

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ResponseEntity postOTM(@RequestParam String message) throws InvalidDataException {
		return otmService.post(new OtmDTO(message));
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity getOTM(@RequestParam String keyMessage) throws InvalidDataException {
		return otmService.get(keyMessage);
	}


}
