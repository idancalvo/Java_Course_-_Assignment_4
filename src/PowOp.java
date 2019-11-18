/**
 * This class represent Exponentiation operator.
 * @author Aviran & Idan
 *
 */
public class PowOp extends BinaryOp{
	/**
	 * This Method operate Exponentiation between two numbers.
	 * @param left the number operand.
	 * @param right the Exponentiation operand.
	 * @return the result of the operation.
	 */
	public double operate(double left, double right) {
		return Math.pow(left, right);
	}
    /**
     * This Method string the operator.
     * @return the exponentiation operator string.
     * 
     */
	public String toString() {
		return "^";
	}
}


