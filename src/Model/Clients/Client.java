package Model.Clients;

import java.util.regex.Pattern;

import DataObject.DataObject;
import DataObject.Exceptions.IllegalClientDataException;
import DataObject.Exceptions.IllegalDataException;

public class Client implements DataObject {
	protected String client_ID;
	protected String first_name;
	protected String last_name;
	protected String city;
	protected String email;
	protected static final int num_of_fields = 5;

	/**
	 * @param data
	 * @throws IllegalClientDataException - DATA FORMAT: "ID,First name,Last
	 *                                    name,City,Email"
	 */
	public Client() {

	}

	// getters and setters

	public String getCity() {
		return city;
	}

	public String getEmail() {
		return email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getClientID() {
		return client_ID;
	}

	public void setCity(String city) throws IllegalDataException {
		if (city == null) {
			throw new IllegalDataException("City is null");
		} else if (city.isEmpty()) {
			throw new IllegalClientDataException("City", "City is missing");
		} else if (city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)") == false) {
			throw new IllegalClientDataException("City", "City is illegal");
		}
		this.city = city;
	}

	public void setEmail(String email) throws IllegalDataException {
		if (email == null) {
			throw new IllegalDataException("Email address is null");
		} else if (email.isEmpty()) {
			throw new IllegalClientDataException("Email", "Email is missing");
		} else {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
					+ "A-Z]{2,7}$";
			Pattern pat = Pattern.compile(emailRegex);
			if (pat.matcher(email).matches() == false) {
				throw new IllegalClientDataException("Email", "Illegal mail address " + email);
			}
		}
		this.email = email;
	}

	public void setFirst_name(String first_name) throws IllegalDataException {
		if (first_name == null) {
			throw new IllegalDataException("First name is null");
		} else if (first_name.isEmpty()) {
			throw new IllegalClientDataException("FirstName", "First name is missing");
		} else if (first_name.matches("[A-Z][a-z]*") == false) {
			throw new IllegalClientDataException("FirstName", "First name is illegal");
		}
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) throws IllegalDataException {
		if (last_name == null) {
			throw new IllegalDataException("last name is null");
		} else if (last_name.isEmpty()) {
			throw new IllegalClientDataException("LastName", "Last name is missing");
		} else if (last_name.matches("[a-zA-z]+([ '-][a-zA-Z]+)*") == false) {
			throw new IllegalClientDataException("LastName", "Last name is illegal");
		}
		this.last_name = last_name;
	}

	public void setClientID(String iD) throws IllegalDataException {
		if (iD == null) {
			throw new IllegalDataException("Client ID is null");
		} else if (iD.length() != 9) {
			throw new IllegalClientDataException("ID", "Illegal ID length");
		} else if (iD.matches("\\d{9}") == false) {
			throw new IllegalClientDataException("ID", "Illegal ID numbers");
		}
		client_ID = iD;
	}

	public void setFields(String[] fields) throws IllegalDataException {
		if (fields.length != num_of_fields) {
			throw new IllegalDataException("Missing fields");
		}
		setClientID(fields[0]);
		setFirst_name(fields[1]);
		setLast_name(fields[2]);
		setCity(fields[3]);
		setEmail(fields[4]);
	}

	/*
	 * - DATA FORMAT: "ID,First name,Last name,City,Email"
	 */
	public void loadData(String data) throws IllegalDataException {
		if (data == null) {
			throw new IllegalDataException("Illegal INPUT - The input data is null");
		}
		String[] fields = data.split(",");
		if (fields.length != num_of_fields) {
			throw new IllegalDataException("Illegal INPUT - Missing fields");
		}
		setFields(fields);
	}

	/**
	 * @return the client's data in the correct format
	 */
	@Override
	public String save() {
		return getClientID() + "," + getFirst_name() + "," + getLast_name() + "," + getCity() + "," + getEmail();
	}

	public String toString() {
		return getClientID() + " - \t" + getFirst_name() + " " + getLast_name() + '\t' + "\t- " + getCity();
	}

	@Override
	public String print() {
		return "ID number: " + getClientID() + "\n" + "First name: " + getFirst_name() + "\n" + "Last name: "
				+ getLast_name() + "\n" + "City: " + getCity() + "\n" + "Email: " + getEmail();
	}

	@Override
	public String getIdentifier() {
		return getClientID();
	}

	@Override
	public void load(String data) throws IllegalDataException {
		if (data == null) {
			throw new IllegalDataException("Illegal INPUT - The input data is null");
		}
		String[] fields = data.split(",");
		if (fields.length != num_of_fields) {
			throw new IllegalDataException("Illegal INPUT - Missing fields");
		}
		setFields(fields);
	}

}