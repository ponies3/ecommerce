package antoni.ecommerce.core.infraestructure.exceptions;

public class ApiException extends Exception {
    private final int status;
    private final String code;

    public ApiException(String message, String code, int status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
