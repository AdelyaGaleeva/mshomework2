package com.otus.homework2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatedDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
