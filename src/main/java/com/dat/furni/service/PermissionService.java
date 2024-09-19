package com.dat.furni.service;

import com.dat.furni.dto.request.PermissionRequest;
import com.dat.furni.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    PermissionResponse create(PermissionRequest request);
    List<PermissionResponse> getAll();
    void delete(String permissionId);
}
