import { HttpErrorResponse } from '@angular/common/http';
import {Component, Input} from '@angular/core';
import { Participant } from './participant/participant';
import { ParticipantService } from './participant/participant.service';
import { ActivatedRoute } from '@angular/router';
import { Room } from './room/room';
import { RoomService } from './room/room.service';


@Component({
  selector: 'participant-list',
  templateUrl: './participant-list.component.html',
  styleUrls: ['./participant-list.component.css']
})
export class ParticipantListComponent {


  public participants: Participant[];
  public searchResults: Participant[];
  public priorityParticipants: Participant[];
  public nonPriorityParticipants: Participant[];
  public editParticipant: Participant;
  public deleteParticipant: Participant;
  public room: Room;
  
  constructor(private route: ActivatedRoute,
    private participantService: ParticipantService,
    private roomService: RoomService){

    }

  ngOnInit() {


    this.roomService.getRoom( parseInt(this.route.snapshot.paramMap.get('roomId'))).subscribe(
      (response: Room) => {
        this.room = response;
        console.log(this.room);
        this.getParticipantsByRoom(this.room.id);
      },
       (error: HttpErrorResponse) => {
        
      }
    );
    
  }

  public refetchParticipants(event: any): void
  {
    this.getParticipantsByRoom(this.room.id);
  }

  public getParticipantsByRoom(roomId): void {
    this.participantService.getParticipantsByRoom(roomId).subscribe(
      (response: Participant[]) => {
        this.participants = response;
        this.searchResults = this.participants;
        this.priorityParticipants = this.searchResults.filter((participant) => participant.priority)
        this.nonPriorityParticipants = this.searchResults.filter((participant) => !participant.priority)

      },
      (error: HttpErrorResponse) => {

        alert(error.message);
      }
    );
  }


  public onUpdateParticipant(participant: Participant): void {
    console.log("update:")
    console.log(participant);

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

  public onDeleteParticipant(participantId: number): void {
    this.participantService.deleteParticipant(participantId).subscribe(
      (response: void) => {
        console.log(response);
        this.getParticipantsByRoom(this.room.id);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchParticipants(key: string): void {
    this.searchResults = this.participants;
    if (key)
    {
      console.log(key);
    
      const results: Participant[] = [];
      for (const participant of this.participants) {
        if (participant.name.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
          results.push(participant);
        }
      }
      this.searchResults = results;
      
    }
    this.priorityParticipants = this.searchResults.filter((participant) => participant.priority)
    this.nonPriorityParticipants = this.searchResults.filter((participant) => !participant.priority)
  }

  public onOpenModal(participant: Participant, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'edit') {
      this.editParticipant = participant;
      button.setAttribute('data-target', '#updateParticipantModal');
    }
    if (mode === 'delete') {
      this.deleteParticipant = participant;
      button.setAttribute('data-target', '#deleteParticipantModal');
    }
    container.appendChild(button);
    button.click();
  }

  public getParticipantDateFormatted(date: Date){
    return new Date(date).toLocaleString();
  }
  
}
