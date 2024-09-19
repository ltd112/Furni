package com.dat.furni.mapper;

import com.dat.furni.dto.request.PermissionRequest;
import com.dat.furni.dto.response.PermissionResponse;
import com.dat.furni.model.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);

}
