package com.ibm.moses.common.controller;

/**
 * @author Moses
 */
public class BaseResponse<T> {
    private static final int CODE_SUCCESS = 200;
    private static final int CODE_FAIL = 400;
    private int status;
    private T data;
    private String message;
    private boolean success;

    public BaseResponse() {
    }

    /**
     * for success case
     *
     * @param status
     * @param data
     */
    public BaseResponse(int status, T data) {
        this.status = status;
        this.data = data;
        this.success = true;
    }

    /**
     * for success case
     *
     * @param status
     * @param data
     * @param message
     */
    public BaseResponse(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.success = true;
    }

    /**
     * for fail case
     *
     * @param status
     * @param message
     */
    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(CODE_SUCCESS, data);
    }

    public static <T> BaseResponse<T> success(T data, String message) {
        return new BaseResponse<T>(CODE_SUCCESS, data, message);
    }

    public static <T> BaseResponse<T> fail(String message) {
        return new BaseResponse<T>(CODE_FAIL, message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
