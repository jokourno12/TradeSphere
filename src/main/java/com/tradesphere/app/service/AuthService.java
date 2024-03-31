package com.tradesphere.app.service;

import com.tradesphere.app.model.request.AuthRequest;
import com.tradesphere.app.model.response.LoginResponse;
import com.tradesphere.app.model.response.RegisterResponse;

public interface AuthService {
    RegisterResponse registerUser(AuthRequest authRequest);
    LoginResponse login(AuthRequest authRequest);
}
