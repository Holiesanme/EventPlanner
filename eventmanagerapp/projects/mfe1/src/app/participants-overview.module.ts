import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { PARTICIPANTS_OVERVIEW_ROUTES } from './participants-overview.routes';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ParticipantListComponent } from './participant-list/participant-list.component';
import { ParticipantService } from './participant-list/participant/participant.service';
import { ParticipantAddComponent } from './participant-add/participant-add.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(PARTICIPANTS_OVERVIEW_ROUTES),
    HttpClientModule, 
    FormsModule
  ],
  declarations: [
    ParticipantListComponent,
    ParticipantAddComponent
    
  ],
  providers: [ParticipantService],

})
export class ParticipantsOverviewModule { }
