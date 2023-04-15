import { Routes } from '@angular/router';
import { ParticipantAddComponent } from './participant-add/participant-add.component';

export const PARTICIPANT_ADD_ROUTES: Routes = [
    {
      path: 'participant-add/:roomId',
      component: ParticipantAddComponent
    }
];
