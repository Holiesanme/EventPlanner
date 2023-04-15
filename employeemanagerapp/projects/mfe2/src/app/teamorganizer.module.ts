import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TEAM_ORGANIZER_ROUTES } from './teamorganizer.routes';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TeamOrganizerComponent } from './team-organizer/team-organizer.component';
import { ParticipantService } from './team-organizer/participant/participant.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(TEAM_ORGANIZER_ROUTES),
    HttpClientModule, 
    FormsModule
  ],
  declarations: [
    TeamOrganizerComponent
    
  ],
  providers: [
  ParticipantService],

})
export class TeamOrganizerModule { }
