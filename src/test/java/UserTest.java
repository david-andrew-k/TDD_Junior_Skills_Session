import org.dwa.InvalidPasswordException;
import org.dwa.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    void TestToStringReturnsCorrectFormat() {
        User testUserObject = new User("davidandrew", "12345");
        String expected = "Username: davidandrew\nPassword: 12345";
        String actual = testUserObject.toString();
        assertEquals(expected,actual);
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
        String expectedMessage = "Password is too long!";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordTooShortThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Pa3$"));
        String expectedMessage = "Password is too short!";
        assertEquals(expectedMessage, actual.getMessage());
    }
    
    @Test
    void TestInvalidPasswordNoUpperThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("pass3$"));
        String expectedMessage = "Password must contain at least 1 upper!";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordNoLowerThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("PASS3$"));
        String expectedMessage = "Password must contain at least 1 lower!";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordNoSymbolThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Pass34"));
        String expectedMessage = "Password must contain at least 1 symbol!";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordNoNumberThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Password$"));
        String expectedMessage = "Password must contain at least 1 number!";
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void TestInvalidPasswordInvalidCharactersThrowsInvalidPasswordException(){
        User testUserObject = new User();
        Exception actual = assertThrows(InvalidPasswordException.class, () -> testUserObject.setPassword("Pass1$£"));
        String expectedMessage = "Password contains invalid characters!";
        assertEquals(expectedMessage, actual.getMessage());
    }


}
