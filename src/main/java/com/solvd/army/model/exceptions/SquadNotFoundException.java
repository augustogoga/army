package com.solvd.army.model.exceptions;

public class SquadNotFoundException extends RuntimeException {
    public SquadNotFoundException(String messageSquad){
        super(messageSquad);
    }
}
