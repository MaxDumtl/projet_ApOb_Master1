package domain;

import java.util.Set;

public interface RoomRepository {
    /**
     * Find a Room searching by id
     * @param id wanted room's id
     * @return wanted room or NULL if it doesn't found
     */
    public Room findById(int id);
    //public void findBy...() //TODO search other features to find with

    public Set<Room> load();
    public void save(Room basket);
    public void update(Room basket);
}
