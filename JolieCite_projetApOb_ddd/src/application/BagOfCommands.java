package application;

import java.util.ArrayDeque;
import java.util.Queue;

public class BagOfCommands { // Application command manager

    Queue<Command> commandsQueue; //like a list with priority

    public BagOfCommands() {
        this.commandsQueue = new ArrayDeque<>();
    }

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

    /**
     * To know if the bag of commands is empty
     * @return true if the bag is empty, false else
     */
    public boolean isEmpty(){
        return this.commandsQueue.isEmpty();
    }
}
