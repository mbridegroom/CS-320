/**Matthew Bridegroom
 * CS-320
 * June 22nd, 2025
 */

import java.util.HashMap;
import java.util.Map;

// This class manages a list of contacts stored in memory.
public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact if the ID doesn't exist yet.
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Duplicate ID");
        }
        contacts.put(contact.getId(), contact);
        return true;
    }

    // Remove a contact by its ID.
    public boolean deleteContact(String id) {
        return contacts.remove(id) != null;
    }

    // Change the first name of a contact by ID
    public void updateFirstName(String id, String firstName) {
        Contact contact = getContactById(id);
        contact.setFirstName(firstName);
    }

    // Change the last name of a contact by ID
    public void updateLastName(String id, String lastName) {
        Contact contact = getContactById(id);
        contact.setLastName(lastName);
    }

    // Change the phone number of a contact by ID
    public void updatePhone(String id, String phone) {
        Contact contact = getContactById(id);
        contact.setPhone(phone);
    }

    // Change the address of a contact by ID
    public void updateAddress(String id, String address) {
        Contact contact = getContactById(id);
        contact.setAddress(address);
    }

    // Find a contact by ID or throw error if not found
    private Contact getContactById(String id) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contact;
    }
}
