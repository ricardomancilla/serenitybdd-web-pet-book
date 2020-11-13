package co.com.devco.exceptions;

public class UnknownFilter extends AssertionError {
    public static final String UNKNOWN_FILTER = "The filter looked does not exist";

    public UnknownFilter(String message){
        super(message);
    }
}
