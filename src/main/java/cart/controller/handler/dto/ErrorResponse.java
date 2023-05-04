package cart.controller.handler.dto;

public class ErrorResponse {

    private final String errorCode;
    private final String message;

    public ErrorResponse(String errorCode, String message) {

        this.errorCode = errorCode;
        this.message = message;
    }

}
