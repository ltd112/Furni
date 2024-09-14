package com.dat.furni.service.impl;

import com.dat.furni.dto.request.UserCreationReqest;
import com.dat.furni.dto.request.UserUpdateRequest;
import com.dat.furni.dto.response.UserResponse;
import com.dat.furni.enums.Role;
import com.dat.furni.exception.AppException;
import com.dat.furni.exception.ErrorCode;
import com.dat.furni.mapper.UserMapper;
import com.dat.furni.model.User;
import com.dat.furni.repository.UserRepository;
import com.dat.furni.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserCreationReqest request) {

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_ALREADY_EXISTS);
        }
        User user = userMapper.toUser(request);
        //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUser(String userId) {
        return userMapper.toUserResponse(userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }

    @Override
    public UserResponse updateUser(UserUpdateRequest request, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
