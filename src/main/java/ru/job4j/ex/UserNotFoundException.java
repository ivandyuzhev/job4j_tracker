package ru.job4j.ex;

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}