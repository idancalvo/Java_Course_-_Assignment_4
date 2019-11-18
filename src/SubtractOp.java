/**
 * This class represent Subtract operator.
 * @author aviran & Idan
 *
 */
public class SubtractOp extends BinaryOp{

	/**
	 * This Method operate subtract between tow numbers.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the operation.
	 */
	public double operate(double left, double right) {
		return left-right;
	}
    /**
     * This Method string the operator.
     * @return the subtract operator string.
     * 
     */
	public String toString() {
		return "-";
	}

}
