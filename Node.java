public interface Node {
	
	/**
	 * Gets the next element in the list
	 * 
	 * @return next element in the list
	 */
	Node getNext();
	
	/**
	 * Sets the next element in the list
	 * @param element to be added to the list
	 * @return true if added to the list, false otherwise
	 */
	boolean setNext(Node next);
	
	/**
	 * Gets object stored in node of list
	 * @return object stored in node
	 */
	Object getValue();
	
	/**
	 * Stores object in node
	 * @param object to be stored in the node
	 * @return false if object is stored, false otherwise
	 */
	boolean setValue(Object value);
}
