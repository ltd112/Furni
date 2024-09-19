package com.dat.furni.service.impl;

import com.dat.furni.dto.request.PermissionRequest;
import com.dat.furni.dto.response.PermissionResponse;
import com.dat.furni.mapper.PermissionMapper;
import com.dat.furni.model.Permission;
import com.dat.furni.repository.PermissionRepository;
import com.dat.furni.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PermissionServiceImpl implements PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public void delete(String permissionId) {
        permissionRepository.deleteById(permissionId);
    }
}
