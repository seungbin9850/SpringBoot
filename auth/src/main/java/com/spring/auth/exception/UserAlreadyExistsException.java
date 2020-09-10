package com.spring.auth.exception;

public class UserAlreadyExistsException extends BusinessException {
    public UserAlreadyExistsException() {
        super(ErrorCode.USER_DUPLICATION);
    }
}
