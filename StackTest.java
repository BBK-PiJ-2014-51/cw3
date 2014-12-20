public class StackTest extends Test{
	public static void main(String[] args) {
		StackTest test = new StackTest();
		Stack stack = new StackImpl(new ArrayList());
		int initSize = 12;
		for (int i = 0; i < 2; i++){
			if (i == 0) {
				System.out.println("Running tests on stack based on array list");
			} else if (i == 1){
				System.out.println("Running tests on stack based on linked list");
				stack = new StackImpl(new LinkedList());
			}
			test.testForExpectedValue(stack.isEmpty(), true, "Test 01: isEmpty on empty stack");
			test.testForExpectedValue(stack.top().hasError(), true, "Test 02: call top on empty stack has error");
			test.testForExpectedValue(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE, "Test 03: call top on empty stack returns empty structure error");
			test.testForExpectedValue(stack.pop().hasError(), true, "Test 04: call pop on empty stack has error");
			test.testForExpectedValue(stack.pop().getError(), ErrorMessage.EMPTY_STRUCTURE, "Test 05: call pop on empty stack returns empty structure error");
			
			for (int j = 0; j < initSize; j++){
				stack.push(new Integer(j));
			}
			test.testForExpectedValue(stack.size(), 12, "Test 06: size on loaded stack");
			test.testForExpectedValue(stack.top().getReturnValue(), new Integer(11), "Test 07: top on loaded stack");
			test.testForExpectedValue(stack.pop().getReturnValue(), new Integer(11), "Test 08: pop on loaded stack");
			stack.pop();
			stack.pop();
			test.testForExpectedValue(stack.size(), 9, "Test 09: size on loaded stack after popping");
			test.testForExpectedValue(stack.top().getReturnValue(), new Integer(8), "Test 10: top on loaded stack after popping");
			stack.push(new Integer(25));
			//test.popStack(stack);			
			test.testForExpectedValue(stack.pop().getReturnValue(), new Integer(25), "Test 11: pop on loaded stack after push");
			test.testForExpectedValue(stack.size(), 9, "Test 12: size on loaded stack after multiple operations");
		}
	}
}