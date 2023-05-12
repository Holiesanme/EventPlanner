import cs.ubbluj.exception.ParticipantNotFoundException;
import cs.ubbluj.model.Participant;
import cs.ubbluj.repository.ParticipantRepo;
import cs.ubbluj.service.ParticipantService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ParticipantServiceTest {

    @Mock
    private ParticipantRepo participantRepo;
    @InjectMocks
    private ParticipantService participantService;

    private Participant setUpParticipant()
    {
         return new Participant(1L,"Participant",
                true,1,10, LocalDateTime.now(),1L);

    }

    @Test
    public void addParticipantSuccessful() {

        Participant participant = setUpParticipant();
        when(participantRepo.save(Mockito.any(Participant.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        Participant participant1 = participantService.addParticipant(participant);

        assert (participant1.equals(participant));
    }

    @Test
    public void updateParticipantSuccessful() {

        Participant participant = setUpParticipant();
        when(participantRepo.save(Mockito.any(Participant.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        Participant participant1 = participantService.updateParticipant(participant);
        assert (participant1.equals(participant));

    }

    @Test
    public void findParticipantByIdSuccess() {
        Participant participant = setUpParticipant();
        when(participantRepo.findParticipantById(1L))
                .thenReturn(Optional.of(participant));
        Participant participant1 = participantService.findParticipantById(1L);
        assert (participant1.equals(participant));
    }

    @Test
    public void findParticipantByIdNotFound() {
        Participant participant = setUpParticipant();
        when(participantRepo.findParticipantById(1L))
                .thenReturn(Optional.empty());
        ParticipantNotFoundException exception = assertThrows(ParticipantNotFoundException.class, () -> {
            participantService.findParticipantById(1L);
        });
        assert(exception.getMessage().contains("was not found"));
    }

    @Test
    public void findParticipantsByRoomIdSuccess() {
        Participant participant1 = setUpParticipant();
        Participant participant2 = setUpParticipant();
        Participant participant3 = setUpParticipant();
        Participant participant4 = setUpParticipant();

        participant2.setId(2L);
        participant3.setId(3L);
        participant4.setId(4L);


        when(participantRepo.findByRoomId(1L))
                .thenReturn(List.of(participant1,participant2,participant3,participant4));
        List<Participant> participants = participantService.findParticipantsByRoomId(1L);
        assert (participants.size() == 4);

    }

    @Test
    public void findParticipantsByRoomIdEmptyList() {
        when(participantRepo.findByRoomId(1L))
                .thenReturn(List.of());
        List<Participant> participants = participantService.findParticipantsByRoomId(1L);
        assert (participants.size() == 0);
    }

}
