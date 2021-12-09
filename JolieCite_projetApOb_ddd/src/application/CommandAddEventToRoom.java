package application;

import domain.*;

public class CommandAddEventToRoom extends Command{

    private RoomRepository repository;
    private int roomId;
    private int eventId;

    //COnstructor help to get necessarry object to execute its "mission"
    public CommandAddEventToRoom(RoomRepository repository, int roomId, int eventId) {
        this.repository = repository;
        this.roomId = roomId;
        this.eventId = eventId;
    }

    @Override
    public void execute() {
        //get the room & the event
        Room room = this.repository.findById(this.roomId);
        Event event = this.repository.finEventdById(eventId);
        
        //add the event to the room
        if(event instanceof Concert){
            Concert concert = (Concert)event;
            room.addEvent(concert.getDate(), concert.getArtist(), concert.getCapacity());
        }
        else{
            PieceTheatre piece = (PieceTheatre)event;
            room.addEvent(piece.getBeginDate(), piece.getEndingDate(), piece.getTitle(), piece.getCapacity());
        }
        

        


        //save the repository //TODO is it ok ?
        this.repository.save(room);

    }
}
