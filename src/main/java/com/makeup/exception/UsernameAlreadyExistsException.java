package com.makeup.exception;

public class UsernameAlreadyExistsException extends RuntimeException {

  private static final String MESSAGE = "이미 존재하는 아이디입니다.";

  public UsernameAlreadyExistsException() {
    super(MESSAGE);
  }
}
