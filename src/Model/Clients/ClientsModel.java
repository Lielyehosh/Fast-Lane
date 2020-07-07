package Model.Clients;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;
import java.util.function.Predicate;

import javax.swing.ImageIcon;

import DataObject.Exceptions.IllegalClientDataException;
import DataObject.Exceptions.IllegalDataException;
import ExternalSystems.Database;

/**
 * - This class using Singleton Design Pattern - It contains the follow
 * components: ClientsModel M: - An instance of the class (one and only)
 */
public class ClientsModel {
	private static ClientsModel M;

	protected Vector<Client> client_list;
	protected HashMap<String, Client> CMap;
	protected HashMap<String, Client> emails;
	protected String[] sort_types = { "ID number", "First name", "Last name", "City", "Email" };
	protected String[] search_types = { "ID number", "First name", "Last name", "City", "Email" };
	protected final static int Num_Of_Fields = 5;

	/**
	 * The constructor is a private method (Singleton) - Initialize the data
	 * structures and load the data from an external system (database)
	 * @throws IllegalDataException for 'loadData' method
	 */
	private ClientsModel() throws IllegalDataException {
		client_list = new Vector<Client>();
		CMap = new HashMap<String, Client>();
		emails = new HashMap<String, Client>();
		loadData();
	}

	public static ClientsModel getModel() throws IllegalDataException {
		if (M == null) {
			M = new ClientsModel();
		}
		return M;
	}

	// Save and Load methods

	/**
	 * - Load the clients records - Database is an external system
	 * 
	 */
	public void loadData() throws IllegalDataException {
		// --------External system communication-----------
		Vector<String> c_lines = Database.loadData("clients");
		// ------------------------------------------------
		for (String line : c_lines) {
			addNewClient(line);
		}
	}

	/**
	 * - Save the clients records - Database is an external system
	 */
	public void saveData() {
		Collection<Client> CList = CMap.values();
		Vector<String> clients_data = new Vector<String>();
		for (Client C : CList) {
			clients_data.add(C.save());
		}
		// --------External system communication-----------
		Database.saveData("clients", clients_data);
		// ------------------------------------------------
	}

	// Generic methods

	/**
	 * @param iD
	 * @return The client matching the identification number
	 */
	public Client getClient(String iD) {
		if (CMap.containsKey(iD))
			return CMap.get(iD);
		else
			return null;
	}

	/**
	 * @param iD
	 * @return An 'ImageIcon' Object with the license picture of the client - Images
	 *         is an external system
	 */
	public ImageIcon getClientLicensePic(String iD) {
		// --------External system communication-----------
		return new ImageIcon(Database.getClientLicenseCopy(iD));
		// ------------------------------------------------
	}

	/**
	 * @return the sort fields name
	 */
	public String[] getSortTypes() {
		return sort_types;
	}

	/**
	 * @return the search fields name
	 */
	public String[] getSearchTypes() {
		return search_types;
	}

	// List methods

	public Vector<Client> getList() {
		return client_list;
	}

	/**
	 * @param search_type
	 * @param search_input - This method creates a predicate of the search that
	 *                     required (according to the search_type), And calls the
	 *                     PRIVATE method 'searchBy' that using this predicate to
	 *                     reduce records from the list.
	 * 
	 *                     - The search 'types' is matching to the local array of
	 *                     the class 'search_types' - If the 'search_type' doesn't
	 *                     match any of the switch fields, it does nothing (without
	 *                     throwing exceptions).
	 */
	public void search(String search_type, String search_input) {
		switch (search_type) {
		case "ID number":
			searchBy(new Predicate<Client>() {
				public boolean test(Client t) {
					return t.getClientID().startsWith(search_input);
				}
			});
			break;
		case "First name":
			searchBy(new Predicate<Client>() {
				public boolean test(Client t) {
					return t.getFirst_name().toLowerCase().startsWith(search_input.toLowerCase());
				}
			});
			break;
		case "Last name":
			searchBy(new Predicate<Client>() {
				public boolean test(Client t) {
					return t.getLast_name().toLowerCase().startsWith(search_input.toLowerCase());
				}
			});
			break;
		case "City":
			searchBy(new Predicate<Client>() {
				public boolean test(Client t) {
					return t.getCity().toLowerCase().startsWith(search_input.toLowerCase());
				}
			});
			break;
		case "Email":
			searchBy(new Predicate<Client>() {
				public boolean test(Client t) {
					return t.getEmail().toLowerCase().startsWith(search_input.toLowerCase());
				}
			});
			break;
		default:
			break;
		}
	}

	/**
	 * @param P - a predicate that checks if a client match some condition - This
	 *          method is responsible to execute the ALGORITHM, and the condition is
	 *          given as an input. - Time complexity to the search is O(n). (while n
	 *          = |list| )
	 */
	private void searchBy(Predicate<Client> P) {
		Vector<Client> Temp = new Vector<Client>();
		for (Client C : client_list) {
			if (P.test(C)) {
				Temp.addElement(C);
			}
		}
		client_list.retainAll(Temp);
		Temp.clear();
	}

