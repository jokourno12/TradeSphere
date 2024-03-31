package com.tradesphere.app.model.response;

import com.tradesphere.app.constant.EGender;
import com.tradesphere.app.constant.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private String email;
    private ERole role;
}
