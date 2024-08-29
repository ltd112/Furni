package com.dat.furni.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.sql.results.graph.collection.internal.UnfetchedCollectionAssembler;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(404, "User not found"),
    USER_ALREADY_EXISTS(400, "User already exists"),
    INVALID_REQUEST(400, "Invalid request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    UNCAUGHT_EXCEPTION(500, "Uncaught exception"),
    USERNAME_INVALID(400, "Username must be at least 5 characters long"),
    PASSWORD_INVALID(400, "Password must be at least 8 characters long")

    ;

    private final int code;
    private final String message;
}
