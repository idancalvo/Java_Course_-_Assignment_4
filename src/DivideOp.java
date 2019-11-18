/**
 * This class represent Divide operator.
 * @author aviran
 *
 */
public class DivideOp extends BinaryOp{
	/**
	 * This Method operate Divide between two numbers.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the operation.
	 */
	public double operate(double left, double right) {
		if (right==0)
			 throw new ParseException ();
		return left/right;
	}
    /**
     * This Method string the operator.
     * @return the Divide operator string.
     * 
     */
	public String toString() {
		return "/";
	}
	

}
