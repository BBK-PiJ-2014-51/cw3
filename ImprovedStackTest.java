
public class ImprovedStackTest extends Test {

	public static void main(String[] args) {
		ImprovedStackTest test = new ImprovedStackTest();
		ImprovedStack stack = new ImprovedStackImpl();
		ImprovedStack reversedStack = new ImprovedStackImpl();
		int initSize = 12;
		
		for (int i = 0; i < initSize; i++){
			stack.push(new Integer(i));
		}
		for (int i = initSize -1; i >= 0; i--){
			reversedStack.push(new Integer(i));
		}
		
		test.testForEqualStacks(stack.reverse(), reversedStack, true, "Test 01: reverse should produce reversed stack");
		
		for (int i = 0; i <= initSize; i++){
			stack.push(new Integer((i % 2 == 0) ? 3 : i));
		}
		stack.remove(new Integer(3));
		test.testForExpectedValue(stack.size(), 6, "Test 02: checking size after removing specified elements");
		test.popStack(stack);		
	}

}
