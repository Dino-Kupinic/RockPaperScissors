package org.example.scheresteinpapier.Exceptions;

public class InvalidComputerAction extends Exception {
    public InvalidComputerAction() {
        super("This value is a not a valid argument for an action");
    }
}
