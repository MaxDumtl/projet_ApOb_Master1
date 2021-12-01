package infrastructure;

import domain.Room;
import domain.RoomRepository;

import java.util.HashSet;
import java.util.Set;

public class RoomRepositoryInMemory implements RoomRepository {

    Set<Room> memory;

    public RoomRepositoryInMemory() {
        this.memory = new HashSet<>();
    }

    @Override
    public Room findById(int id) {
        Room room = null;

        for(Room currentRoom : this.memory){
            if(currentRoom.getId() == id){
                room = currentRoom;
                break;
            }
        }

        return room;
    }

    @Override
    public Set<Room> load() {
        return null; //TODO
    }

    @Override
    public void save(Room room) {
        this.memory.add(room);
    }

    @Override
    public void update(Room room) {
        this.memory.add(room); //TODO check if its done what it has to
    }
}
