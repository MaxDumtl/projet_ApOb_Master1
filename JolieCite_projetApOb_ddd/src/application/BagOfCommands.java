package application;

import java.util.ArrayDeque;
import java.util.Queue;

public class BagOfCommands { // Application command manager

    Queue<Command> commandsQueue = new ArrayDeque<>(); //like a list with priority
    //TODO need a constructor ?



    /**
     * To add a command
     */
    public void pushCommand(Command command){
        this.commandsQueue.add(command);
    }

    /**
     * TO (get and) remove a command
     */
    public Command getCommand(){
        return this.commandsQueue.remove();
    }

    public boolean isEmpty(){
        return this.commandsQueue.isEmpty();
    }
}
