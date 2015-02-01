package tests;
import java.util.Arrays;
import java.util.Collection;
import functionallist.FunctionalArrayList;
import functionallist.FunctionalLinkedList;
import functionallist.FunctionalList;
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

	
	public FunctionalListTest(int listType){
		if (listType == ARRAYLIST_ID) list = new FunctionalArrayList();
		else if (listType == LINKEDLIST_ID) list = new FunctionalLinkedList();
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
	
	/**
	 * Loads list with Integers 0 - 11
	 */
	private void initList(){
		for (int i = 0; i < INIT_SIZE; i++){
			list.add(new Integer (i));
		}
	}				
}