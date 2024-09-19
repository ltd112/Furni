package com.dat.furni.controller;

import com.dat.furni.dto.request.ApiResponse;
import com.dat.furni.dto.request.PermissionRequest;
import com.dat.furni.dto.response.PermissionResponse;
import com.dat.furni.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class PermissionController {
    PermissionService permissionService;
    @PostMapping
    ApiResponse<PermissionResponse> create(@RequestBody PermissionRequest request){
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.create(request))
                .build();
    }
    @GetMapping
    ApiResponse<List<PermissionResponse>> getAll(){
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAll())
                .build();
    }
    @DeleteMapping("/{permissionId}")
    ApiResponse<Void> delete(@PathVariable String permissionId){
        permissionService.delete(permissionId);
        return ApiResponse.<Void>builder().build();
    }


}
