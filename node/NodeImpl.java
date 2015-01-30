package node;

public class NodeImpl implements Node{
	private Node next;
	private Object value;
	
	/**
	 * Constructor initializes variables to null. 
	 */
	public NodeImpl(){
		next = null;
		value = null;
	}
	
	/**
	 * Constructor initializes data to object.
	 * 
	 *  @param Object to initialize value with.
	 */
	public NodeImpl(Object value){
		next = null;
		this.value = value;
	}
	
	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public Node getNext() {
		return next;
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public boolean setNext(Node next) {
		this.next = next;
		return true;
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public Object getValue() {
		return value;
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public boolean setValue(Object value) {
		this.value = value;
		return true;
	}
}