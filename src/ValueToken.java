/**
 * This class represent Tokens of a numerical value
 * @author Aviran & Idan
 *
 */
public class ValueToken extends CalcToken{
	
	private double ValueToken;
    /**
     * Constructor.
     * @param value is the number represented by the token. 
     */
	public ValueToken(double value){
		ValueToken = value;
	}
	/**
	 * This method used to get the numerical value of the token.
	 * @return the numerical value.
	 */
	public double getValue(){
		return ValueToken;
	}
	/**
	 * This method string the value of the numerical value.
	 */
	public String toString() {
		return ""+ValueToken;
	}

}
