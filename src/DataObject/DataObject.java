package DataObject;

import DataObject.Exceptions.IllegalDataException;

public interface DataObject {
	public String print();
	public String save();
	public String getIdentifier();
	public void load(String data) throws IllegalDataException;
}
