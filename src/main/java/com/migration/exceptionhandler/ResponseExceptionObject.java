package com.migration.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ResponseExceptionObject extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String error;
    private HttpStatus status;
    private Object data;
    
    public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ResponseExceptionObject(String error, HttpStatus status, Object data) {
        super(error);
        this.error = error;
        this.status = status;
        this.data = data;
    }

    public ResponseExceptionObject(String error, HttpStatus status) {
        super(error);
        this.error = error;
        this.status = status;
        this.data = null; 
    }
}
