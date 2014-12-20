
public class FunctionalListTest extends Test {
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
		
			test.testForExpectedValue(list.head().hasError(), true, "Test 01: empty list has error on head call");
			test.testForExpectedValue(list.head().getError(), ErrorMessage.EMPTY_STRUCTURE, "Test 02: empty list has empty structure error on head call");
			test.testForExpectedValue(list.head().getReturnValue(), null, "Test 03: empty list returns null value on head call");
			test.testForEqualLists(list.rest(), (i == 0) ? new FunctionalArrayList() : new FunctionalLinkedList(), true, "Test 04: empty list returns new empty list rest call");
			
			for (int j = 0; j < initSize; j++){
					list.add(new Integer(j));
			}
			test.testForExpectedValue(list.head().hasError(), false, "Test 05: loaded list does not have error on head call");
			test.testForExpectedValue(list.head().getError(), ErrorMessage.NO_ERROR, "Test 06: loaded list returns no error on head call");
			test.testForExpectedValue(list.head().getReturnValue(), new Integer(0), "Test 07: loaded list returns correct value on head call");
			
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
}