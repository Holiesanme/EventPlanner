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
  team1Participants: Participant[];
  team2Participants: Participant[];

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
        this.priorityParticipants = this.participants.filter((participant) => participant.priority && participant.team == null);
        this.nonPriorityParticipants = this.participants.filter((participant) => !participant.priority && participant.team == null);
        this.team1Participants = this.participants.filter((participant)=> participant.team===1);
        this.team2Participants = this.participants.filter((participant)=> participant.team===2);

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

  public getParticipantDateFormatted(date: Date){
    return new Date(date).toLocaleString();
  }
  
  public moveToTeam1(participant:Participant){
    participant.team=1;
    this.onUpdateParticipant(participant);
  }

  public moveToTeam2(participant:Participant){
    participant.team=2;
    this.onUpdateParticipant(participant);
  }
  public resetTeam(participant:Participant){
    participant.team=null;
    this.onUpdateParticipant(participant);
  }

  public randomizeParticipantTeams(){
    this.participants.forEach(participant => {
      var number= Math.round(Math.random()) ;
      number = number +1;
      participant.team =  number;
      this.onUpdateParticipant(participant);
    });
    
  }

}
