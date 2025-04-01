package com.sumit.tableServe.models;

import lombok.Data;

@Data
public class ApiResponseModel {

    private Object data;
    private String message;
    private int code;
    private boolean success;

    public ApiResponseModel(Object data, String message, int code, boolean success) {
        this.data = data;
        this.message = message;
        this.code = code;
        this.success = success;
    }
}
