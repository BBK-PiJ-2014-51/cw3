package tests;
import java.util.Arrays;
import java.util.Collection;

import list.ArrayList;
import list.LinkedList;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import stack.Stack;
import stack.StackImpl;
import improvedstack.ImprovedStack;
import improvedstack.ImprovedStackImpl;

@RunWith(Parameterized.class)
public class ImprovedStackTest{
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { ARRAYLIST_ID }, { LINKEDLIST_ID } };
		return Arrays.asList(data);
	}
	
	private ImprovedStack stack;
	private static final int INIT_SIZE = 12;
	private static final int ARRAYLIST_ID = 0;
	private static final int LINKEDLIST_ID = 1;
	private int currentListType;
	
	public ImprovedStackTest(int listType){
		if (listType == ARRAYLIST_ID) stack = new ImprovedStackImpl(new ArrayList());
		else if (listType == LINKEDLIST_ID) stack = new ImprovedStackImpl(new LinkedList());
		this.currentListType = listType;
	}
	
	@Test
	public void reverse(){
		ImprovedStack reversedStack = new ImprovedStackImpl();
		for (int i = 0; i < INIT_SIZE; i++){
			stack.push(new Integer(i));
		}
		for (int i = INIT_SIZE -1; i >= 0; i--){
			reversedStack.push(new Integer(i));
		}
		
		boolean allEqual = true;
		for (int i = 0; i < INIT_SIZE; i++){
			if(!stack.pop().getReturnValue().equals(reversedStack.pop().getReturnValue())) allEqual = false;
		}
		assertEquals(true, allEqual);
	}
	
	@Test 
	public void remove(){
		for (int i = 0; i <= INIT_SIZE; i++){
			stack.push(new Integer((i % 2 == 0) ? 3 : i));
			
		}
		stack.remove(new Integer(3));
		assertEquals(5, stack.size());
	}
	/* old tests
	 
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
		Test.popStack(stack, true);
		for (int i = 0; i <= initSize; i++){
			stack.push(new Integer((i % 2 == 0) ? 3 : i));
		}
		stack.remove(new Integer(3));
		test.testForExpectedValue(stack.size(), 5, "Test 02: checking size after removing specified elements");				
	}
	*/
}
