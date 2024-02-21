package com.makeup.exception;

public class ReservationNotFoundException extends RuntimeException{
        private static final String MEMBER_NOT_FOUND = "일치하는 멘토 날짜 예약 정보가 없습니다.";

        public ReservationNotFoundException() {

            super(MEMBER_NOT_FOUND);
        }

}
