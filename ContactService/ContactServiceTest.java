/**Matthew Bridegroom
 * CS-320
 * June 22nd, 2025
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Tests for the ContactService class
public class ContactServiceTest {
    private ContactService service;

    // Setup a new ContactService before each test
    @BeforeEach
    public void setup() {
        service = new ContactService();
    }

    // Test adding a contact works
    @Test
    public void testAddContactSuccess() {
        Contact c = new Contact("abc123", "Alice", "Smith", "0123456789", "456 Elm St");
        assertTrue(service.addContact(c));
    }

    // Test adding a duplicate ID causes error
    @Test
    public void testAddContactDuplicateIdThrows() {
        Contact c1 = new Contact("abc123", "Alice", "Smith", "0123456789", "456 Elm St");
        Contact c2 = new Contact("abc123", "Bob", "Jones", "9876543210", "789 Oak St");
        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    // Test deleting a contact works
    @Test
    public void testDeleteContactSuccess() {
        Contact c = new Contact("abc123", "Alice", "Smith", "0123456789", "456 Elm St");
        service.addContact(c);
        assertTrue(service.deleteContact("abc123"));
    }

    // Test deleting a contact that does not exist returns false
    @Test
    public void testDeleteContactNotFound() {
        assertFalse(service.deleteContact("noID"));
    }

    // Test updating fields works
    @Test
    public void testUpdateContactFields() {
        Contact c = new Contact("abc123", "Alice", "Smith", "0123456789", "456 Elm St");
        service.addContact(c);

        service.updateFirstName("abc123", "Alicia");
        assertEquals("Alicia", c.getFirstName());

        service.updateLastName("abc123", "Johnson");
        assertEquals("Johnson", c.getLastName());

        service.updatePhone("abc123", "0987654321");
        assertEquals("0987654321", c.getPhone());

        service.updateAddress("abc123", "789 Pine St");
        assertEquals("789 Pine St", c.getAddress());
    }

    // Test updating a contact that does not exist throws error
    @Test
    public void testUpdateNonexistentContactThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("noID", "Name"));
    }
}
