package io.hotmeatballsoup.ubiquitence;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Version;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base entity class for all other domain types/entities.
 * 
 * <p>All your entities should extend this class or one of its subclasses. Remember to apply
 * the correct annotations to your subclasses.
 */
public abstract class BaseEntity {
	@Id
	@JsonProperty("id")
	@Min(value=1L)
	private Long id;

	@Version
	@JsonProperty("version")
	@NotEmpty
	private Long version;
	
	@JsonProperty("created_by")
	@NotEmpty
	private String createdBy;
	
	@JsonProperty("created_on")
	@NotNull
	private Date createdOn;
	
	/**
	 * The DB user that last updated this record.
	 */
	@JsonProperty("updated_by")
	@NotEmpty
	private String updatedBy;
	
	/**
	 * The date/time this record was last updated.
	 */
	@JsonProperty("updated_on")
	@NotNull
	private Date updatedOn;

	public BaseEntity() {
		super();
	}
	
	/**
	 * Creates  {@link BaseEntity}.
	 * 
	 * @param createdBy		DB user that created the entity
	 */
	public BaseEntity(String createdBy) {
		super();
		
		this.createdBy = createdBy;
		this.createdOn = new Date();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getVersion() {
		return this.version;
	}
	
	public void setVersion(Long version) {
		this.version = version;
	}
	
	public String getCreatedBy(String createdBy) {
		return this.createdBy;
	}
	
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public Date getUpdatedOn() {
		return updatedOn;
	}
	
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
}
