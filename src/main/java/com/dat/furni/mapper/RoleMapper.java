package com.dat.furni.mapper;

import com.dat.furni.dto.request.RoleRequest;
import com.dat.furni.dto.response.RoleResponse;
import com.dat.furni.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
