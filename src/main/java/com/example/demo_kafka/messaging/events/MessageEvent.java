package com.example.demo_kafka.messaging.events;

public class MessageEvent {
    private String title;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public MessageEvent() {
    }

    public MessageEvent(String title, String firstName, String lastName, String username, String password) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                "\n dear firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "\n your account created with username='" + username + '\'' +
                "and, password='" + password + '\'' +
                "\n welcome!";
    }
}
