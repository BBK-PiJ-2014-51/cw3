
public class NodeTest extends Test{
	public static void main(String[] args) {
		Node node1 = new NodeImpl();
		Node node2 = new NodeImpl(new Integer(10));
		NodeTest test = new NodeTest();
		
		node1.setValue(new Integer(5));
		test.testForExpectedValue(node1.getValue(), new Integer(5), "Test 01: set and then get node value");
		node1.setNext(node2);
		test.testForExpectedValue(node1.getNext(), node2, "Test 02: set and then get next node");
	}
}