package com.levelUp.busterCall.common.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int code;
    private T data;
    private String message;

    public ApiResponse(T data, ApiResponseCode apiResponseCode) {
        this.code = apiResponseCode.getCode();
        this.data = data;
        this.message = apiResponseCode.getMessage();
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse(data, ApiResponseCode.SUCCESS);
    }

    public static <T> ApiResponse<T> error() { return new ApiResponse(null, ApiResponseCode.NOT_FOUND);
    }
}
