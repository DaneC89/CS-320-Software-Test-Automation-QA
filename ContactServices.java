package ContactInformation;
import java.util.ArrayList;

public class ContactServices {
	// variables to create object for this class to be used in testing
	public static String newId;
	public String newFirstName;
	public String newLastName;
	public String newPhone;
	public String newAddress;
	
	//array structure to store contact data
	public static ArrayList<Contact> contacts = new ArrayList<Contact>(0);
	
	//create a unique id
	public static String getUniId() {
		String uniqueId;
		if (contacts.isEmpty()) {
			newId = "1000000616";
		}
		else {
			int arrayList = contacts.size();
			newId = contacts.get(arrayList - 1).getid();
		}
		// convert string to int for creation of next value then back to string to add to array list
		//https://www.freecodecamp.org/news/java-string-to-int-how-to-convert-a-string-to-an-integer/
				int convInt = Integer.valueOf(newId);
				convInt += 1;
				uniqueId = Integer.toString(convInt);
				return uniqueId;
	}
	// create a contact to add to array list
	public static void addContact(String firstName, String lastName, String phone, String address) {
		String iD = getUniId();
		Contact contact = new Contact(firstName, lastName, iD, phone, address);
		contacts.add(contact);
	}
	
	//adding a contact
	public static void addContact(Contact newContact) {
		String IdTemp = newContact.getid();
		for (int i = 0; i < contacts.size(); ++i) {
			if (IdTemp.equals(contacts.get(i).getid())) {
				throw new IllegalArgumentException("ID Exists");
			}
		}
		contacts.add(newContact);
	}
	
	public static void deleteContact(String uniqueId) {
		for (int i = 0; i < contacts.size(); ++i) {
			if (uniqueId.compareTo(contacts.get(i).getid()) == 0) {
				int position = i;
				// removes contact 
				contacts.remove(position);
			}
		}
	}
	// quick search
		public static int searchContact(String uniqueId) {
			int result = 0;
			for (int i = 0; i < contacts.size(); ++i) {
				if (uniqueId.compareTo(contacts.get(i).getid()) == 0) {
					result = 1;
				}
				else {
					result = 2;
				}
			}
			return result;
		}
		// updating each variable using unique id.
		public static void updateFirstName(String uniqueId, String newFirstName) {
			for (int i = 0; i < contacts.size(); ++i) {
				if (uniqueId.compareTo(contacts.get(i).getid()) == 0) {
				contacts.get(i).setFirstName(newFirstName);
				}
			}
		}
		public static void updateLastName(String uniqueId, String newLastName) {
			for (int i = 0; i < contacts.size(); ++i) {
				if (uniqueId.compareTo(contacts.get(i).getid()) == 0) {
				contacts.get(i).setLastName(newLastName);
				}
			}
		}
		public static void updatePhone(String uniqueId, String newPhone) {
			for (int i = 0; i < contacts.size(); ++i) {
				if (uniqueId.compareTo(contacts.get(i).getid()) == 0) {
				contacts.get(i).setPhone(newPhone);
				}
			}
		}
		public static void updateAddress(String uniqueId, String newAddress) {
			for (int i = 0; i < contacts.size(); ++i) {
				if (uniqueId.compareTo(contacts.get(i).getid()) == 0) {
				contacts.get(i).setAddress(newAddress);
				}
			}
		}
		// quick find index
		public static int findIndex(String uniqueId) {
			int result = 0;
			for (int i = 0; i < contacts.size(); ++i) {
				if (uniqueId.compareTo(contacts.get(i).getid()) == 0) {
					result = i;
				}
			}
			return result;
		}
}
	
	