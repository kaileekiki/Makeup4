package com.sample;


public class SpringSession {

  private String primaryId;
  private String sessionId;
  private long creationTime;
  private long lastAccessTime;
  private long maxInactiveInterval;
  private long expiryTime;
  private String principalName;


  public String getPrimaryId() {
    return primaryId;
  }

  public void setPrimaryId(String primaryId) {
    this.primaryId = primaryId;
  }


  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }


  public long getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(long creationTime) {
    this.creationTime = creationTime;
  }


  public long getLastAccessTime() {
    return lastAccessTime;
  }

  public void setLastAccessTime(long lastAccessTime) {
    this.lastAccessTime = lastAccessTime;
  }


  public long getMaxInactiveInterval() {
    return maxInactiveInterval;
  }

  public void setMaxInactiveInterval(long maxInactiveInterval) {
    this.maxInactiveInterval = maxInactiveInterval;
  }


  public long getExpiryTime() {
    return expiryTime;
  }

  public void setExpiryTime(long expiryTime) {
    this.expiryTime = expiryTime;
  }


  public String getPrincipalName() {
    return principalName;
  }

  public void setPrincipalName(String principalName) {
    this.principalName = principalName;
  }

}
