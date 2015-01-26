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
import org.junit.Test;

@RunWith(Parameterized.class)
public class ListTest{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { ARRAYLIST_ID }, { LINKEDLIST_ID } };
		return Arrays.asList(data);
	}
	
	private List list;
	private static final int INIT_SIZE = 12;
	private static final int ARRAYLIST_ID = 0;
	private static final int LINKEDLIST_ID = 1;
	
	public ListTest(int listType){
		if (listType == ARRAYLIST_ID) list = new ArrayList();
		else if (listType == LINKEDLIST_ID) list = new LinkedList();
	}
	
	/**
	 * isEmpty() Tests
	 */
	@Test
	public void isEmptyOnEmptyList(){
		assertEquals(true, list.isEmpty());
	}
	
	@Test
	public void isEmptyAfterAdd(){
		initList();
		assertEquals(false, list.isEmpty());
	}
	
	/**
	 * size() Tests
	 */
	
	@Test
	public void sizeAfterAdd(){
		initList();
		assertEquals(INIT_SIZE, list.size());
	}
	
	@Test
	public void sizeAfterAddAtIndex(){
		initList();
		list.add(5, new Integer(12));
		assertEquals(INIT_SIZE + 1, list.size());
	}
	
	@Test
	public void sizeAfterRemove(){
		initList();
		list.remove(3);
		assertEquals(INIT_SIZE - 1, list.size());
	}
	
	/**
	 * get() tests
	 */
	@Test
	public void getFromIndex(){
		initList();
		list.add(5, new Integer(12));
		assertEquals(new Integer(12), list.get(5).getReturnValue());
	}
	
	@Test
	public void getAtEnd(){
		initList();
		assertEquals(new Integer(11), list.get(INIT_SIZE -1).getReturnValue());
	}
	
	@Test
	public void hasErrorGetNegativeIndex(){
		assertEquals(true, list.get(-2).hasError());
	}
	
	@Test
	public void getErrorGetNegativeIndex(){
		initList();
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.get(-2).getError());
	}
	
	@Test
	public void hasErrorGetLargeIndex(){
		assertEquals(true, list.get(INIT_SIZE).hasError());
	}
	
	@Test
	public void getErrorGetLargeIndex(){
		initList();
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.get(INIT_SIZE).getError());
	}
	
	@Test
	public void hasErrorGetEmptyList(){
		assertEquals(true, list.get(INIT_SIZE).hasError());
	}
	
	@Test
	public void getErrorGetEmptyList(){
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, list.get(INIT_SIZE).getError());
	}
	
	/**
	 * remove() tests
	 */
	
	@Test
	public void valueFromRemove(){
		initList();
		assertEquals(new Integer(3), list.remove(3).getReturnValue());
	}
	
	@Test
	public void nextValueAfterRemove(){
		initList();
		list.remove(3);
		assertEquals(new Integer(4), list.get(3).getReturnValue());
	}
	
	@Test
	public void removeAtBeginning(){
		initList();
		list.remove(0);
		assertEquals(new Integer(1), list.get(0).getReturnValue());
	}
	
	@Test
	public void removeAtEnd(){
		initList();
		list.remove(INIT_SIZE - 1);
		assertEquals(new Integer(10), list.get(INIT_SIZE -2).getReturnValue());
	}
	
	@Test
	public void hasErrorValidRemove(){
		initList();
		assertEquals(false, list.remove(4).hasError());
	}
	
	@Test
	public void noErrorValidRemove(){
		initList();
		assertEquals(ErrorMessage.NO_ERROR, list.remove(3).getError());
	}
	
	@Test
	public void hasErrorRemoveNegativeIndex(){
		assertEquals(true, list.remove(-2).hasError());
	}
	
	@Test
	public void getErrorRemoveNegativeIndex(){
		initList();
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.remove(-2).getError());
	}
	
	@Test
	public void hasErrorRemoveLargeIndex(){
		assertEquals(true, list.remove(INIT_SIZE).hasError());
	}
	
	@Test
	public void getErrorRemoveLargeIndex(){
		initList();
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.remove(INIT_SIZE).getError());
	}
	
	@Test
	public void hasErrorRemoveEmptyList(){
		assertEquals(true, list.remove(2).hasError());
	}
	
	@Test
	public void getErrorRemoveEmptyList(){
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, list.remove(2).getError());
	}
	
	
	/**
	 * add() tests
	 */
	
	@Test
	public void nextValueAfterAddAtIndex(){
		initList();
		list.add(5, new Integer(12));
		assertEquals(new Integer(5), list.get(6).getReturnValue());
	}
	
	@Test
	public void addAtBeginning(){
		initList();
		list.add(0, new Integer(7));
		assertEquals(new Integer(7), list.get(0).getReturnValue());
	}
	
	@Test
	public void hasErrorValidAdd(){
		assertEquals(false, list.add(new Integer(1)).hasError());
	}
	
	@Test
	public void noErrorValidAdd(){
		assertEquals(ErrorMessage.NO_ERROR, list.add(new Integer(1)).getError());
	}
	
	@Test
	public void nullValueValidAdd(){
		assertEquals(null, list.add(new Integer(1)).getReturnValue());
	}
	
	@Test
	public void hasErrorWhenAddNull(){
		assertEquals(true, list.add(null).hasError());
	}
	
	@Test
	public void hasErrorWhenAddNullAtIndex(){
		initList();
		assertEquals(true, list.add(3, null).hasError());
	}
	
	@Test
	public void getErrorWhenAddNull(){
		assertEquals(ErrorMessage.INVALID_ARGUMENT, list.add(null).getError());
	}
	
	@Test
	public void getErrorWhenAddNullAtIndex(){
		initList();
		assertEquals(ErrorMessage.INVALID_ARGUMENT, list.add(3, null).getError());
	}
	
	@Test
	public void addAtListSizeHasError(){
		initList();
		assertEquals(true, list.add(INIT_SIZE, new Integer(12)).hasError());
	}
	
	@Test
	public void addAtListSizeIndexError(){
		initList();
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, list.add(INIT_SIZE, new Integer(12)).getError());
	}
	
	/*
	 * Loads list with Integers 0 - 11
	 */
	private void initList(){
		for (int i = 0; i < INIT_SIZE; i++){
			list.add(new Integer (i));
		}
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
			
			//test.testForExpectedValue(list.isEmpty(), true, "Test 01: isEmpty on new list");		
			for (int j = 0; j < initSize; j++){
				list.add(new Integer (j));
			}
			//test.testForExpectedValue(list.isEmpty(), false, "Test 02: isEmpty on loaded list");
			//test.testForExpectedValue(list.size(), initSize, "Test 03: checking size of loaded list");
			list.add(5, new Integer(13));
			//test.testForExpectedValue(list.size(), initSize + 1, "Test 04: checking size of list after adding at specific index");
			//test.testForExpectedValue(list.get(5).getReturnValue(), new Integer(13), "Test 05: checking value at index just added");
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
			//test.testForExpectedValue(list.get(-1).hasError(), true, "Test 08: checking error presence on retrieval of negative index");
			//test.testForExpectedValue(list.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS, "Test 09: checking error message on retrieval of negative index");
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