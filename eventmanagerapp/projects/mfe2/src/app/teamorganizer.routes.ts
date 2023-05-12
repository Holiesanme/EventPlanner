import { Routes } from '@angular/router';
import { TeamOrganizerComponent } from './team-organizer/team-organizer.component';

export const TEAM_ORGANIZER_ROUTES: Routes = [
    {
      path: 'team-organizer/:roomId',
      component: TeamOrganizerComponent
    }
];
