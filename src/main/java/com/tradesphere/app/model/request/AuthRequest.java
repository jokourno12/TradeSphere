package com.tradesphere.app.model.request;

import com.tradesphere.app.constant.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private Date birthDate;
    private EGender gender;
}
