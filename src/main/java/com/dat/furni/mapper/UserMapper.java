package com.dat.furni.mapper;

import com.dat.furni.dto.request.UserCreationReqest;
import com.dat.furni.dto.request.UserUpdateRequest;
import com.dat.furni.dto.response.UserResponse;
import com.dat.furni.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationReqest reqest);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
