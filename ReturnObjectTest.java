public class ReturnObjectTest {

	public static void main(String[] args) {
		ReturnObjectTest test = new ReturnObjectTest();
		
		// constructors
		ReturnObject returnValue = new ReturnObjectImpl(new Integer(3));
		ReturnObject returnErr = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		
		test.testForExpectedValue(returnValue.hasError(), false, "Test 01: hasError on returned value");
		test.testForExpectedValue(returnErr.hasError(), true, "Test 02: hasError on returned error");
		test.testForExpectedValue(returnErr.getReturnValue(), new Integer(3), "Test 03: getReturnValue on returns value passed in");
		test.testForExpectedValue(returnErr.getError(), ErrorMessage.INVALID_ARGUMENT, "Test 04: getError returns error previously set");
		
		
	}
	
	private void testForExpectedValue(boolean result, boolean expectedResult, String testId){
		System.out.print(testId + ": ");
		if (result == expectedResult){
			System.out.println("passed.");
		} else {
			System.out.println("FAILED. Result: " + String.valueOf(result) + ", expected: " + String.valueOf(expectedResult));
		}
	}
	
	private void testForExpectedValue(Object result, Object expectedResult, String testId){
		System.out.print(testId + ": ");
		if (result.equals(expectedResult)){
			System.out.println("passed.");
		} else {
			System.out.println("FAILED. Result: " + result.toString() + ", expected: " + expectedResult.toString());
		}
		
	}

}
