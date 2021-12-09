package application;

public class Worker {

    private BagOfCommands commands;  // dont initiate, get it from an other class with the constructor (an aggregation)

    public Worker(BagOfCommands commands) {
        this.commands = commands;
    }

    /**
     * Execute a command from the list and execute it
     */
    public void run() {
        //get a command in the list
        while (!this.commands.isEmpty()) {

            Command currentCommand = this.commands.getCommand();

            //execute it
            currentCommand.execute();
        }
    }
}
