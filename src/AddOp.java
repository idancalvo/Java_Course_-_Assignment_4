/**
 * This class represent addition operator.
 * @author Aviran & Idan
 *
 */
public class AddOp extends BinaryOp {

	/**
	 * This Method operate addition between two numbers.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the operation.
	 */
	public double operate(double left, double right) {
		return left + right;
	}
    /**
     * This Method string the operator.
     * @return the addition operator string.
     * 
     */
	public String toString() {
		return "+";
	}

}
