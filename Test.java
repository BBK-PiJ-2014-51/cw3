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
		if (result == expectedResult){
			System.out.println("passed.");
		}
		else if (result.equals(expectedResult)){
			System.out.println("passed.");
		} else {
			System.out.println("FAILED. Result: " + result.toString() + ", expected: " + expectedResult.toString());
		}		
	}
	
	protected static void printList(List list){
		for (int i =0; i < list.size(); i++){
			System.out.println(String.valueOf(list.get(i).getReturnValue()));
		}
	}
}