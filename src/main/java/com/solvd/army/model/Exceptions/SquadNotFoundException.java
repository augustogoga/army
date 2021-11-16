package Exceptions;

public class SquadNotFoundException extends Exception {
    public SquadNotFoundException(String messageSquad){
        super(messageSquad);
    }
}
