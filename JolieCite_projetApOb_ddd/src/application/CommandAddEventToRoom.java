package application;

import domain.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

public class CommandAddEventToRoom extends Command {

    private RoomRepository repository;
    private int eventId;
    private int hour;

    //COnstructor help to get necessarry object to execute its "mission"
    public CommandAddEventToRoom(RoomRepository repository, int eventId, int hour) {
        this.repository = repository;
        this.eventId = eventId;
        this.hour = hour;
    }

    @Override
    public void execute() {
        //get the room & the event
        Event event = this.repository.finEventdById(eventId);
        Room room = getSelectedRoom();

        //add the event to the room
        if (event instanceof Concert) {
            Concert concert = (Concert) event;
            room.addEvent(concert.getDate(), concert.getArtist(), concert.getCapacity());
        } else {
            PieceTheatre piece = (PieceTheatre) event;
            room.addEvent(piece.getBeginDate(), piece.getEndingDate(), piece.getTitle(), piece.getCapacity());
        }

    }

    private Room getSelectedRoom() {
        Room selectedRoom = null;
        Event event = this.repository.finEventdById(this.eventId);
        int eventCapacity = event.getCapacity();

        for (Room currentRoom : this.repository.getRooms()) { // Loop on every loop
            //check room capacity
            if (eventCapacity > currentRoom.getCapacity()) {
                break; // go to next room loop //TODO check if its correct
            }

            //check hour
            Calendar programmedDay = null;
            if (event instanceof Concert) {
                Concert currentConcert = (Concert) event;
                programmedDay = currentConcert.getDate();

            } else if (event instanceof PieceTheatre){
                PieceTheatre currentPieceTheatre = (PieceTheatre) event;
                programmedDay = currentPieceTheatre.getBeginDate(); //TODO change it to check for every day between begin and end
            }

            int programmedDayOpeningHour = currentRoom.getSchedule(programmedDay).getOpeningHour();
            int programmedDayEndingHour = currentRoom.getSchedule(programmedDay).getEndingHour();

            if(this.hour > programmedDayEndingHour && this.hour < programmedDayOpeningHour){
                break; // go to next room loop //TODO check if its correct
            }

            //check if there is already a concert at this room in this weekend
            //TODO

            //check if it could be programmed during a week end
            //TODO (only for PieceTheatre)

            //check if already an event at this room and hour
            //TODO

            selectedRoom = currentRoom;
        }

        return selectedRoom;
    }
}
