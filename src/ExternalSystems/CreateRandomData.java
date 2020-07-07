package ExternalSystems;

import java.time.LocalDate;
import java.util.Random;
import java.util.Vector;

public class CreateRandomData {
	private static Vector<String> clients;
	private static Vector<String> vehicles;
	private static Vector<String> travels;
	
	// ID
	private static long client_ID = 123123123;
	private static long vehicle_ID = 1122211;

	public static void main(String[] args) {
		vehicles = new Vector<String>();
		travels = new Vector<String>();
		clients = new Vector<String>();
		createRandomData();

		FileUtils.fileWriter(InterFiles.getClientRecordsPath(), clients);
		FileUtils.fileWriter(InterFiles.getVehicleRecordsPath(), vehicles);
		FileUtils.fileWriter(InterFiles.getTravelRecordsPath(), travels);
	}

	public static void print_list(String[] list) {
		for (String l : list) {
			System.out.println(l);
		}
	}

	public static void print_list(Vector<String> list) {
		for (String l : list) {
			System.out.println(l);
		}
	}

	public static void createRandomData() {
		String[] first_names = { "Ori", "Shaul", "Tomer", "Sapir", "Ben", "Eviatar", "Tami", "Gil", "Bar" };
		String[] last_names = { "Ben-Lolo", "Ben-Raz", "Cohen", "Levi", "Sigal", "Ovad", "Hazan", "Regev" };
		String[] cities = { "Tel aviv", "Petah Tikva", "Ramat gan", "Haifa", "Eilat", "Yeruham" };
		String[] mail_servers = { "gmail.com", "walla.co.il", "somemail.com", "hotmail.com" };
		Random r = new Random();
		int size = r.nextInt(10);
		for (int i = 0; i < size; i++) {
			String id = Long.toString(client_ID);
			String fname = first_names[r.nextInt(first_names.length)];
			String lname = last_names[r.nextInt(last_names.length)];
			String city = cities[r.nextInt(cities.length)];
			String email = fname + "_" + id + "@"+ mail_servers[r.nextInt(mail_servers.length)];
			clients.add(i, id + "," + fname + "," + lname + "," + city + "," + email);
			// -----------------------------------------------------
			// Creating client's vehicles
			createRandomVehicleList(id, r.nextInt(5));
			// -----------------------------------------------------
			client_ID += r.nextInt(999999) + 1000;
		}
	}

	public static void createRandomVehicleList(String owner_id, int size) {
		Random r = new Random();
		
		for (int i = 0; i < size; i++) {
			String id = Long.toString(vehicle_ID);
			String details = DMV.getVehicleProperties("");
			vehicles.add(id + "," + owner_id + "," + details);
			createRandomTravels(owner_id, id, 1+r.nextInt(100));
			vehicle_ID += (r.nextInt(999) + 100);
		}
	}



	public static void createRandomTravels(String driver_id, String vehicle_id, int num_of_travels) {
		Random r = new Random();
		LocalDate date = LocalDate.ofYearDay(r.nextInt(18) + 2000, r.nextInt(356));
		
		for (int i = 0; i < num_of_travels; i++) {
			String record = driver_id + "," + vehicle_id + ","  +convertDateToString(date);
			travels.add(record);
			date.plusDays(r.nextInt(10)+1);
		}
	}
	
	public static String convertDateToString(LocalDate date) {
		Random r = new Random();
		String year = Integer.toString(date.getYear());
		String month = Integer.toString(date.getMonthValue());
		String day = Integer.toString(date.getDayOfMonth());
		String hour = Integer.toString(r.nextInt(23));
		String min = Integer.toString(r.nextInt(59));
		return day + "-" + month + "-" + year + "-" + hour + "-" + min;
	}

}
