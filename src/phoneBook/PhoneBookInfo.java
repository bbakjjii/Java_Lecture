package phoneBook;

public class PhoneBookInfo {
	
	String group;
	String phoneNumber;
	String name;
	
	public PhoneBookInfo(String group, String number, String name) {
		this.group = group;
		this.phoneNumber = number;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %s, %s]", name, phoneNumber, group);
	}
}
	
	
