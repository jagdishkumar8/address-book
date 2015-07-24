package uk.gumtree.addressbook;

import java.util.Comparator;

public class AddressBookComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		return ((AddressBook)o2).getDateOfBirth().compareTo(((AddressBook)o1).getDateOfBirth());
	}
}
