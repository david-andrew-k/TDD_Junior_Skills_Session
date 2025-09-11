import org.dwa.InvalidPasswordException;
import org.dwa.InvalidUsernameException;
import org.dwa.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    void TestToStringReturnsCorrectFormat() {
        User testUserObject = new User("davidandrew", "Pass12345$");
        String expected = "Username: davidandrew\nPassword: Pass12345$";
        String actual = testUserObject.toString();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"davidandrew", "user01", "AliceInWonderlandUsr", "JOHN1", "123", "PETER"})
    void TestValidUsernameSuccessfullySetsUsername(String validUsername) {
        User testUserObject = new User();
        testUserObject.setUsername(validUsername);
        String actual = testUserObject.getUsername();
        assertEquals(validUsername, actual);
    }

    @Test
    void TestInvalidUsernameTooLongThrowsInvalidUsernameException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidUsernameException.class, () -> testUserObject.setUsername("a".repeat(21)));
        String expectedMessage = "Username must be no more than 20 characters long.";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidUsernameTooShortThrowsInvalidUsernameException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidUsernameException.class, () -> testUserObject.setUsername("aa"));
        String expectedMessage = "Username must be at least 3 characters long.";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abc.", "User_01", "Alice-In-Wonderland", "JOHN!", "user name", "user@name"})
    void TestInvalidUsernameInvalidCharactersThrowsInvalidUsernameException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidUsernameException.class, () -> testUserObject.setUsername("Abc."));
        String expectedMessage = "Username can only contain letters and numbers.";
        assertEquals(expectedMessage, actual.getMessage());
    }



    @ParameterizedTest
    @ValueSource(strings = {"Password123@", "4apPlE$", "My13Password%&345678", "pA1#4"})
    void TestValidPasswordSuccessfullySetsPassword(String validPassword) {
        User testUserObject = new User();
        testUserObject.setPassword(validPassword);
        String actual = testUserObject.getPassword();
        assertEquals(validPassword, actual);
    }

    @Test
    void TestInvalidPasswordTooLongThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Pa3$" + "a".repeat(17)));
        String expectedMessage = "Password must be no more than 20 characters long.";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordTooShortThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Pa3$"));
        String expectedMessage = "Password must be at least 5 characters long.";
        assertEquals(expectedMessage, actual.getMessage());
    }
    
    @Test
    void TestInvalidPasswordNoUpperThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("pass3$"));
        String expectedMessage = "Password must include at least one uppercase letter.";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordNoLowerThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("PASS3$"));
        String expectedMessage = "Password must include at least one lowercase letter.";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordNoSymbolThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Pass34"));
        String expectedMessage = "Password must include at least one symbol (@, $, %, &, #).";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordNoNumberThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Password$"));
        String expectedMessage = "Password must include at least one number.";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordInvalidCharactersThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Pass1$£"));
        String expectedMessage = "Password contains invalid characters. Only alphanumeric characters and @, $, %, &, # are allowed.";
        assertEquals(expectedMessage, actual.getMessage());
    }


}
