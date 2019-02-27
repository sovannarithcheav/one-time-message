package com.otm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "one_time_message")
public class Otm extends com.otm.model.base.Entity {
	/**
	 * @*status->{inactive*active*seen*...}
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String message;
	@Length(max = 36, min = 36)
	private String keyMessage;
	/**
	 * @Use.to.store.key.to.open.message
	 */
	private Integer timesGenerateKey;

	/**
	 * @When.keyMessage.was.generated->timesGenerateKey++
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getKeyMessage() {
		return keyMessage;
	}

	public void setKeyMessage(String keyMessage) {
		this.keyMessage = keyMessage;
	}

	public Integer getTimesGenerateKey() {
		return timesGenerateKey;
	}

	public void setTimesGenerateKey(Integer timesGenerateKey) {
		this.timesGenerateKey = timesGenerateKey;
	}

}
