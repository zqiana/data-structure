package com.baidu.phone;

import java.io.IOException;

public class HttpStatusException extends IOException {
    private int mStatusCode;
    private static final long serialVersionUID = 1;

    public HttpStatusException(int arg3) {
        super("Http status exception-" + arg3);
        this.mStatusCode = arg3;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}