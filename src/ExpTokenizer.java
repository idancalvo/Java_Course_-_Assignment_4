import java.util.Enumeration;
/**
 *This class convert a string into a series of tokens.
 */
public class ExpTokenizer extends Object implements Enumeration<Object>  {
	//fields
	private String [] result;
	private boolean direction;
	private int index;
	
	/**
	 * constructor.
	 * @param exp is the string that convert to tokens.
	 */
	public ExpTokenizer(String exp) {
		this.result = exp.split(" ");
		this.direction = true;
		this.index = 0;
	}
	/**
	 * constructor.
	 * @param exp is the string that convert to tokens.
	 * @param direction if true, we will tokenize from left to right,
	 * if direction is false, then we will tokenize from right to left.
	 */
	public ExpTokenizer(String exp,boolean direction) {
		result = exp.split(" ");
		this.direction = direction;
		if(!this.direction)
			this.index=result.length-1;
		else 
			this.index = 0;
	}
	
	/**
	 * This method is used to get the next element.
	 * @return the next element.
	 */
	public Object nextElement() {
		CalcToken resultToken = null;
		String token =  nextToken();
		if (token.equals("+"))
			resultToken = new AddOp();
		else if (token.equals("*"))
			resultToken = new MultiplyOp();
			else if (token.equals("/"))
				resultToken = new DivideOp();
				else if (token.equals("^"))
					resultToken = new PowOp();
					else if (token.equals("-"))
						resultToken = new SubtractOp();
						else 
							try{
								resultToken = new ValueToken(Double.parseDouble(token));
							}
							catch (NumberFormatException e) {
								throw new ParseException("SYNTAX ERROR: invalid token " + token);
							}
		
		return resultToken;	
	}

	/**
	 * This method checking if there is elements left.
	 * @return true is there is more elements left, false otherwise.
	 */
	public boolean hasMoreElements() {
		if(this.direction)
			return (this.index != this.result.length);
		else
			return (this.index >= 0);
	}
	/**
	 * This method is used to get the next token as a string.
	 * @return string of the next token.
	 */
	public String nextToken() {
		String ret;
		if(this.direction){
			ret= this.result[this.index];
			this.index++;
		}
			
		else{
			ret= this.result[this.index];
			this.index--;
		}
		return ret;
	}
    /**
     * This method checking is there is tokens left.
     * @return true is there is tokens left, false otherwise.
     */
	public boolean hasMoreTokens() {
		return hasMoreElements();
	}
    /**
     * This method count the number of tokens.
     * @return the number of the tokens.
     */
	public int countTokens() {
		if(this.direction)
			return (this.result.length - this.index);
		else
			return (this.index+1);
	}
	
   }