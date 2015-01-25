package tests;
import node.Node;
import node.NodeImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class NodeTest{
	Node node1;
	
	@Before
	public void build(){
		node1 = new NodeImpl();
	}
	
	@Test
	public void getValue(){
		node1.setValue(new Integer(5));
		assertEquals(new Integer(5), node1.getValue());
	}
	
	@Test
	public void getNext(){
		Node node2 = new NodeImpl(new Integer(10));
		node1.setNext(node2);
		assertEquals(node2, node1.getNext());
	}
}