import org.dwa.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void TestToStringReturnsCorrectFormat() {
        User testUserObject = new User("davidandrew", "Pass12345$");
        String expected = "Username: davidandrew\nPassword: Pass12345$";
        String actual = testUserObject.toString();
        assertEquals(expected,actual);
    }
}
