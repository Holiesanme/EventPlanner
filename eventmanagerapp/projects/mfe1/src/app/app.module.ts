import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ParticipantsOverviewModule } from './participants-overview.module';
import { APP1_ROUTES } from './app.routes';
import { ParticipantService } from './participant-list/participant/participant.service';

@NgModule({
  imports: [
    BrowserModule,
    ParticipantsOverviewModule,
    RouterModule.forRoot(APP1_ROUTES),
  ],
  declarations: [
    HomeComponent,
    AppComponent,
  ],
  providers: [ParticipantService],
  bootstrap: [
      AppComponent
  ]
})
export class AppModule {

 }
