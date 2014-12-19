public class ArrayListTest extends Test{
	public static void main(String[] args) {
		ArrayListTest test = new ArrayListTest();
		ArrayList arrayList = new ArrayList();
		int initSize = 10;
		int maxSize = 50;
		
		test.testForExpectedValue(arrayList.isEmpty(), true, "Test 01: isEmpty on new list");
		for (int i = 0; i < initSize; i++){
			arrayList.add(new Integer (i));
		}
		test.testForExpectedValue(arrayList.isEmpty(), false, "Test 02: isEmpty on loaded list");
		test.testForExpectedValue(arrayList.size(), initSize, "Test 03: checking size of loaded list");
		arrayList.add(5, new Integer(13));
		test.testForExpectedValue(arrayList.size(), initSize + 1, "Test 04: checking size of list after adding at specific index");
		test.testForExpectedValue(arrayList.get(5).getReturnValue(), new Integer(13), "Test 05: checking value at index just added");
		arrayList.remove(5);
		test.testForExpectedValue(arrayList.size(), initSize, "Test 06: checking size after removal");
		for (int i = initSize; i < maxSize; i++){
			arrayList.add(new Integer(i));
		}
		boolean correctValues = true;
		for (int i = 0; i < maxSize; i++){
			if (!arrayList.get(i).getReturnValue().equals(new Integer(i))) correctValues = false; 
		}
		test.testForExpectedValue(correctValues, true, "Test 07: checking values on longer loaded list");
		test.testForExpectedValue(arrayList.get(-1).hasError(), true, "Test 08: checking error presence on retrieval of negative index");
		test.testForExpectedValue(arrayList.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS, "Test 09: checking error message on retrieval of negative index");
		test.testForExpectedValue(arrayList.get(arrayList.size()).hasError(), true, "Test 10: checking error presence on retrieval of index greater than size of list");
		test.testForExpectedValue(arrayList.get(arrayList.size()).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS, "Test 11: checking error message on retrieval of index greater than size of list");
		test.testForExpectedValue(arrayList.get(arrayList.size()-1).hasError(), false, "Test 12: checking error presence on valid retrieval");
		test.testForExpectedValue(arrayList.get(arrayList.size()-1).getError(), ErrorMessage.NO_ERROR, "Test 13: checking error message on valid retrieval");
	}
}