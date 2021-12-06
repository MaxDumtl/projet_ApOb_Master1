package application;

public class Worker implements Runnable{

    private BagOfCommands commands;  // dont initiate, get it from an other class (an aggregation)

    public Worker(BagOfCommands commands) {
        this.commands = commands; //TODO maybe protect it with synch etc ... (idk its the teacher)
    }

    /**
     * Execute commands using thread
     * It get a command in the list and execute it as a thread (to execute parallely than other worker)
     */
    @Override
    public void run(){
        //TODO use a Thread (and Comand.execute() )
        //TODO check if jsut like that, it is necessary to run the thread by overriding or if need more code

        //get a command in the list
        if(!this.commands.isEmpty()){
            Command currentCommand = this.commands.getCommand();

            //execute it
            currentCommand.execute();

        } else {
            //TODO if the commend queue is empty (is it necessary to do something ?)
        }
    }
}
