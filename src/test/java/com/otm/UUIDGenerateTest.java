package com.otm;

import com.otm.dao.OtmDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UUIDGenerateTest {

	@Autowired
	OtmDao otmDao;

	@Test
	public void generateKeyUnique() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String uuid = UUID.randomUUID().toString().toUpperCase();
		System.out.println("KEY = = = = " + uuid);
	}

	@Test
	public void findDistinctFirstByStatusAndKeyMessage() {
		otmDao.findFirstByStatusAndKeyMessage("active", "");
	}

}
