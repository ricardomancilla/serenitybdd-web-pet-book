package co.com.devco.exceptions;

public class UnknownImage extends AssertionError {
    public static final String UNEXPECTED_IMAGE = "The expected image is different than the actual one";

    public UnknownImage(String message){
        super(message);
    }
}
