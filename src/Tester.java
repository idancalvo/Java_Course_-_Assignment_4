/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// Each function here should test a different class.
		testValueToken();
		testPostfixCalculator();
		testDivideOp();
		testAddOp();
		testSubstract();
		testPowOp();
		testMultiplyOp();
		testExpTokenizer();
		testStackAsArray();
		/* TODO - write a function for each class */
		
		
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}


	/**
	 * 
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;
		
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}
	
	/**
	 * Checks the ValueToken class.
	 */
	private static void testValueToken() {
		
		ValueToken t1 = new ValueToken(5.1);
		//1
		test(t1.getValue() == 5.1, "Value should be 5.1.");
		//2
		test(t1.toString().equals("5.1"), "Value toString should be 5.1.");
		t1 = new ValueToken(0.0);
		//3
		test(t1.getValue() == 0.0, "Value should be 0.0.");
		//4
		test(t1.toString().equals("0.0"), "Value toString should be 0.0.");
		t1 = new ValueToken(-5.35);
		//5
		test(t1.getValue() == -5.35, "Value should be -5.35.");
		//6
		test(t1.toString().equals("-5.35"), "Value toString should be -5.35.");
		
		
		
	}

	/**
	 * Checks the PostfixCalculator class.
	 */
	private static void testPostfixCalculator() {
		
		PostfixCalculator c = new PostfixCalculator();
		//7
		test (c.getCurrentResult()==0 , "Output should be 0" );
		
		// (+)
		//8
		c.evaluate("2 3 +");
		test (c.getCurrentResult()==5 , "Output should be 5.0" );
		//9
		c.evaluate("2.4 -5.3 +");
		test (c.getCurrentResult()==-2.9, "Output should be -2.9" );
		//10
		c.evaluate("0 0 +");
		test (c.getCurrentResult()==0 , "Output should be 0.0" );
		//11
		c.evaluate("4 0 +");
		test (c.getCurrentResult()==4 , "Output should be 4.0" );
		//12
		c.evaluate("0 5.32 +");
		test (c.getCurrentResult()==5.32 , "Output should be 5.32" );
		//13
		c.evaluate("2 3.43 +");
		test (c.getCurrentResult()==5.43 , "Output should be 5.43" ); 
       
		// (-) 
		//14
		c.evaluate("0 0 -");
		test (c.getCurrentResult()==0 , "Value should be 0.0" );
		//15
		c.evaluate("10 3 -");
		test (c.getCurrentResult()==7 , "Value should be 7.0" );
		//16
		c.evaluate("3.45 8.65 -");
		test (c.getCurrentResult()==-5.2 , "Value should be -5.2" );
		//17
		c.evaluate("-3.45 0 -");
		test (c.getCurrentResult()==-3.45 , "Value should be -3.45" );
		//18
		c.evaluate("-3.45 0 -");
		test (c.getCurrentResult()==-3.45 , "Value should be -3.45" );
		//19
		c.evaluate("0 6.45 -");
		test (c.getCurrentResult()==-6.45 , "Value should be -6.45" );
		//20
		c.evaluate("-4.32 -6.45 -");
		test (c.getCurrentResult()==2.13 , "Value should be 2.13" );
       
		// (*)
		//21
		c.evaluate("3 3 *");
		test (c.getCurrentResult()==9 , "Value should be 9.0" );
		//22
		c.evaluate("3 0 *");
		test (c.getCurrentResult()==0 , "Output should be 0.0" );
		//23
		c.evaluate("0 -2.6735 *");
		test (c.getCurrentResult()==0 , "Value should be 0.0" );
		//24
		c.evaluate("0 0 *");
		test (c.getCurrentResult()==0 , "Output should be 0.0" );
		//25
		c.evaluate("4.32 5.21 *");
		test (c.getCurrentResult()==22.5072 , "Value should be 22.5072" );
		//26
		c.evaluate("-2.32 8.21 *");
		test (c.getCurrentResult()==-19.0472 , "Value should be -19.0472" );
		//27
		c.evaluate("-12.32 -0.21 *");
		test (c.getCurrentResult()==2.5872 , "Value should be 2.5872" );
       
		// (/)
		//28
		c.evaluate("6 2 /");
		test (c.getCurrentResult()==3 , "Output should be 3.0" );
		//29
		c.evaluate("0 3.453 /");
       	test (c.getCurrentResult()==0 , "Output should be 0.0" );
       	//30
       	c.evaluate("6 2 /");
       	test (c.getCurrentResult()==3 , "Output should be 3.0" );
       	//31
       	c.evaluate("6 2 /");
       	test (c.getCurrentResult()==3 , "Output should be 3.0" );
       	//32
       	c.evaluate("3.76 1 /");
       	test (c.getCurrentResult()==3.76 , "Output should be 3.76" );
       	//33
       	c.evaluate("5 0.2 /");
       	test (c.getCurrentResult()==25 , "Output should be 25" );
       	//34
       	c.evaluate("-2 -3.2 /");
       	test (c.getCurrentResult()==0.625 , "Output should be 0.625" );
       	//35
       	c.evaluate("2 -3.2 /");
       	test (c.getCurrentResult()==-0.625 , "Output should be -0.625" );
       
       	// (^)
       	//36
       	c.evaluate("10 2 ^");
  	    test (c.getCurrentResult()==100 , "Value should be 100.0" );
  	    //37
  	    c.evaluate("0 6 ^");
  	    test (c.getCurrentResult()==0 , "Value should be 0.0" );
  	    //38
  	    c.evaluate("1 7 ^");
  	    test (c.getCurrentResult()==1 , "Value should be 1.0" );
    	  //39
  	    c.evaluate("5 0 ^");
  	    test (c.getCurrentResult()==1 , "Value should be 1.0" );
  	    //40
  	    c.evaluate("5 0 ^");
  	    test (c.getCurrentResult()==1 , "Value should be 1.0" );
  	    //41
  	    c.evaluate("100 -0.5 ^");
  	    test (c.getCurrentResult()==0.1 , "Value should be 0.1" );
       
		//(Order of operations)
  	    //42 
  	    c.evaluate("2 3 + 5 * 5 +");
  	    test (c.getCurrentResult()==30 , "Value should be 30.0" );
  	    //43
  	    c.evaluate("4 3 * 2 - 2 ^");
  	    test (c.getCurrentResult()==100 , "Value should be 100.0" );
  	    //44
  	    c.evaluate("1 10 /");
  	    test (c.getCurrentResult()==0.1 , "Value should be 0.1" );
  	    //45
  	    c.evaluate("2 -2 ^");
       	test (c.getCurrentResult()==0.25 , "Value should be 0.25");
       	//46
       	c.evaluate("2 3 + 5 * 5 +");
       	test (c.getCurrentResult()==30 , "Value should be 30.0" );
       	//47
       	c.evaluate("6 2 + 4 / 3 - 4 *");
       	test (c.getCurrentResult()==-4 , "Value should be -4");
       	//48
       	c.evaluate("6 2 ^ 4 + 4 /");
       	test (c.getCurrentResult()==10 , "Value should be 10");
       	//49
       	c.evaluate("2 -1 ^");
       	test (c.getCurrentResult()==0.5 , "Value should be 0.5");
       	//50
       	c.evaluate("2 3 ^ 4 * 7 -");
       	test (c.getCurrentResult()==25 , "Value should be 25.0");
       	//51
       	c.evaluate("2 3 ^ 4 * 7 - 0 *");
       	test (c.getCurrentResult()==0 , "Value should be 0.0");
       	//52
       	c.evaluate("2 3 4 ^ * 7 -");
       	test (c.getCurrentResult()==155 , "Value should be 155.0");
       	//53
       	c.evaluate("2 3 ^ 4 2 * / -7 -");
       	test (c.getCurrentResult()==8 , "Valie should be 8.0" );
    	
       	//(Invalid input)
       	//54
       	try {
       		c = new PostfixCalculator();
       		c.evaluate("2 3 4 5 - + / *");
       		test(false,"need throw Exception");
			    }catch (ParseException a){test (true,"");}
       	//55
       	try {
       		c = new PostfixCalculator();
       		c.evaluate("5 6 8 5 - *");
       		test(false,"need throw Exception");
			    }catch (ParseException a){test (true,"");}
       	//56
       	try {
       		c = new PostfixCalculator();
       		c.evaluate("2 3 4 5");
       		test(false,"need throw Exception");
			    }catch (ParseException a){test (true,"");}
       	//57
       	try {
       		c = new PostfixCalculator();
       		c.evaluate("2 +");
       		test(false,"need throw Exception");
			    }catch (ParseException a){test (true,"");}
       	//58
       	try {
       		c = new PostfixCalculator();
       		c.evaluate("2-8");
       		test(false,"need throw Exception");
			    }catch (ParseException a){test (true,"");}
       	//59
       	try {
       		c = new PostfixCalculator();
       		c.evaluate(" ");
       		test(false,"need throw Exception");
			    }catch (Exception a){test (true,"");}
       	//60
       	try {
       		c = new PostfixCalculator();
       		c.evaluate("4 + 6");
       		test(false,"need throw Exception");
			    }catch (Exception a){test (true,"");}
       	//61
       	try {
       		c = new PostfixCalculator();
       		c.evaluate("- +");
       		test(false,"need throw Exception");
			    }catch (Exception a){test (true,"");}
	}
	
	/**
	 * Checks the DivideOp class.
	 */
    private static void testDivideOp() {
   		
    	DivideOp Div = new DivideOp();
    	//62
    	test (Div.toString()=="/" , "The String should be /");
    	//63
    	test (Div.operate(6,2)==3 , "Value should be 3");
    	//64
    	test (Div.operate(1,2)==0.5 , "Value should be 0.5");
    	//65
    	try {
    	test (Div.operate(1,0)>=0||Div.operate(1,0)<0,"you can't to Divide by 0");
    	}catch (ParseException a){test (true,"");}
    }
    
	/**
	 * Checks the AddOp class.
	 */
   	private static void testAddOp() {
   		
   		AddOp Add = new AddOp();
   		//66
   		test(Add.toString()=="+" , "The String should be +");
   		//67
   		test(Add.operate(0,3)==3 , "Value should be 3");
   		//68
   		test(Add.operate(1.5,0.5)==2 , "Value should be 2"); 	
   	}
   	
	/**
	 * Checks the Subtract class.
	 */
   	private static void testSubstract() {
   		
   		SubtractOp sub = new SubtractOp();
   		//69
   		test(sub.toString()=="-" , "The String should be -");
   		//70
   		test(sub.operate(5,3)==2 , "Value should be 2");
   		//71
   		test(sub.operate(3,10)==-7 , "Value should be -7");
   	}
	/**
	 * Checks the PowOp class.
	 */
	private static void testPowOp() {
	 
		PowOp pow = new PowOp();
		//72
		test(pow.toString()=="^" , "The String should be ^");
		//73
		test(pow.operate(4,5)==1024 , "Value should be 1024");
		//74
		test(pow.operate(2,-2)==0.25 , "Value should be 0.25");
		//75
		test(!(pow.operate(-2,0.2)>=0||pow.operate(-2,0.2)<0), "The eradicated of number negative not valid");
		
		
	}
	/**
	 * Checks the MultiplyOp class.
	 */
	private static void testMultiplyOp() {
	
		MultiplyOp m = new MultiplyOp();
		//76
		test(m.toString()=="*", "The String should be *");
		//77
		test(m.operate(5,10)==50, "Value should be 50");
		//78
		test(m.operate(-1, -5)==5, "Valuse should be 5");
    }
	
	/**
	 * Checks the ExpTokenizer class.
	 */
	private static void testExpTokenizer() {
		
		ExpTokenizer e = new ExpTokenizer("2 3 +" , true);
		//79
		test(e.hasMoreTokens()==true , "The Boolean should be true");
		//80
		test(e.countTokens()==3, "Value should be 3");
		//81
		e.nextElement();
		e.nextElement();
		e.nextElement();
		test(e.hasMoreElements()==false,"The boolean should be false");
		//82
		e = new ExpTokenizer("1 2 + 5", false);
		test(e.hasMoreTokens()==true , "The Boolean should be true");
		//83
		test(e.countTokens()==4, "Value should be 4");
		//84
		e = new ExpTokenizer("$ P s +");
		test((e.nextToken()).equals("$"),"Value should be $");
		//85
		test((e.nextToken()).equals("P"),"Value should be P");
		//86
		test((e.nextToken()).equals("s"),"Value should be s");
		//87
		test((e.nextToken()).equals("+"),"Value should be +");
		//88
		try {
	    test ((e.nextToken()).equals("+"),"need throw Exception");
	    	}catch (ArrayIndexOutOfBoundsException a){test (true,"");}
		//89
		e = new ExpTokenizer("& 2 4 + -");
		try {
			e.nextElement();
			test(false,"need throw Exception");
			    }catch (ParseException a){test (true,"");}
	
		
		
	}
	
	/**
	 * Checks the StackAsArray class.
	 */
	private static void testStackAsArray(){
     
		StackAsArray s = new StackAsArray();
		//90
		test(s.isEmpty()==true , "The Boolean should be true");
		s.push(1);
		s.push("*");
		//91
		test (s.isEmpty()==false , "The Boolean should be false");
		//92
		test ((String)s.pop()=="*", "The String should be *");
		//93
		test ((Integer)s.pop()==1, "Number should be 1"); 
	}
	
}
