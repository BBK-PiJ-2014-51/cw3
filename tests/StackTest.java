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

	
	public StackTest(int listType){
		if (listType == ARRAYLIST_ID) stack = new StackImpl(new ArrayList());
		else if (listType == LINKEDLIST_ID) stack = new StackImpl(new LinkedList());
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

}