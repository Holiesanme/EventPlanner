import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { loadRemoteModule } from '@angular-architects/module-federation';

export const APP_ROUTES: Routes = [
    {
      path: '',
      component: HomeComponent,
      pathMatch: 'full'
    },

    {
      path: 'mfe1',
      loadChildren: () =>
            loadRemoteModule({
               type: 'module',
               remoteEntry: 'http://localhost:4201/remoteEntry.js',
               exposedModule: './Module'
           })
           .then(m => m.ParticipantsOverviewModule)
    
    },
    {
      path: 'mfe2',
      loadChildren: () =>
          loadRemoteModule({
              type: 'module',
              remoteEntry: 'http://localhost:4202/remoteEntry.js',
              exposedModule: './Module'
          })
          .then(m => m.TeamOrganizerModule)

    },

    {
      path: '**',
      component: NotFoundComponent
    }

    // DO NOT insert routes after this one.
    // { path:'**', ...} needs to be the LAST one.

];

