package uk.gumtree.addressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Utility {	
	private final int DAY_IN_MILLISECONDS = 24 * 60 * 60 * 1000;
	
	public BufferedReader getFileReader(String path) throws UtilityException{
		try {
			return new BufferedReader(new FileReader(new File(path)));
		} catch (FileNotFoundException e) {				
			throw new UtilityException("File not found", e);
		}
	}
	
	public AddressBook mapStringToAddressBook(String addressBookStr){
		AddressBook addressBook = new AddressBook();
		
		List<String> columns = Arrays.asList(addressBookStr.split(","));
		
		if(null != columns){
			final String name = columns.get(0).trim();
			if( !name.isEmpty()){
				addressBook.setName(name);
			}
			
			final String sex = columns.get(1).trim();
			if( ! sex.isEmpty()){
				addressBook.setSex((sex.equals(Sex.FEMALE.value())) ? Sex.FEMALE : Sex.MALE);
			}
			
			try {
				final String dateOfBirth = columns.get(2).trim();
				if( !dateOfBirth.isEmpty()){
					
						addressBook.setDateOfBirth(getDate(dateOfBirth));
				}
			} catch (ParseException e) {
				System.out.println("Exception parsing date");
				e.printStackTrace();
			}

		}
		
		return addressBook;
	}
	
	public Date getDate(String dateStr) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(dateStr);
	}
	
	public int getDaysBetweenDates(Date startDate, Date toDate){
		long differenceInMilliSeconds = toDate.getTime() - startDate.getTime();
		return (int) (differenceInMilliSeconds / DAY_IN_MILLISECONDS);
	}

}
