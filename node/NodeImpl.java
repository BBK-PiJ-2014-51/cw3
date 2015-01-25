package node;

public class NodeImpl implements Node{
	private Node next;
	private Object value;
	
	public NodeImpl(){
		next = null;
		value = null;
	}
	
	public NodeImpl(Object value){
		next = null;
		this.value = value;
	}
	
	@Override
	public Node getNext() {
		return next;
	}

	@Override
	public boolean setNext(Node next) {
		this.next = next;
		return true;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public boolean setValue(Object value) {
		this.value = value;
		return true;
	}
}