	/**
	 * - This method initialize the current list with all the existing clients in
	 * the system. - It uses 'clear' to clear the list (NOT DELETING) and adds the
	 * clients from the CMap. - NOTE: *CMap holds all the clients in the system*
	 */
	public void initList() {
		client_list.clear();
		client_list.addAll(CMap.values());
	}

	/**
	 * @param sortType - This method creates a Comparator (type: Client) according
	 *                 to the given sortType - Same as the search method, it match
	 *                 the Comparator to the required input. - If the input
	 *                 'sortType' doesn't match any of the switch fields, it does
	 *                 nothing.
	 */
	public void sortList(String sortType) {
		switch (sortType) {
		case "ID number":
			client_list.sort(new Comparator<Client>() {
				@Override
				public int compare(Client o1, Client o2) {
					return o1.getClientID().compareTo(o2.getClientID());
				}
			});
			break;
		case "First name":
			client_list.sort(new Comparator<Client>() {
				@Override
				public int compare(Client o1, Client o2) {
					String name1 = o1.getFirst_name() + " " + o1.getLast_name();
					String name2 = o2.getFirst_name() + " " + o2.getLast_name();
					return name1.compareToIgnoreCase(name2);
				}
			});
			break;
		case "Last name":
			client_list.sort(new Comparator<Client>() {
				@Override
				public int compare(Client o1, Client o2) {
					String name1 = o1.getLast_name() + " " + o1.getFirst_name();
					String name2 = o2.getLast_name() + " " + o2.getFirst_name();
					return name1.compareToIgnoreCase(name2);
				}
			});
			break;
		case "City":
			client_list.sort(new Comparator<Client>() {
				public int compare(Client o1, Client o2) {
					return o1.getCity().compareToIgnoreCase(o2.getCity());
				}
			});
			break;
		case "Email":
			client_list.sort(new Comparator<Client>() {
				public int compare(Client o1, Client o2) {
					return o1.getEmail().compareToIgnoreCase(o2.getEmail());
				}
			});
			break;
		default:
			break;
		}

	}

	// Add a client to the data structures

	// Add and Delete methods

	private void addClient(Client C) {
		CMap.put(C.getClientID(), C);
		emails.put(C.getEmail(), C);
	}

	// Add and update clients

	/**
	 * @param client_data_input - A String that holds the client's data with the
	 *                          specified format.
	 * @return - If it Successes, it return a reference to the new client object.
	 * @throws IllegalDataException: If there was a problem with one of the fields
	 *                               or with the input, The method will throw an
	 *                               exception with a matched message. - This method
	 *                               checks if the new client has a unique ID and
	 *                               Mail address, too.
	 */
	private Client createNewClient(String client_data_input) throws IllegalDataException {
		Client client = new Client();
		client.load(client_data_input);
		if (CMap.containsKey(client.getClientID())) {
			// Checks if the current client's ID doesn't appears in the system
			throw new IllegalClientDataException("ID", "Client ID is already exist");
		} else if (emails.containsKey(client.getEmail())) {
			// Checks if the current client's mail address doesn't appears in the system
			throw new IllegalClientDataException("Email", "Mail address is already exist");
		}
		return client;
	}

	private Client updateClient(Client C, String new_details) throws IllegalDataException {
		// Reference validation
		if (C == null) {
			throw new IllegalDataException("Client Object is null");
		} else if (new_details == null) {
			throw new IllegalDataException("Client_details Object is null");
		}
		// Creating a new temporary client to verify integrity
		Client updated_client = new Client();
		updated_client.loadData(new_details);
		if (updated_client.getClientID().equals(C.getClientID()) == false) {
			throw new IllegalClientDataException("ID", "ID number doesn't match the current client");
		} else if (updated_client.getEmail().equals(C.getEmail()) == false) {
			// Case there was a change with the client's mail address
			if (emails.containsKey(updated_client.getEmail())) {
				// Case there was a change, but the new mail address is already exist
				throw new IllegalClientDataException("Email", "Mail address is already exist");
			} else {
				// Case there was a change and it need to update it.
				emails.remove(C.getEmail(), C);
				C.loadData(new_details);
				emails.put(C.getEmail(), C);
			}
		} else {
			C.loadData(new_details);
		}
		return C;
	}

	// Add and Update API methods

	/**
	 * @param client_data - A String that holds the client's details in the format
	 *                    that has been specified
	 * @throws IllegalDataException - Case some of the input fields in 'client_data'
	 *                              is illegal - This method creates a new client
	 *                              and add it to the local HashMaps that holds a
	 *                              reference to the client. - There is 2 HashMaps,
	 *                              one for the ID (the key is the client ID), and
	 *                              second for the mail address (the key is the mail
	 *                              address).
	 */
	public String addNewClient(String client_data) throws IllegalDataException {
		Client C = createNewClient(client_data);
		addClient(C);
		return C.getIdentifier();
	}

	public String updateClient(String identifier, String updated_data) throws IllegalDataException {
		Client C = getClient(identifier);
		if (C == null) {
			throw new IllegalClientDataException("ID", "ID doesn't match to any client");
		}
		return updateClient(C, updated_data).getIdentifier();
	}

}
