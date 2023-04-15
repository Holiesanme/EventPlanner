package cs.ubbluj.controller;

import cs.ubbluj.service.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cs.ubbluj.model.Participant;

import java.util.List;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Participant> getEventById(@PathVariable("id") Long id) {
        Participant participant = participantService.findParticipantById(id);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @GetMapping("/getbyroom/{roomId}")
    public ResponseEntity<List<Participant>> getParticipantsByRoomId(@PathVariable("roomId") Long roomId) {
        List<Participant> participants = participantService.findParticipantsByRoomId(roomId);
        return new ResponseEntity<>(participants, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Participant> addParticipant(@RequestBody Participant participant) {
        Participant newParticipant = participantService.addParticipant(participant);
        return new ResponseEntity<>(newParticipant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Participant> updateParticipant(@RequestBody Participant participant) {
        Participant updateParticipant = participantService.updateParticipant(participant);
        return new ResponseEntity<>(updateParticipant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable("id") Long id) {
        participantService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
