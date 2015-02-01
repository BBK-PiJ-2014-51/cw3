package tests;
import list.List;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sampleablelist.SampleableList;
import sampleablelist.SampleableListImpl;


public class SampleableListTest{

	private SampleableList list;
	private static final int INIT_SIZE = 12;
	
	@Before
	public void build(){
		list = new SampleableListImpl();
	}
	
	@Test
	public void emptyListReturnsEmptyList(){
		assertEquals(true, list.sample().isEmpty());
	}
	
	@Test
	public void sampleReturnsSampledList(){
		initList();
		SampleableList sampleTestList = new SampleableListImpl();
		for (int i = 0; i < INIT_SIZE; i++){
			if (i % 2 == 0) sampleTestList.add(new Integer(i));
		}
		assertEquals(true, compareListValues(sampleTestList, list.sample()));
	}
	
	@Test
	public void sampleDoesNotModifyOriginal(){
		initList();
		SampleableList sampleTestList = list.sample();
		assertEquals(false, compareListValues(sampleTestList, list));
	}
	
	@Test
	public void sampledListReturnsCopy(){
		initList();
		SampleableList sampleTestList = list.sample();
		sampleTestList.remove(3);
		list = list.sample();
		assertEquals(false, compareListValues(sampleTestList, list));
	}
	
	/*
	 * Loads list with Integers 0 - 11
	 */
	private void initList(){
		for (int i = 0; i < INIT_SIZE; i++){
			list.add(new Integer (i));
		}
	}
	
	/**
	 * Iterates through list and compares each object using equals().
	 * Returns false if any elements are not equal.
	 * 
	 * @param a first list to check
	 * @param b second list to check
	 * @return true if lists are equal, false otherwise
	 */
	private boolean compareListValues(List a, List b){
		boolean areEqual = true;
		if (a.size() != b.size()) return false;
		for (int i = 0; i < a.size(); i++){
			if (!a.get(i).getReturnValue().equals(b.get(i).getReturnValue()))
					areEqual = false;
		}
		return areEqual;
	}
}