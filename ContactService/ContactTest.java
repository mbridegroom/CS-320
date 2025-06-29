/**Matthew Bridegroom
 * CS-320
 * June 22nd, 2025
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Tests for the Contact class
public class ContactTest {

    // Test creating a valid contact
    @Test
    public void testValidContactCreation() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", c.getId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    // Test invalid IDs cause errors
    @Test
    public void testInvalidIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test setters reject invalid data
    @Test
    public void testSettersValidation() {
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("MoreThan10Chars"));

        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("MoreThan10Chars"));

        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));

        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("This address is way too long for our limit"));
    }
}
