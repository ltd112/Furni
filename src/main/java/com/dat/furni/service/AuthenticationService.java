package com.dat.furni.service;

import com.dat.furni.dto.request.AuthenticationRequest;
import com.dat.furni.dto.request.IntrospectRequest;
import com.dat.furni.dto.response.AuthenticationResponse;
import com.dat.furni.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
