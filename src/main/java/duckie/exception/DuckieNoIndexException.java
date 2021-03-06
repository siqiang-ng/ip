package duckie.exception;

/**
 * DuckieException thrown when the input index is not found in the TaskList.
 */
public class DuckieNoIndexException extends DuckieException {
    /**
     * Instantiates DuckieNoIndexException.
     */
    public DuckieNoIndexException() {
        super("Quack. The input index is not found in the list.");
    }
}
