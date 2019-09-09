package com.smart;

public class Response {

    private Boolean status;
    private Object data;
    private String msg;

    public Response(){}

    public Response(Boolean status,Object data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
