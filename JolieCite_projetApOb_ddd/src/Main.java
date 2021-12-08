import infrastructure.RoomRepositoryInMemory;
import ui.TerminalTextUI;

public class Main {

    public static void main(String[] args){

        //set the data test
        RoomRepositoryInMemory roomRepositoryMemory = new RoomRepositoryInMemory();

        TerminalTextUI ui = new TerminalTextUI();

        //run ui
        ui.run();

    }
}
