public class ReturnObjectImpl implements ReturnObject{
	private boolean hasError;
	private ErrorMessage errMsg;
	private Object returnValue;
	
	/*
	 * Constructor used to wrap error messages
	 */
	public ReturnObjectImpl(ErrorMessage msg){
		hasError = !(msg == ErrorMessage.NO_ERROR);
		errMsg = msg;
		returnValue = null;
	}
	
	/*
	 * Constructor used to wrap return values
	 */
	public ReturnObjectImpl(Object value){
		hasError = false;
		errMsg = ErrorMessage.NO_ERROR;
		returnValue = value;
	}
	
	@Override
	public boolean hasError() {
		return hasError;
	}

	@Override
	public ErrorMessage getError() {
		return errMsg;
	}

	@Override
	public Object getReturnValue() {
		return returnValue;
	}
}