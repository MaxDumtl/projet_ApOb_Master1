import domain.*;
import infrastructure.*;
import ui.TerminalTextUI;

public class Main {

    public static void main(String[] args){

        //set the data test
        RoomRepositoryInMemory roomRepositoryMemory = new RoomRepositoryInMemory();

        TerminalTextUI ui = new TerminalTextUI(roomRepositoryMemory);

        //run ui
        ui.run();

    }
}
