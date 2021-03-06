package domain;

import java.util.Set;

public interface RoomRepository {
    /**
     * Find a Room searching by id
     * @param id wanted room's id
     * @return wanted room or NULL if it doesn't found
     */
    public Room findById(int id);

    public Event finEventdById(int id);
    public Set<Event> findByDay(int id, int year, int month, int day);


    public Set<Room> load();
    public void save(Room room);
    public void update(Room room);

    public int getNumRoom();
    public int getNumEvent();
    public Set<Room> getRooms();
    public Set<Event> getEvents();
}
