package uk.gumtree.addressbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		List<AddressBook> addressBook = 
					addressBooks.stream()
						.filter(e -> e.sex.equals(Sex.MALE))
						.collect(Collectors.toList());
		
		return addressBook.size();
	}
	
	public String getOldestPerson(List<AddressBook> addressBooks){
		AddressBookComparator<AddressBook> ageComparator = new AddressBookComparator<AddressBook>();
		Optional<AddressBook> oldest = addressBooks.stream()
									.max(ageComparator);
		
		return ( oldest.isPresent() ) ? oldest.get().name : null ;
	}
	
	public int getDaysDifferenceBetweenDOB(AddressBook address1, AddressBook address2){
		utility = new Utility();
		return utility.getDaysBetweenDates(address1.dateOfBirth, address2.dateOfBirth);
	}
}
