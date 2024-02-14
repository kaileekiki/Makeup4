package com.makeup.exception;

public class MemberNotFoundException extends RuntimeException {

  private static final String MEMBER_NOT_FOUND = "일치하는 회원 정보가 없습니다.";

  public MemberNotFoundException() {
    super(MEMBER_NOT_FOUND);
  }
}
