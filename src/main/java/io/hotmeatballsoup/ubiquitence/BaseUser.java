package io.hotmeatballsoup.ubiquitence;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a base entity class for a user in your system.
 */
public abstract class BaseUser extends BaseEntity {
	@JsonProperty("username")
	@NotEmpty
	private String username;

	@JsonProperty("displayName")
	@NotEmpty
	private String displayName;
	
	@JsonProperty("passwordHash")
	@NotEmpty
	private String passwordHash;
	
	public BaseUser() {
		super();
	}

	/**
	 * Creates a {@link BaseUser} instance.
	 * 
	 * @param createdBy		See {@link BaseEntity}
	 * @param username		The user's username (what they login with)
	 * @param displayName	The user's display name (what other users see them displayed as)
	 * @param passwordHash	The <i>hashed</i> (*not* plaintext) password provided by the user
	 */
	public BaseUser(String createdBy, String username, String displayName, String passwordHash) {
		super(createdBy);
		
		setUsername(username);
		setDisplayName(displayName);
		setPasswordHash(passwordHash);
	}
		
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getPasswordHash() {
		return this.passwordHash;
	}
	
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
}
