package returnobject;

public class ReturnObjectImpl implements ReturnObject{
	private boolean hasError;
	private ErrorMessage errMsg;
	private Object returnValue;
	
	/**
	 * Constructor used to wrap error messages
	 * 
	 * @param ErrorMsg to set initially
	 */
	public ReturnObjectImpl(ErrorMessage msg){
		hasError = !(msg == ErrorMessage.NO_ERROR);
		errMsg = msg;
		returnValue = null;
	}
	
	/**
	 * Constructor used to wrap return values
	 * 
	 * @param value to set initially
	 */
	public ReturnObjectImpl(Object value){
		hasError = false;
		errMsg = ErrorMessage.NO_ERROR;
		returnValue = value;
	}
	
	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public boolean hasError() {
		return hasError;
	}
	
	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public ErrorMessage getError() {
		return errMsg;
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public Object getReturnValue() {
		return returnValue;
	}
}