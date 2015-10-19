package io.hotmeatballsoup.ubiquitence;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Assert;
import org.junit.Test;
import org.mongodb.morphia.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.hotmeatballsoup.ubiquitence.utils.seqgen.AutoIncrementingSequenceGenerator;

/**
 * Test class for {@link BaseEntity}.
 */
public class BaseEntityTest {
	@Test
	public void createAndUseBaseEntity() {
		// Given:
		Hotmeatballsoup hms;
		AutoIncrementingSequenceGenerator aisg = new AutoIncrementingSequenceGenerator();
		
		// When:
		// Note: We don't need to use the sequence generator on DB systems that natively
		// support auto-incrementing. This feature was added specifically to support Mongo.
		hms = new Hotmeatballsoup(aisg.next(), "001", "my_db_user", "(555)555-5555");
		
		// Then:
		Assert.assertTrue(hms.getId() == 1L);
	}

	/**
	 * Dummy entity that shows how to use BaseEntity directly. In this case,
	 * our 'Hotmeatballsoup' entity has a phone number field that serializes
	 * to JSON, can't be empty/null, and must abide a particular regex.
	 */
	@Entity
	@JsonIgnoreProperties(ignoreUnknown=true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private class Hotmeatballsoup extends BaseEntity {
		@JsonProperty("phone_number")
		@NotEmpty
		@Pattern(regexp="(\\d{7})|(\\d{10)|")
		private String phoneNumber;
		
		public Hotmeatballsoup(Long id, String version, String createdBy, String phoneNumber) {
			super(id, version, createdBy);
			
			setPhoneNumber(phoneNumber);
		}
		
		void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	}
	
}
