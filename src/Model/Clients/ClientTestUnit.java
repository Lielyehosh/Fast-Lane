package Model.Clients;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import DataObject.Exceptions.IllegalClientDataException;
import DataObject.Exceptions.IllegalDataException;


class ClientTestUnit {

	@DisplayName("Client ID tests")
	@Test
	void testID() {
		Client C = new Client();
		assertThrows(IllegalDataException.class, () -> C.setClientID(null));
		assertThrows(IllegalClientDataException.class, () -> C.setClientID("1234-1234"));
		assertThrows(IllegalClientDataException.class, () -> C.setClientID("12312312l"));
		assertThrows(IllegalClientDataException.class, () -> C.setClientID("1239999999"));
		assertThrows(IllegalClientDataException.class, () -> C.setClientID(""));
		assertThrows(IllegalClientDataException.class, () -> C.setClientID("oneoneone"));
	}
	
	@DisplayName("First Name tests")
	@Test
	void testFirstName() {
		Client C = new Client();
		assertThrows(IllegalDataException.class, () -> C.setFirst_name(null));
		assertThrows(IllegalClientDataException.class, () -> C.setFirst_name(" aaa"));
		assertThrows(IllegalClientDataException.class, () -> C.setFirst_name("2aaa"));
		assertThrows(IllegalClientDataException.class, () -> C.setFirst_name("aa4a"));
		assertThrows(IllegalClientDataException.class, () -> C.setFirst_name("aaa.s"));
		assertThrows(IllegalClientDataException.class, () -> C.setFirst_name("BaaaA"));
		assertThrows(IllegalClientDataException.class, () -> C.setFirst_name("aaa bbb"));
	}
	
	@DisplayName("Last Name tests")
	@Test
	void testLastName() {
		Client C = new Client();
		assertThrows(IllegalDataException.class, () -> C.setLast_name(null));
		assertThrows(IllegalClientDataException.class, () -> C.setLast_name(" aa - a2a "));
		assertThrows(IllegalClientDataException.class, () -> C.setLast_name(""));
		assertThrows(IllegalClientDataException.class, () -> C.setLast_name("aaa.s"));
//		assertThrows(IllegalClientDataException.class, () -> C.setLast_name("aaa bbb"));
	}
	
	@DisplayName("City tests")
	@Test
	void testCity() {
		Client C = new Client();
		assertThrows(IllegalDataException.class, () -> C.setCity(null));
		assertThrows(IllegalClientDataException.class, () -> C.setCity(""));
		assertThrows(IllegalClientDataException.class, () -> C.setCity(" Tel "));
		assertThrows(IllegalClientDataException.class, () -> C.setCity("Tel--Aviv"));
		assertThrows(IllegalClientDataException.class, () -> C.setCity("tel-Aviv"));
		assertThrows(IllegalClientDataException.class, () -> C.setCity("Tel-Aviv"));
		assertThrows(IllegalClientDataException.class, () -> C.setCity("Tel-aviv"));
		assertThrows(IllegalClientDataException.class, () -> C.setCity("Tel-Aviv"));
		assertThrows(IllegalClientDataException.class, () -> C.setCity("Tel-aviv"));

		
	}
	
	@DisplayName("Client Email tests")
	@Test
	void testEmail() {
		Client C = new Client();
		assertThrows(IllegalDataException.class, () -> C.setEmail(null));
		assertThrows(IllegalClientDataException.class , () -> C.setEmail(""));
		assertThrows(IllegalClientDataException.class , () -> C.setEmail("@gmail.com"));
		assertThrows(IllegalClientDataException.class , () -> C.setEmail(" @gmail.com"));
		assertThrows(IllegalClientDataException.class , () -> C.setEmail("aaa@gcom"));
		assertThrows(IllegalClientDataException.class , () -> C.setEmail("aa.a@gcom"));
		assertThrows(IllegalClientDataException.class , () -> C.setEmail("12 3@g.com"));
		assertThrows(IllegalClientDataException.class , () -> C.setEmail("123@gcom."));
	}
	
	@DisplayName("setField tests")
	@Test
	void testFields() {
		Client C = new Client();
		assertThrows(IllegalDataException.class, () -> C.setFields(new String[]{"f","f","f","f"}));
		assertThrows(IllegalDataException.class, () -> C.setFields(new String[]{"f","f","f","f","f","f"}));
	}

	@DisplayName("Load client data tests")
	@Test
	void testLoadData() {
		Client C = new Client();
		assertThrows(IllegalDataException.class, ()-> C.loadData(null));
		assertThrows(IllegalDataException.class, ()-> C.loadData("123456789,Name,Last name,City"));
	}

	@DisplayName("Save client data tests")
	@Test
	void testSaveData() {
		Client C = new Client();
		try {
			C.loadData("123456789,Name,last,City,mail@gmail.com");
		} catch (IllegalDataException e) {
			fail("Should be loaded");
		}
		assertEquals(5, C.save().split(",").length);
	}
	
	@DisplayName("Get Identifier tests")
	@Test
	void testGetIdentifier() {
		Client C = new Client();
		try {
			C.loadData("123456789,Name,last,City,mail@gmail.com");
		} catch (IllegalDataException e) {
			fail("Should be loaded");
		}
		assertSame(C.getClientID(), C.getIdentifier());
		assertNotSame(C.getIdentifier(), "123456789");
	}
	
}