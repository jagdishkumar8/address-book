package uk.gumtree.addressbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

	
	public void testGetOldestPerson() {
		fail("Not yet implemented");
	}

	
	public void testGetDaysDifferenceBetweenDOB() {		
		fail("Not yet implemented");
	}

}
