package com.javalow.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @anthor Satellite
 * BaseException
 * 自定义异常基础类
 * http://www.javalow.com
 * @date 2018-06-01-14:13
 **/
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -434104233779192938L;
    /**
     * 未知错误code
     */
    public static final int UNKNOWN_ERROR_CODE = 0;

    /**
     * 未知错误message=""
     */
    public static final String UNKNOWN_ERROR_MSG = "";

    private Throwable cause;//异常
    private int errorCode;//错误code
    private String traceId;//追踪id

    public BaseException(String errorMsg) {
        this(null, errorMsg);
    }

    public BaseException(Throwable cause) {
        this(cause, "");
    }

    public BaseException(int errorCode, String errorMsg) {
        this(null, errorCode, errorMsg);
    }

    public BaseException(Throwable cause, String errorMsg) {
        this(cause, BaseException.UNKNOWN_ERROR_CODE, errorMsg);
    }

    public BaseException(Throwable cause, int errorCode, String errorMsg) {
        this(cause, errorCode, errorMsg, null);
    }

    public BaseException(Throwable cause, int errorCode, String errorMsg, String traceId) {
        super(errorMsg);
        this.cause = cause;
        this.errorCode = errorCode;
        this.traceId = traceId;
    }

    @Override
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    @Override
    public void printStackTrace(PrintStream ps) {
        if (null == getCause()) {
            super.printStackTrace(ps);
        } else {
            ps.println(this);
            getCause().printStackTrace(ps);
        }
    }

    @Override
    public void printStackTrace(PrintWriter pw) {
        if (null == getCause()) {
            super.printStackTrace(pw);
        } else {
            pw.println(this);
            getCause().printStackTrace(pw);
        }
    }

    @Override
    public Throwable getCause() {
        return this.cause == this ? null : this.cause;
    }

    @Override
    public String getMessage() {
        if (getCause() == null) {
            return super.getMessage();
        }
        return super.getMessage() + getCause().getMessage();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getTraceId() {
        return traceId;
    }

}
