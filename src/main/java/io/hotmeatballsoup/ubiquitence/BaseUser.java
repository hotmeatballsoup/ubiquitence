package io.hotmeatballsoup.ubiquitence;

import java.util.Date;

/**
 * Represents a base entity class for a User in your system.
 */
public abstract class BaseUser extends BaseEntity {
  private String username;
  private String displayName;
  private String passwordHash;

  public BaseUser(Long id, String version, String createdBy, String username, String displayName,
      String passwordHash) {
    this(id, version, createdBy, new Date(), username, displayName, passwordHash);
  }

  /**
   * Creates a {@link BaseUser}.
   *
   * @param id            See {@link BaseEntity}
   * @param version       See {@link BaseEntity}
   * @param createdBy     See {@link BaseEntity}
   * @param createdOn     See {@link BaseEntity}
   * @param username      The username that a user logs in with; can be same as email but
							not necessarily (e.g. "donald_duck")
   * @param displayName   The name associated with a user, publicly displayed to other users
							(e.g. "Donald Duck 9000")
   * @param passwordHash  The <b>*HASHED*</b> password provided by the user at creation time;
							should <i>never</i> be plaintext, ever
   */
  public BaseUser(Long id, String version, String createdBy, Date createdOn, String username, String displayName,
      String passwordHash) {
    super(id, version, createdBy, createdOn);

    setUsername(username);
    setDisplayName(displayName);
    this.passwordHash = passwordHash;
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
