package infrastructure;

import domain.*;

import java.util.*;

public class RoomRepositoryInMemory implements RoomRepository {

    private Set<Room> memoryRoom;
    private Set<Event> memoryEvent;
    

    public RoomRepositoryInMemory() {
        this.memoryRoom = new HashSet<>();
        this.memoryEvent = new HashSet<>();

        //To initialize test data
        createTest();
    }

    /**
     * Initialize tests' list of event and room in memory
     */
    public void createTest(){
        Artist artist1 = new Artist("Damso");
        Artist artist2 = new Artist("Orelsan");
        Artist artist3 = new Artist("Queens");

        Room room1 = new Room("salle1", 80);
        Room room2 = new Room("salle2", 100);
        Room room3 = new Room("salle3", 150);

        for(int i = 1; i < 31; i++){
            room1.addSchedule(new GregorianCalendar(2021, 10, i), 8, 0, 19, 0);
        }
        for(int i = 1; i < 31; i++){
            room2.addSchedule(new GregorianCalendar(2021, 10, i), 8, 0, 12, 0);
        }
        for(int i = 1; i < 31; i++){
            room3.addSchedule(new GregorianCalendar(2021, 10, i), 13, 0, 23, 0);
        }
        memoryRoom.add(room1);
        memoryRoom.add(room2);
        memoryRoom.add(room3);

        Event concert1 = new Concert(new GregorianCalendar(2021, 10, 12), artist1, 70);
        Event concert2 = new Concert(new GregorianCalendar(2021, 10, 16), artist1, 80);
        Event concert3 = new Concert(new GregorianCalendar(2021, 10, 5), artist2, 135);
        Event concert4 = new Concert(new GregorianCalendar(2021, 10, 24), artist3, 111);
        Event concert5 = new Concert(new GregorianCalendar(2021, 10, 12), artist3, 98);
        
        Event concert6 = new Concert(new GregorianCalendar(2021, 10, 20), artist2, 160);

        Event piece1 = new PieceTheatre(new GregorianCalendar(2021, 10, 1), new GregorianCalendar(2021, 10, 12), "nom_piece_1", 70);
        Event piece2 = new PieceTheatre(new GregorianCalendar(2021, 10, 16), new GregorianCalendar(2021, 10, 20), "nom_piece_2", 80);
        Event piece3 = new PieceTheatre(new GregorianCalendar(2021, 10, 5), new GregorianCalendar(2021, 10, 17), "nom_piece_3", 135);
        Event piece4 = new PieceTheatre(new GregorianCalendar(2021, 10, 24), new GregorianCalendar(2021, 10, 30), "nom_piece_4", 111);
        Event piece5 = new PieceTheatre(new GregorianCalendar(2021, 10, 8), new GregorianCalendar(2021, 10, 15), "nom_piece_5", 98);
        
        Event piece6 = new PieceTheatre(new GregorianCalendar(2021, 10, 13), new GregorianCalendar(2021, 10, 30), "nom_piece_6", 98);
    
        memoryEvent.add(concert1);
        memoryEvent.add(concert2);
        memoryEvent.add(concert3);
        memoryEvent.add(concert4);
        memoryEvent.add(concert5);
        memoryEvent.add(concert6);

        
        memoryEvent.add(piece1);
        memoryEvent.add(piece2);
        memoryEvent.add(piece3);
        memoryEvent.add(piece4);
        memoryEvent.add(piece5);
        memoryEvent.add(piece6);
    }

    @Override
    public Room findById(int id) {
        Room room = null;

        for(Room currentRoom : this.memoryRoom){
            if(currentRoom.getId() == id){
                room = currentRoom;
                break;
            }
        }

        return room;
    }

    public Event finEventdById(int id) {
        Event event = null;

        for(Event currentEvent : this.memoryEvent){
            if(currentEvent.getId() == id){
                event = currentEvent;
                break;
            }
        }

        return event;
    }

    @Override
    public Set<Room> load() {
        return null;
    }

    @Override
    public void save(Room room) {
        this.memoryRoom.add(room);
    }

    @Override
    public void update(Room room) {
        this.memoryRoom.add(room);
    }

    @Override
    public int getNumRoom(){
        return this.memoryRoom.size();
    }

    @Override
    public int getNumEvent(){
        return this.memoryEvent.size();
    }

    @Override
    public Set<Event> findByDay(int id, int year, int month, int day) {
        Set<Event> listEventWeek = new HashSet<>();
        
        Room room = findById(id);
        
        List<Event> temproraryEventList = room.getEvent();

        if(!temproraryEventList.isEmpty()){
            for(Event currentEvent : temproraryEventList){
                if(currentEvent.isSameDay(year, month, day)){
                    listEventWeek.add(currentEvent);
                }
            }
        }
        

        return listEventWeek;
    }

    @Override
    public Set<Event> getEvents() {
        return this.memoryEvent;
    }

    @Override
    public Set<Room> getRooms() {
        return this.memoryRoom;
    }
}
