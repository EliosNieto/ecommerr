package com.ias.ecommerce.application.commons.errors;

public enum HttpStatusCode {

    BAD_REQUEST(400),
    NOT_FOUND(404),
    NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500),
    CONFLICT(409);

    private final int code;

    HttpStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
