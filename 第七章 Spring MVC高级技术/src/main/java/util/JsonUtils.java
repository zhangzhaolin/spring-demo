package util;

public class JsonUtils {

    private ResultEnum result;
    private String message;
    private Object data;

    public JsonUtils(ResultEnum result , String message , Object data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public ResultEnum getResult() {
        return result;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
