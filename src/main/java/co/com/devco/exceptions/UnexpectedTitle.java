package co.com.devco.exceptions;

public class UnexpectedTitle extends AssertionError {
    public static final String UNEXPECTED_TITLE = "Unexpected title";

    public UnexpectedTitle(String message, Throwable cause){
        super(message, cause);
    }
}
