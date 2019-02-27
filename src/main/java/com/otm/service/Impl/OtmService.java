package com.otm.service.Impl;

import com.otm.dao.OtmDao;
import com.otm.model.Otm;
import com.otm.model.dto.OtmDTO;
import com.otm.service.IOtmService;
import com.otm.util.KeyGenerator;
import com.sun.media.sound.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Service
public class OtmService implements IOtmService {

	@Autowired
	private OtmDao otmDao;

	@Override
	public ResponseEntity post(OtmDTO otmDTO) throws InvalidDataException {
		if (!otmDTO.validate()) {
			throw new InvalidDataException();
		}
		Otm otm = new Otm();
		String uuid = KeyGenerator.getStandardRandomAlphabetic();
		otm.setKeyMessage(uuid);
		otm.setMessage(otmDTO.getMessage());
		otmDao.save(otm);
		HashMap<String, Object> data = new HashMap();
		data.put("keyMessage", otm.getKeyMessage());
		data.put("message", otm.getMessage());
		return new ResponseEntity(data,HttpStatus.OK);
	}

	@Override
	public ResponseEntity get(String uuid) {
		Otm otm = otmDao.findFirstByStatusAndKeyMessage("active", uuid);
		if (otm == null) throw new ResourceNotFoundException(uuid, null);
		otm.setStatus("seen");
		otm.setUpdatedAt(new Date());
		otmDao.save(otm);
		HashMap<String, Object> data = new HashMap();
		data.put("message", otm.getMessage());
		return new ResponseEntity(data, HttpStatus.OK);
	}
}
