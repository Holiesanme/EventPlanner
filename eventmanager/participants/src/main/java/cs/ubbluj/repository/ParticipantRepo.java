package cs.ubbluj.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import cs.ubbluj.model.Participant;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepo extends JpaRepository<Participant, Long> {
    @Transactional
    void deleteParticipantById(Long id);

    Optional<Participant> findParticipantById(Long id);

    List<Participant> findByRoomId(Long roomId);
}
