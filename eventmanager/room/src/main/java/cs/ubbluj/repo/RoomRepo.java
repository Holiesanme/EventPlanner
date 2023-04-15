package cs.ubbluj.repo;

import cs.ubbluj.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RoomRepo extends JpaRepository<Room, Long> {
    @Transactional
    void deleteRoomById(Long id);

    Optional<Room> findRoomById(Long id);
}
