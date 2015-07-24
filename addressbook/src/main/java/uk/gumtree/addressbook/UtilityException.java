package uk.gumtree.addressbook;

import java.io.FileNotFoundException;

public class UtilityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7610731015982102997L;

	public UtilityException(String string, FileNotFoundException e) {
		super(e);
	}
}
