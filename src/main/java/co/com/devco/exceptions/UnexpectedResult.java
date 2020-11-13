package co.com.devco.exceptions;

public class UnexpectedResult  extends AssertionError {
    public static final String UNEXPECTED_RESULT = "Unexpected result";

    public UnexpectedResult(String message, Throwable cause){
        super(message, cause);
    }
}
