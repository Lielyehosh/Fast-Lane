package DataObject.Exceptions;

@SuppressWarnings("serial")
public class IllegalVehicleDataException extends IllegalDataException {

	/**
	 * @param field:
	 * - The 'field' value can be one of the follow fields - 
	 * - { "VehicleID","OwnerID","Type","Company","Model","All" }
	 * @param msg
	 */
	public IllegalVehicleDataException(String field,String msg) {
		super(msg,field);
	}
	
	
}
