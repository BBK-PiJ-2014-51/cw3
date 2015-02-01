package tests;
import java.util.Arrays;
import java.util.Collection;
import list.ArrayList;
import list.LinkedList;
import improvedstack.ImprovedStack;
import improvedstack.ImprovedStackImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;


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

	
	public ImprovedStackTest(int listType){
		if (listType == ARRAYLIST_ID) stack = new ImprovedStackImpl(new ArrayList());
		else if (listType == LINKEDLIST_ID) stack = new ImprovedStackImpl(new LinkedList());
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
		stack = stack.reverse();
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
}
