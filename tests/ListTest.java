package tests;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import list.ArrayList;
import list.LinkedList;
import list.List;
import returnobject.ErrorMessage;
import org.junit.Before;
import org.junit.Test;

@RunWith(Parameterized.class)
public class ListTest{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { new ArrayList() }, { new LinkedList() } };
		return Arrays.asList(data);
	}
	
	private List list;
	
	public ListTest(List list){
		this.list = list;
	}
	
	@Test
	public void isEmptyOnEmptyList(){
		assertEquals(true, list.isEmpty());
	}
	
	/* old tests
	public static void main(String[] args) {
		ListTest test = new ListTest();
		List list = new ArrayList();
		for (int i = 0; i < 2; i++){
			if (i == 0){
				//list = new list();
				System.out.println("Running list tests on array based list");
			}
			else if (i == 1){
				list = new LinkedList();
				System.out.println("Running list tests on linked list");
			}
			
			int initSize = 10;
			int maxSize = 50;
			
			test.testForExpectedValue(list.isEmpty(), true, "Test 01: isEmpty on new list");		
			for (int j = 0; j < initSize; j++){
				list.add(new Integer (j));
			}
			test.testForExpectedValue(list.isEmpty(), false, "Test 02: isEmpty on loaded list");
			test.testForExpectedValue(list.size(), initSize, "Test 03: checking size of loaded list");
			list.add(5, new Integer(13));
			test.testForExpectedValue(list.size(), initSize + 1, "Test 04: checking size of list after adding at specific index");
			test.testForExpectedValue(list.get(5).getReturnValue(), new Integer(13), "Test 05: checking value at index just added");
			list.remove(5);
			test.testForExpectedValue(list.size(), initSize, "Test 06: checking size after removal");
			for (int j = initSize; j < maxSize; j++){
				list.add(new Integer(j));
			}
			boolean correctValues = true;
			for (int j = 0; j < maxSize; j++){
				if (!list.get(j).getReturnValue().equals(new Integer(j))) correctValues = false; 
			}
			test.testForExpectedValue(correctValues, true, "Test 07: checking values on longer loaded list");
			test.testForExpectedValue(list.get(-1).hasError(), true, "Test 08: checking error presence on retrieval of negative index");
			test.testForExpectedValue(list.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS, "Test 09: checking error message on retrieval of negative index");
			test.testForExpectedValue(list.get(list.size()).hasError(), true, "Test 10: checking error presence on retrieval of index greater than size of list");
			test.testForExpectedValue(list.get(list.size()).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS, "Test 11: checking error message on retrieval of index greater than size of list");
			test.testForExpectedValue(list.get(list.size()-1).hasError(), false, "Test 12: checking error presence on valid retrieval");
			test.testForExpectedValue(list.get(list.size()-1).getError(), ErrorMessage.NO_ERROR, "Test 13: checking error message on valid retrieval");
			test.testForExpectedValue(list.add(null).getError(), ErrorMessage.INVALID_ARGUMENT, "Test 14: checking error message on inserting a null value");
			test.testForExpectedValue(list.add(null).hasError(), true, "Test 15: checking error presence whenn inserting a null value");
			test.testForExpectedValue(list.add(4,null).getError(), ErrorMessage.INVALID_ARGUMENT, "Test 16: checking error message on inserting a null value at specified index");
			test.testForExpectedValue(list.add(4,null).hasError(), true, "Test 17: checking error presence when inserting a null value at specified index");
			System.out.println("Printing List");
			test.printList(list);
			if (i == 0) list = new ArrayList();
			else if (i == 1) list = new LinkedList();
			
			test.testForExpectedValue(list.get(12).getError(), ErrorMessage.EMPTY_STRUCTURE, "Test 18: empty structure error when retrieving element from empty list");
			test.testForExpectedValue(list.remove(5).getError(),ErrorMessage.EMPTY_STRUCTURE , "Test 19: empty structure error when removing element from empty list");
			test.testForExpectedValue(list.add(new Integer(65)).hasError(), false, "Test 20: adding element in list should not raise error");
			test.testForExpectedValue(list.add(new Integer(63)).getError(), ErrorMessage.NO_ERROR, "Test 21: adding element in list should not raise error");
			test.testForExpectedValue(list.add(new Integer(110)).getReturnValue(), null, "Test 22: adding element to end of list should return a null value");
			test.testForExpectedValue(list.add(1, new Integer(63)).hasError(), false, "Test 23: adding element to end of list should not raise error");
			test.testForExpectedValue(list.add(1, new Integer(112)).getReturnValue(), null, "Test 24: adding element to end of list should return a null value");
			System.out.println("Printing List");
			test.printList(list);
		}
		
		
	}	*/	
}