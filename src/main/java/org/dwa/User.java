package org.dwa;

public class User {

    private String Username;
    private String Password;

    public User(){

    }

    public User(String username, String password){
        setUsername(username);
        setPassword(password);
    }

    public void validateUsername(String username) {
        if (username.length() < 3) {
            throw new InvalidUsernameException("Username must be at least 3 characters long.");
        }
        if (username.length() > 20) {
            throw new InvalidUsernameException("Username must be no more than 20 characters long.");
        }
        if (!username.matches("^[a-zA-Z0-9]+$")) {
            throw new InvalidUsernameException("Username can only contain letters and numbers.");
        }
    }

    public void validatePassword(String password) {
        if (password == null || password.length() < 5) {
            throw new InvalidPasswordException("Password must be at least 5 characters long.");
        }
        if (password.length() > 20) {
            throw new InvalidPasswordException("Password must be no more than 20 characters long.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password must include at least one uppercase letter.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("Password must include at least one lowercase letter.");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new InvalidPasswordException("Password must include at least one number.");
        }
        if (!password.matches(".*[@$%&#].*")) {
            throw new InvalidPasswordException("Password must include at least one symbol (@, $, %, &, #).");
        }
        if (!password.matches("^[A-Za-z0-9@$%&#]+$")) {
            throw new InvalidPasswordException("Password contains invalid characters. Only alphanumeric characters and @, $, %, &, # are allowed.");
        }
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        validateUsername(username);
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        validatePassword(password);
        Password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "Username: %s\nPassword: %s",
                getUsername(), getPassword()
        );
    }





}
