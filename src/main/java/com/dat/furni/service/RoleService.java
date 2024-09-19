package com.dat.furni.service;

import com.dat.furni.dto.request.RoleRequest;
import com.dat.furni.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse create (RoleRequest request);
    List<RoleResponse> getAll();
    void delete(String roleId);
}
