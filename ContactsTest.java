package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ContactInformation.Contact;

class ContactsTest {
	//Tests to ensure that character limit is met
	@Test
	void testContact() {
		Contact contact = new Contact("Maximus", "Clark", "pup1000000", "5556062014", "8909 4 Peats Way");
		assertTrue(contact.getfirstName().equals("Maximus"));
		assertTrue(contact.getlastName().equals("Clark"));
		assertTrue(contact.getid().equals("pup1000000"));
		assertTrue(contact.getphone().equals("5556062014"));
		assertTrue(contact.getaddress().equals("8909 4 Peats Way"));
	}
	//Tests that exception is thrown if first name is over 10 characters
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus Decimus Meridius", "Clark", "pup1000000", "5556062014", "8909 4 Peats Way");
		}); 
	}
	// Test that exception is throw if first name is 'null'
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Clark", "pup1000000", "5556062014", "8909 4 Peats Way");
		}); 
	}
	//Test that exception is throw if last name is over 10 characters
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus", "Clark Decimus Meridius", "pup1000000", "5556062014", "8909 4 Peats Way");
		}); 
	}
	//Test that exception is throw if last name is 'null'
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus", null, "pup1000000", "5556062014", "8909 4 Peats Way");
		}); 
	}
	
	//Test that exception is throw if id is over 10 characters
	@Test
	void testContactIdtooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus", "Clark", "pup100000089", "5556062014", "8909 4 Peats Way");
		}); 
	}
	
	//Test that exception is throw if id is 'null'
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus Decimus Meridius", "Clark", null, "5556062014", "8909 4 Peats Way");
		}); 
	}
	
	//Test that exception is throw if phone number is over 10 characters
	@Test
	void testContacPhoneIsTooLarge() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus Decimus Meridius", "Clark", "pup1000000", "15556062014", "8909 4 Peats Way");
		}); 
	}
	
	//Test that exception is throw if phone number is less than 10 characters
	@Test
	void testContactPhoneIsTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus Decimus Meridius", "Clark", "pup1000000", "6062014", "8909 4 Peats Way");
		}); 
	}
	
	//Test that exception is throw if phone number is 'null'
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus Decimus Meridius", "Clark", "pup1000000", null, "8909 4 Peats Way");
		}); 
	}
	
	//Test that exception is throw if address is over 30 characters
	@Test
	void testContactAddressIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus Decimus Meridius", "Clark", "pup1000000", "5556062014", "8909 4 Peats Way, San Antonio, TX 78251");
		}); 
	}
	
	//Test that exception is throw if address is 'null'
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Maximus Decimus Meridius", "Clark", "pup1000000", "5556062014", null);
		}); 
	}
}	

