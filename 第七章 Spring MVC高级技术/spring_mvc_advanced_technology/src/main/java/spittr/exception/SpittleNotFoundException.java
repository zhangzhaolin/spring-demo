package spittr.exception;

public class SpittleNotFoundException extends RuntimeException {

    public SpittleNotFoundException() {
        super();
    }

    public SpittleNotFoundException(String message) {
        super(message);
    }

    public SpittleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpittleNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SpittleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
