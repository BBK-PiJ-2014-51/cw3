public abstract class Test {
	protected void testForExpectedValue(boolean result, boolean expectedResult, String testId){
		System.out.print(testId + ": ");
		if (result == expectedResult){
			System.out.println("passed.");
		} else {
			System.out.println("FAILED. Result: " + String.valueOf(result) + ", expected: " + String.valueOf(expectedResult));
		}
	}
	
	protected void testForExpectedValue(int result, int expectedResult, String testId){
		System.out.print(testId + ": ");
		if (result == expectedResult){
			System.out.println("passed.");
		} else {
			System.out.println("FAILED. Result: " + String.valueOf(result) + ", expected: " + String.valueOf(expectedResult));
		}
	}
	
	protected void testForExpectedValue(Object result, Object expectedResult, String testId){
		System.out.print(testId + ": ");
		if (result.equals(expectedResult)){
			System.out.println("passed.");
		} else {
			System.out.println("FAILED. Result: " + result.toString() + ", expected: " + expectedResult.toString());
		}
		
	}
}