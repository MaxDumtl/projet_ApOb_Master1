package application;

import domain.Event;
import domain.Room;
import domain.RoomRepository;

public class CommandAddEventToRoom extends Command{

    private RoomRepository repository;
    private int roomId;
    private Event event;

    //COnstructor help to get necessarry object to execute its "mission"
    public CommandAddEventToRoom(RoomRepository repository, int roomId, Event event) {
        this.repository = repository;
        this.roomId = roomId;
        this.event = event;
    }

    @Override
    public void execute() {
        //get the room
        Room room = this.repository.findById(this.roomId);
        //add the event to the room
        room.addEvent(this.event);

        //save the repository //TODO is it ok ?
        this.repository.save(room);

    }
}
