package cs.ubbluj.service;


import cs.ubbluj.exception.RoomNotFoundException;
import cs.ubbluj.model.Room;
import cs.ubbluj.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {
    private final RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Room addRoom(Room room) {
        return roomRepo.save(room);
    }

    public Room updateRoom(Room room) {
        return roomRepo.save(room);
    }

    public Room findRoomById(Long id) {
        return roomRepo.findRoomById(id)
                .orElseThrow(() -> new RoomNotFoundException("Room by id " + id + " was not found"));
    }

    public void deleteRoom(Long id){
        roomRepo.deleteRoomById(id);
    }
}
