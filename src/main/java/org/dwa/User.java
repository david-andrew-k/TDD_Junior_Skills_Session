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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
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
