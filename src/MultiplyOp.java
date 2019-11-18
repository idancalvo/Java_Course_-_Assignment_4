/**
 * This class represent multiply operator.
 * @author Aviran & Idan
 *
 */
public class MultiplyOp extends BinaryOp {
	
	/**
	 * This Method operate multiply between two numbers.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the operation.
	 */
	public double operate(double left, double right) {
		return left*right;
	}
    /**
     * This Method string the operator.
     * @return the multiply operator string.
     * 
     */
	public String toString() {
		return "*";
	}

}
