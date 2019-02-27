package com.otm.dao;

import com.otm.model.Otm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

@Repository
public interface OtmDao extends JpaRepository<Otm, Integer> {

	Otm findByStatusAndKeyMessage(String status, String keyMessage);
	@Transactional
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Otm findFirstByStatusAndKeyMessage(String status, String keyMessage);

}
