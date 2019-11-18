/**
 * Abstract class that use to define the features of a calculator.
 * @author Aviran & Idan
 */
public abstract class Calculator {
	
	protected double Answer=0;
   /**
    * This method computes the numerical value of a mathematics expression.
    * @param expr is a String representing mathematics expression.
    */
   public abstract void evaluate(String expr);
   /**
    * This method returning the result of the last expression that was evaluated. 
    * @return the last expression result.
    */
   public double getCurrentResult() {
    return Answer;
	}


}
