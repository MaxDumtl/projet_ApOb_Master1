package application;

public class Worker implements Runnable{

    private BagOfCommands commands;  // dont initiate, get it from an other class with the constructor (an aggregation)

    public Worker(BagOfCommands commands) {
        this.commands = commands;
    }

    /**
     * Execute commands using thread
     * It get a command in the list and execute it as a thread (to execute parallely than other worker)
     */
    @Override
    public void run() {
        //get a command in the list
        while (true) {

            if (!this.commands.isEmpty()) {

                Command currentCommand = this.commands.getCommand();

                //execute it
                currentCommand.execute();

            } else {
                //TODO if the commend queue is empty (is it necessary to do something ?)
            }
        }
    }
}
