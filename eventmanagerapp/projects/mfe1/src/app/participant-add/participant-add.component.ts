import { HttpErrorResponse } from '@angular/common/http';
import {Component, EventEmitter, Input, Output} from '@angular/core';
import { NgForm } from '@angular/forms';
import { Participant } from '../participant-list/participant/participant';
import { ParticipantService } from '../participant-list/participant/participant.service';


@Component({
  selector: 'participant-add',
  templateUrl: './participant-add.component.html',
  styleUrls: ['./participant-add.component.css']
})
export class ParticipantAddComponent {

  @Input()
  roomId: string;

  constructor(private participantService: ParticipantService){}

  ngOnInit() {
  }

  @Output()
  participantListUpdateEvent = new EventEmitter<string>();

  public onAddParticipant(addForm: NgForm): void {
    document.getElementById('add-participant-form').click();
    addForm.value.roomId = this.roomId;
    this.participantService.addParticipant(addForm.value).subscribe(
      (response: Participant) => {
        console.log(response);
        this.participantListUpdateEvent.emit('done');
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onOpenModal(participant: Participant, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addParticipantModal');
    }
    container.appendChild(button);
    button.click();
  }

}
