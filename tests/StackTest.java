package tests;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import list.ArrayList;
import list.LinkedList;
import returnobject.ErrorMessage;
import stack.Stack;
import stack.StackImpl;

import org.junit.Test;

@RunWith(Parameterized.class)
public class StackTest{
	
		@Parameters
		public static Collection<Object[]> data() {
			Object[][] data = new Object[][] { { ARRAYLIST_ID }, { LINKEDLIST_ID } };
			return Arrays.asList(data);
		}
		
		private Stack stack;
		private static final int INIT_SIZE = 12;
		private static final int ARRAYLIST_ID = 0;
		private static final int LINKEDLIST_ID = 1;
		private int currentListType;
		
		public StackTest(int listType){
			if (listType == ARRAYLIST_ID) stack = new StackImpl(new ArrayList());
			else if (listType == LINKEDLIST_ID) stack = new StackImpl(new LinkedList());
			this.currentListType = listType;
		}
		
	@Test
	public void isEmptyOnEmptyStack(){
		assertEquals(true, stack.isEmpty());
	}
	
	@Test
	public void isEmptyOnLoadedStack(){
		initList();
		assertEquals(false, stack.isEmpty());
	}
	
	@Test
	public void topOnEmptyStackHasError(){
		assertEquals(true, stack.top().hasError());
	}
	
	@Test
	public void topOnEmptyStackReturnsEmptyStructError(){
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack.top().getError());
	}
	

	@Test
	public void popOnEmptyStackHasError(){
		assertEquals(true, stack.pop().hasError());
	}
	
	@Test
	public void popOnEmptyStackReturnsEmptyStructError(){
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, stack.pop().getError());
	}
	
	@Test
	public void popOnLoadedStack(){
		initList();
		assertEquals(new Integer(INIT_SIZE - 1), stack.pop().getReturnValue());
	}
	
	@Test
	public void topOnLoadedStack(){
		initList();
		assertEquals(new Integer(INIT_SIZE - 1), stack.top().getReturnValue());
	}
	
	@Test
	public void sizeOnLoadedStack(){
		initList();
		assertEquals(INIT_SIZE, stack.size());
	}
	
	
	@Test
	public void sizeAfterPop(){
		initList();
		stack.pop();
		assertEquals(INIT_SIZE - 1, stack.size());
	}
	
	@Test
	public void topAfterPop(){
		initList();
		stack.pop();
		assertEquals(new Integer(INIT_SIZE - 2), stack.top().getReturnValue());
	}
	
	@Test
	public void topAfterPushAfterPop(){
		initList();
		stack.push(stack.pop().getReturnValue());
		assertEquals(new Integer(INIT_SIZE - 1), stack.top().getReturnValue());
	}
	
	/*
	 * Loads list with Integers 0 - 11
	 */
	private void initList(){
		for (int i = 0; i < INIT_SIZE; i++){
			stack.push(new Integer (i));
		}
	}
	
	
	/* old tests
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
	*/
}