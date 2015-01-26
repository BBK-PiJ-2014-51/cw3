package tests;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;

import functionallist.FunctionalArrayList;
import functionallist.FunctionalLinkedList;
import functionallist.FunctionalList;
import list.ArrayList;
import list.LinkedList;
import list.List;
import returnobject.ErrorMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FunctionalListTest{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { ARRAYLIST_ID }, { LINKEDLIST_ID } };
		return Arrays.asList(data);
	}
	
	private FunctionalList list;
	private static final int INIT_SIZE = 12;
	private static final int ARRAYLIST_ID = 0;
	private static final int LINKEDLIST_ID = 1;
	private int currentListType;
	
	public FunctionalListTest(int listType){
		if (listType == ARRAYLIST_ID) list = new FunctionalArrayList();
		else if (listType == LINKEDLIST_ID) list = new FunctionalLinkedList();
		this.currentListType = listType;
	}
	
	@Test
	public void emptyHeadHasError(){
		assertEquals(true, list.head().hasError());
	}
	
	@Test
	public void emptyHeadHasEmptyStructError(){
		assertEquals(ErrorMessage.EMPTY_STRUCTURE, list.head().getError());
	}
	
	@Test
	public void emptyHeadHasNullValue(){
		assertEquals(null, list.head().getReturnValue());
	}
	
	@Test
	public void emptyListReturnsEmptyRest(){
		FunctionalList newList = list.rest();
		assertEquals(true, newList.isEmpty());
	}
	
	@Test
	public void loadedHeadHasError(){
		initList();
		assertEquals(false, list.head().hasError());
	}
	
	@Test
	public void loadedHeadHasNoError(){
		initList();
		assertEquals(ErrorMessage.NO_ERROR, list.head().getError());
	}
	
	@Test
	public void loadedHeadValue(){
		initList();
		assertEquals(new Integer(0), list.head().getReturnValue());
	}
	
	@Test
	public void loadedRestListSize(){
		initList();
		FunctionalList newList = list.rest();
		assertEquals(INIT_SIZE -1, newList.size());
	}
	
	@Test
	public void newHeadValue(){
		initList();
		FunctionalList newList = list.rest();
		assertEquals(new Integer(1), newList.head().getReturnValue());
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
		FunctionalListTest test = new FunctionalListTest();
		FunctionalList list = new FunctionalArrayList();
		int initSize = 12;
		
		for (int i = 0; i < 2; i++){
			if (i == 0){
				System.out.println("Running list tests on functional array based list");
			}
			else if (i == 1){
				list = new FunctionalLinkedList();
				System.out.println("Running list tests on functional linked list");
			}
		
			//test.testForExpectedValue(list.head().hasError(), true, "Test 01: empty list has error on head call");
			//test.testForExpectedValue(list.head().getError(), ErrorMessage.EMPTY_STRUCTURE, "Test 02: empty list has empty structure error on head call");
			//test.testForExpectedValue(list.head().getReturnValue(), null, "Test 03: empty list returns null value on head call");
			//test.testForEqualLists(list.rest(), (i == 0) ? new FunctionalArrayList() : new FunctionalLinkedList(), true, "Test 04: empty list returns new empty list rest call");
			
			for (int j = 0; j < initSize; j++){
					list.add(new Integer(j));
			}
			//test.testForExpectedValue(list.head().hasError(), false, "Test 05: loaded list does not have error on head call");
			//test.testForExpectedValue(list.head().getError(), ErrorMessage.NO_ERROR, "Test 06: loaded list returns no error on head call");
			//test.testForExpectedValue(list.head().getReturnValue(), new Integer(0), "Test 07: loaded list returns correct value on head call");
			
			List restTestList = (i == 0) ? new FunctionalArrayList(): new FunctionalLinkedList();
			for (int j = 1; j < initSize; j++){
				restTestList.add(new Integer(j));
			}
			test.testForEqualLists(list.rest(), restTestList, true, "Test 08: rest call returns equivalent list");
			test.testReference(list.rest(), restTestList, false, "Test 09: rest call returns different list in memory");
			
			restTestList = list.rest();
			list.remove(2);
			list.add(2, new Integer(22));
			test.testForEqualLists(list.rest(), restTestList, false, "Test 10: list returned by rest does not share references with original list");
		}
	}
	*/				
}