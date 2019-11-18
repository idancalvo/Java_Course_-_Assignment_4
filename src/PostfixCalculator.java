/**
 * This class get a expression in postfix notation and 
 * compute the value of the given expression.
 * @author Aviran & Idan
 *
 */
public class PostfixCalculator extends Calculator {
   
	private StackAsArray Stack = new StackAsArray();
	/**
	 * This method computes the numerical value of expression.
	 * @param expr string representing a postfix expression.
	 */
	public void evaluate(String expr) {
		double left,right;
		ExpTokenizer ExpToken = new ExpTokenizer(expr,true);
	    while (ExpToken.hasMoreTokens()){
			CalcToken NextToken = (CalcToken) ExpToken.nextElement();
			if (NextToken instanceof ValueToken)
				Stack.push(((ValueToken) NextToken).getValue());
			else{
				try{
					right = (Double) Stack.pop();
					left = (Double) Stack.pop();
					Stack.push(((BinaryOp) NextToken).operate(left,right));
				}
				catch (RuntimeException e){
					throw new ParseException("SYNTAX ERROR: Cannot perform operation");
				}   
			}//end of else
		}//end of while 
	    Answer=(Double) Stack.pop();
	    if (!Stack.isEmpty())
	    	throw new ParseException("SYNTAX ERROR: Cannot perform operation");
       }
}