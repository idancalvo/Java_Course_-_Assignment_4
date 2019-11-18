/**
 * This class is used to handle invalid expressions.
 * @author Aviran & Idan
 *
 */
public class ParseException extends RuntimeException{
	/**
	 * Constructor Parse Exception.
	 */
	public ParseException(){
		super();
	}
    /**
     * Constructor Parse Exception.
     * @param message the error message that caused the parsing exception.
     */
	public ParseException(String message){
		super(message);
	}
}
