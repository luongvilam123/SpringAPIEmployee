package com.lam.employeespringapi.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    Employee_Error_Code("001");
    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
