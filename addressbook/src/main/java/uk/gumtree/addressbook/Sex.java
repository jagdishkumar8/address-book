package uk.gumtree.addressbook;

public enum Sex {
	FEMALE("Female"),
	MALE("Male");
	
	public String sex;
	
	Sex(String sex){
		this.sex = sex;
	}
	
	public String value(){
		return this.sex;
	}
}
