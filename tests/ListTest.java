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
	public void removingThenAddingAtEnd(){
		initList();
		list.remove(list.size()-1);
		list.add(new Integer(20));
		assertEquals(new Integer(20),list.get(INIT_SIZE -1).getReturnValue());
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
}