import { HttpErrorResponse } from '@angular/common/http';
import {Component} from '@angular/core';
import { NgForm } from '@angular/forms';
import { Participant } from './participant/participant';
import { ParticipantService } from './participant/participant.service';
import { RoomService } from './room/room.service';
import { ActivatedRoute } from '@angular/router';
import { Room } from './room/room';

@Component({
  selector: 'participant-add',
  templateUrl: './participant-add.component.html',
  styleUrls: ['./participant-add.component.css']
})
export class ParticipantAddComponent {

  public room: Room;
  public participants: Participant[];
  priorityParticipants: Participant[];
  nonPriorityParticipants: Participant[];

  constructor(private participantService: ParticipantService,
            private roomService:RoomService,
            private route:ActivatedRoute){}
  
  ngOnInit() {

    this.roomService.getRoom( parseInt(this.route.snapshot.paramMap.get('roomId'))).subscribe(
      (response: Room) => {
        this.room = response;
        console.log(this.room);
        this.getParticipantsByRoom(this.room.id);
      }
    );

  }

  public getParticipantsByRoom(roomId): void {
    this.participantService.getParticipantsByRoom(roomId).subscribe(
      (response: Participant[]) => {
        this.participants = response;
        this.priorityParticipants = this.participants.filter((participant) => participant.priority)
        this.nonPriorityParticipants = this.participants.filter((participant) => !participant.priority)
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onUpdateParticipant(participant: Participant): void {
    this.participantService.updateParticipant(participant).subscribe(
      (response: Participant) => {
        console.log(response);
        this.getParticipantsByRoom(this.room.id);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
