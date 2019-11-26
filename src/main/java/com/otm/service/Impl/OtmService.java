package com.otm.service.Impl;

import com.otm.model.Otm;
import com.otm.model.component.OTMs;
import com.otm.model.dto.OtmDTO;
import com.otm.service.IOtmService;
import net.bytebuddy.utility.RandomString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.Date;
import java.util.HashMap;

@Service
public class OtmService implements IOtmService {

    @Override
    public ResponseEntity post(OtmDTO otmDTO) throws InvalidObjectException {
        if (!otmDTO.validate()) {
            throw new InvalidObjectException("Invalid message");
        }
        Otm otm = new Otm();
        String uuid = RandomString.make(10);
        otm.setKeyMessage(uuid);
        otm.setMessage(otmDTO.getMessage());
        OTMs.message.put(uuid, otm);
        return new ResponseEntity<>(otm.getKeyMessage(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity get(String uuid) {
        Otm message = OTMs.message.get(uuid);
        if (message == null) return new ResponseEntity<>("message not found", HttpStatus.NOT_FOUND);
        if (message.getStatus().equals("seen")) return new ResponseEntity<>("message is locked", HttpStatus.LOCKED);
        message.setStatus("seen");
        message.setUpdatedAt(new Date());
        return new ResponseEntity<>(message.getMessage(), HttpStatus.OK);
    }
}
