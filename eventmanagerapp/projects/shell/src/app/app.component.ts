import { Component } from '@angular/core';

import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  title = 'shell';

  public roomId: number;

  constructor(private router: Router){}
  
  ngOnInit() {
    this.roomId = 1;
  }

  public onParticipantListClick() {
    this.router.navigate(['mfe1/participant-list',this.roomId]); 
      //this.router.navigate(['mfe1', this.roomId]);
    }

   public goHome(){
      this.router.navigate(['/']); 
    }
  
}

