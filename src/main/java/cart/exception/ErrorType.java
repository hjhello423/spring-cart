package cart.exception;

public enum ErrorType {

    INVALID_MONEY("0 이상의 값이 필요합니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
