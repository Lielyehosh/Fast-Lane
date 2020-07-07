package DataObject.Exceptions;

@SuppressWarnings("serial")
public class IllegalTravelDataException extends IllegalDataException {
	
	
	/**
	 * @param field:
	 * 	- The 'field' value can be one of the follow fields - 
	 * { "Vehicle ID" , "Driver ID" , "Date" }
	 * @param msg
	 * 	- 
	 */
	public IllegalTravelDataException(String field,String msg) {
		super(msg,field);
	}
	
	
}
