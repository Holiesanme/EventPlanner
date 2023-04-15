import { Routes } from '@angular/router';
import { ParticipantListComponent } from './participant-list/participant-list.component';

export const PARTICIPANTS_OVERVIEW_ROUTES: Routes = [
    {
      path: 'participant-list/:roomId', component: ParticipantListComponent
    }
];
