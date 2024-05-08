package antoni.ecommerce.core.infraestructure.exceptions;

public class BusinessException extends Exception {
    private final int status;
    private final String code;

    public BusinessException(String message, String code, int status) {
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
