package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class UpdateUserRequestPojo {
    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;
}
