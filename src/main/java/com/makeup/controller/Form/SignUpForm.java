package com.makeup.controller.Form;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpForm {

    private String email;

    private String username;

    private String userNickname;

    private String password;

    private String birthYear;

    private Boolean gender;

    private String phoneNumber;

}
