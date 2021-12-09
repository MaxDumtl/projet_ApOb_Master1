package infrastructure;

import domain.Event;
import domain.Room;
import domain.RoomRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class RoomRepositoryJson implements RoomRepository{

    Set<Room> memory;

    public RoomRepositoryJson() {
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
    public Event finEventdById(int id) {
        return null;
    }

    @Override
    public Set<Event> findByDay(int id, int year, int month, int day) {
        return null;
    }

    @Override
    public Set<Room> load() {
        
        Gson gson_object = new Gson();
        Type memory_type = new TypeToken<Set<Room>>(){}.getType();
        String memory_json = null; 
        
        try {
            Path fileName = Path.of("src/json/save.json");
            memory_json = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Room> loaded_memory_set = gson_object.fromJson(memory_json, memory_type);
       
        return loaded_memory_set; //TODO
    }

    @Override
    public void save(Room room) {
        this.memory.add(room);

        Gson gson_object = new Gson(); //TODO import the Gson class
        String memory_json = gson_object.toJson(this.memory);

        try {
            FileWriter json_writer = new FileWriter("src/json/save.json");
            json_writer.write(memory_json);
            json_writer.flush();
            json_writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Room room) {
        this.memory.add(room); //TODO check if its done what it has to
    }

    @Override
    public int getNumRoom() {
        return 0;
    }

    @Override
    public int getNumEvent() {
        return 0;
    }

    @Override
    public Set<Room> getRooms() {
        return null;
    }

    @Override
    public Set<Event> getEvents() {
        return null;
    }

}
