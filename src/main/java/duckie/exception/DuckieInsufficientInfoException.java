package duckie.exception;

/**
 * DuckieException thrown when there are insufficient info input.
 */
public class DuckieInsufficientInfoException extends DuckieException {

    /**
     * Instantiates DuckieInsufficientInfoErrorException.
     */
    public DuckieInsufficientInfoException() {
        super("Duckie needs more description after the first word.");
    }
}
