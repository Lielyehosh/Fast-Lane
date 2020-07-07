package Driver;

import Model.*;
import View.*;
import Controller.*;
import DataObject.Exceptions.IllegalDataException;

public class Main {

	public static void main(String[] args) {
		IController C;
		try {
			IView V = new View();
			IModel M = new Model();
			C = new Controller(M, V);
			C.start();
		} catch (IllegalDataException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();	
		}
	}

}
