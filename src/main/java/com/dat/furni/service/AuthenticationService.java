package com.dat.furni.service;

import com.dat.furni.dto.request.AuthenticationRequest;
import com.dat.furni.model.User;

import java.util.Optional;

public interface AuthenticationService {
    boolean authenticate(AuthenticationRequest request);

}
