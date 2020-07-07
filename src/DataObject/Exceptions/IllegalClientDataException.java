package DataObject.Exceptions;

@SuppressWarnings("serial")
public class IllegalClientDataException extends IllegalDataException {

	/**
	 * @param field:
	 * - The 'field' value can be one of the follow fields -
	 *  { "ID","FirstName","LastName","City","Email","All" }
	 * @param msg
	 */
	public IllegalClientDataException(String field,String msg) {
		super(msg,field);
	}
	
}
