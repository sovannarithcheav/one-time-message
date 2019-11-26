package com.otm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UUIDGenerateTest {

    @Test
    public void generateKeyUnique() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        System.out.println("KEY = = = = " + uuid);
    }

    @Test
    public void findDistinctFirstByStatusAndKeyMessage() {
//        otmDao.findFirstByStatusAndKeyMessage("active", "");
    }

}
