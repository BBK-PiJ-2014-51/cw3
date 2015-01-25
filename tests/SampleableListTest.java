package tests;
import sampleablelist.SampleableList;
import sampleablelist.SampleableListImpl;


public class SampleableListTest extends Test{

	public static void main(String[] args) {
		SampleableListTest test = new SampleableListTest();
		SampleableList list = new SampleableListImpl();
		SampleableList sampleTestList = new SampleableListImpl();
		int initSize = 12;
		
		test.testForEqualLists(list.sample(), new SampleableListImpl(), true, "Test 01: empty list should return an empty list when sample is called");
		
		for (int i = 0; i < initSize; i++){
			list.add(new Integer(i));
			if (i % 2 == 0) sampleTestList.add(new Integer(i));
		}
		test.testForEqualLists(list.sample(), sampleTestList, true, "Test 02: sample should return correctly sampled list");
		
		sampleTestList = list.sample();
		list.remove(2);
		list.add(2, new Integer(37));
		test.testForEqualLists(list.sample(), sampleTestList, false, "Test 03: list returned by sample should not share references to objects with original list");
	}

}
