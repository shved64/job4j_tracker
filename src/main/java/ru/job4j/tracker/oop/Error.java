package ru.job4j.tracker.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error(false, 25, "Problem");
        Error errorOne = new Error(true, 1, "No problem");
        Error two = new Error();
        error.printInfo();
        errorOne.printInfo();
        two.printInfo();
    }
}
