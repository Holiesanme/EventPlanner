import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { PARTICIPANT_ADD_ROUTES } from './participantadd.routes';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ParticipantAddComponent } from './participant-add/participant-add.component';
import { ParticipantService } from './participant-add/participant/participant.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(PARTICIPANT_ADD_ROUTES),
    HttpClientModule, 
    FormsModule
  ],
  declarations: [
    ParticipantAddComponent
    
  ],
  providers: [
  ParticipantService],

})
export class ParticipantAddModule { }
