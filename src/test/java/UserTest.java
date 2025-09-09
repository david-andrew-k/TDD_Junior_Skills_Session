import org.dwa.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void TestToStringReturnsCorrectFormat() {
        User testUserObject = new User("davidandrew", "12345");
        String expected = "Username: davidandrew\nPassword: 12345";
        String actual = testUserObject.toString();
        assertEquals(expected,actual);
    }
}
