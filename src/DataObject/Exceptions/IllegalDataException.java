package DataObject.Exceptions;

@SuppressWarnings("serial")
public class IllegalDataException extends Exception {
	private String field;
	
	public IllegalDataException(String msg) {
		super(msg);
	}
	
	public IllegalDataException(String msg,String field) {
		super(msg);
		this.field = field;
	}
	
	public String getField() {
		return field;
	}

}
