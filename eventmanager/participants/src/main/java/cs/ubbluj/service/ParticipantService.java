package cs.ubbluj.service;

import cs.ubbluj.exception.ParticipantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import cs.ubbluj.model.Participant;
import cs.ubbluj.repository.ParticipantRepo;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepo participantRepo;


    public ParticipantService(ParticipantRepo participantRepo, RestTemplate restTemplate) {
        this.participantRepo = participantRepo;
    }

    @Autowired
    public ParticipantService(ParticipantRepo participantRepo) {
        this.participantRepo = participantRepo;
    }

    public Participant addParticipant(Participant participant) {
        return participantRepo.save(participant);
    }

    public Participant updateParticipant(Participant participant) {
        return participantRepo.save(participant);
    }

    public Participant findParticipantById(Long id) {
        return participantRepo.findParticipantById(id)
                .orElseThrow(() -> new ParticipantNotFoundException("Participant by id " + id + " was not found"));
    }

    public List<Participant> findParticipantsByRoomId(Long participantId) {
        return participantRepo.findByRoomId(participantId);
    }
    public void deleteParticipant(Long id){
        participantRepo.deleteParticipantById(id);
    }


}
