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
	
	protected static void popStack(Stack stack){
		for (int i =0; stack.size() > 0; i++){
			System.out.println(String.valueOf(stack.pop().getReturnValue()));
		}
	}
	
	protected void testForEqualLists(List listA, List listB, boolean expectedResult, String testId) {
		System.out.print(testId + ": ");
		boolean areEqual = true;
		if (listA.size() != listB.size()) areEqual = false;
		if (areEqual){
			for (int i = 0; i < listA.size(); i++){
				if (!listA.get(i).getReturnValue().equals(listB.get(i).getReturnValue())) areEqual = false;
			}
		}
		if (expectedResult){
			if (areEqual) System.out.println("passed.");
			else System.out.println("FAILED. Lists are not equal.");
		} else {
			if (!areEqual) System.out.println("passed.");
			else System.out.println("FAILED. Lists are equal.");
		}
	}
	
	protected void testForEqualStacks(Stack stackA, Stack stackB, boolean expectedResult, String testId) {
		System.out.print(testId + ": ");
		boolean areEqual = true;
		if (stackA.size() != stackB.size()) areEqual = false;
		if (areEqual){
			for (int i = 0; i < stackA.size(); i++){
				if (!stackA.pop().getReturnValue().equals(stackB.pop().getReturnValue())) areEqual = false;
			}
		}
		if (expectedResult){
			if (areEqual) System.out.println("passed.");
			else System.out.println("FAILED. Lists are not equal.");
		} else {
			if (!areEqual) System.out.println("passed.");
			else System.out.println("FAILED. Lists are equal.");
		}
	}
	
	protected void testReference(Object a, Object b, boolean expectedResult, String testId){
		System.out.print(testId + ": ");
		if (expectedResult){
			if (a == b) System.out.println("passed.");
			else System.out.println("FAILED. Pointers do not reference the same object");
		} else {
			if (a != b) System.out.println("passed.");
			else System.out.println("FAILED. Pointers reference the same object");
		}
	}
}