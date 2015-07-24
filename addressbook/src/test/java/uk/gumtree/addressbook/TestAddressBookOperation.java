package uk.gumtree.addressbook;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestAddressBookOperation {
	AddressBookOperation operation;
	String filePath;
	List<AddressBook> addressBooks;
	
	@Before
	public void setUp() throws Exception {
		filePath = "src/test/resources/AddressBook";
		operation = new AddressBookOperation();
		addressBooks = operation.getAddressBook(filePath);
	}
	
	@Test
	public void getAddressBook(){
		final List<AddressBook> addressBooks = operation.getAddressBook(filePath);
		
		assertEquals("There are 5 records in AddressBook", 5, addressBooks.size());
	}
	
	@Test
	public void testGetNoOfMales() throws IOException {
		assertEquals("There are 3 males in AddressBook", 3, operation.getNoOfMales(addressBooks));		
	}

	@Test
	public void testGetOldestPerson() {
		assertEquals("Wes jackson is the olderst Person in AddressBook", "Wes Jackson", operation.getOldestPerson(addressBooks));		
	}

	
	@Test
	public void testGetDaysDifferenceBetweenDOB() {		
		assertEquals("There is 2862 days between Bill and Paul", 2862, operation.getDaysDifferenceBetweenDOB(addressBooks.get(0), addressBooks.get(1)));	
	}

}
