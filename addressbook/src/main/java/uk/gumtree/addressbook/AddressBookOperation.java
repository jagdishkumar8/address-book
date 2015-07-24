package uk.gumtree.addressbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookOperation {
	
	private Utility utility;
	
	public List<AddressBook> getAddressBook(String filePath){
		utility = new Utility();
		List<AddressBook> addressBooks = new ArrayList<AddressBook>();
		
		try{
			BufferedReader reader = utility.getFileReader(filePath);			
		
			String line = null;
			while((line = reader.readLine()) != null){
				addressBooks.add(utility.mapStringToAddressBook(line));
			}

		}catch(UtilityException e){
    		System.out.println("Error opening file");
    	}
		catch(IOException e){
    		System.out.println("Error reading file");
    	}
		
		return addressBooks;
	}
	
	public int getNoOfMales(List<AddressBook> addressBooks){
		return 0;
	}
	
	public AddressBook getOldestPerson(List<AddressBook> addressBooks){
		return null;
	}
	
	public long getDaysDifferenceBetweenDOB(AddressBook address1, AddressBook address2){
		return 0;
	}
}
