import cs.ubbluj.exception.RoomNotFoundException;
import cs.ubbluj.model.Room;
import cs.ubbluj.repo.RoomRepo;
import cs.ubbluj.service.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    @Mock
    private RoomRepo roomRepo;
    @InjectMocks
    private RoomService roomService;

    private Room setUpRoom()
    {
         return new Room(1L,"RoomDescription");
    }

    @Test
    public void addRoomSuccessful() {

        Room room = setUpRoom();
        when(roomRepo.save(Mockito.any(Room.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        Room room1 = roomService.addRoom(room);

        assert (room1.equals(room));
    }

    @Test
    public void updateRoomSuccessful() {

        Room room = setUpRoom();
        when(roomRepo.save(Mockito.any(Room.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        Room room1 = roomService.updateRoom(room);
        assert (room1.equals(room));

    }

    @Test
    public void findRoomByIdSuccess() {
        Room room = setUpRoom();
        when(roomRepo.findRoomById(1L))
                .thenReturn(Optional.of(room));
        Room room1 = roomService.findRoomById(1L);
        assert (room1.equals(room));
    }

    @Test
    public void findRoomByIdNotFound() {
        Room room = setUpRoom();
        when(roomRepo.findRoomById(1L))
                .thenReturn(Optional.empty());
        RoomNotFoundException exception = assertThrows(RoomNotFoundException.class, () -> {
            roomService.findRoomById(1L);
        });
        assert(exception.getMessage().contains("was not found"));
    }

}
