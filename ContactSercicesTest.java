package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ContactInformation.Contact;
import ContactInformation.ContactServices;

class ContactSercicesTest {
// Creates contact for tests
		@Test
		void testContactServiceClass() {
			ContactServices.addContact("Maximus", "Clark", "5556062014", "8909 4 Peats Dr SA, TX, 78254");
				
			assertTrue(ContactServices.contacts.get(0).getfirstName().equals("Maximus"));
			assertTrue(ContactServices.contacts.get(0).getlastName().equals("Clark"));
			assertTrue(ContactServices.contacts.get(0).getid().equals("1000000617"));
			assertTrue(ContactServices.contacts.get(0).getphone().equals("5556062014"));
			assertTrue(ContactServices.contacts.get(0).getaddress().equals("8909 4 Peats Dr SA, TX, 78254"));
		}
	
		// update first name
		@Test
		void testContactServiceUpdateFirstName() {
			ContactServices.addContact("Odin", "Rodriguez", "5555152015", "9389 Valhalla Trl");
			int size = ContactServices.contacts.size();
			ContactServices.updateFirstName("1000000618", "Kitty");
			assertTrue(ContactServices.contacts.get(size - 1).getfirstName().equals("Kitty"));
		}
		
		//update last name
		@Test
		void testContactServiceUpdateLastName() {
			int size = ContactServices.contacts.size();
			ContactServices.updateLastName("1000000618", "Daneson");
			assertTrue(ContactServices.contacts.get(size - 1).getlastName().equals("Daneson"));
		}
		// update phone number
		@Test
		void testContactServiceUpdatePhone() {
			int target = 0;
			target = ContactServices.findIndex("1000000618");
			ContactServices.updatePhone("1000000618", "5551234567");
			assertTrue(ContactServices.contacts.get(target).getphone().equals("5551234567"));
		}
		// update address
		@Test
		void testContactServiceUpdatesAddress() {
			int target = 0;
			target = ContactServices.findIndex("1000000618");
			ContactServices.updateAddress("1000000618", "9389 Valhalla Trl, Midgar");
			assertTrue(ContactServices.contacts.get(target).getaddress().equals("9389 Valhalla Trl, Midgar"));
		}
		
		// deletes contact
		@Test
		void testContactServiceDelete() {
			ContactServices.addContact("Maximus", "Clark", "5556062014", "60614 8 Peats Dr SA, TX, 78254");
			ContactServices.contacts.size();
			ContactServices.deleteContact("1000000618");
			assertTrue(ContactServices.searchContact("1000000618") == 2);
		}
		
		// verifies unique ID Exists
		@Test
		void testContactServiceUniqueId() {
			Contact newContact = new Contact("Tony", "Stark", "1000000616", "1836497719","200 Park Avenue, NY, NY, 10022");
			ContactServices.addContact(newContact);
			Contact sameId = new Contact("Tony", "Stark", "1000000616", "1836497719","200 Park Avenue, NY, NY, 10022");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				ContactServices.addContact(sameId);
			});
	}

}

