public class ReturnObjectTest extends Test{

	public static void main(String[] args) {
		ReturnObjectTest test = new ReturnObjectTest();
		
		// constructors
		ReturnObject returnValue = new ReturnObjectImpl(new Integer(3));
		ReturnObject returnErr = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		test.testForExpectedValue(returnValue.hasError(), false, "Test 01: hasError on returned value");
		test.testForExpectedValue(returnErr.hasError(), true, "Test 02: hasError on returned error");
		test.testForExpectedValue(returnValue.getReturnValue(), new Integer(3), "Test 03: getReturnValue on returns value passed in");
		test.testForExpectedValue(returnErr.getError(), ErrorMessage.INVALID_ARGUMENT, "Test 04: getError returns error previously set");
		
		//TO DO: add further testing
	}
	
}
