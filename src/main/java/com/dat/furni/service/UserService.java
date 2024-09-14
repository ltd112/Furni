package com.dat.furni.service;

import com.dat.furni.dto.request.UserCreationReqest;
import com.dat.furni.dto.request.UserUpdateRequest;
import com.dat.furni.dto.response.UserResponse;
import com.dat.furni.model.User;

import java.util.List;

public interface UserService {
     UserResponse createUser(UserCreationReqest request);
     List<UserResponse> getAllUsers();

    UserResponse getUser(String userId);

    UserResponse updateUser(UserUpdateRequest request, String userId);

    void deleteUser(String userId);
    UserResponse getMyInfo();
}
