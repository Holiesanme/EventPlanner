import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RoomService } from '../room/room.service';
import { Room } from '../room/room';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {


  constructor(private roomService: RoomService,
            private router: Router) { }

  ngOnInit() {
  }

  public onCreateRoom(addForm: NgForm): void {
    this.roomService.addRoom(addForm.value).subscribe(
      (response: Room) => {
        console.log(response);
        addForm.reset();
        this.redirectToRoom(response.id);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onJoinRoom(joinForm: NgForm): void {
    var roomId = joinForm.controls.roomId.value;
    this.redirectToRoom(roomId);
    
  }

  public onJoinTeamOrganize(joinForm: NgForm): void {
    var roomId = joinForm.controls.roomId.value;
    this.redirectToTeamOrganize(roomId);
    
  }

  private redirectToRoom(roomId: number): void{
    this.router.navigate(['mfe1/participant-list', roomId]);
  }

  private redirectToTeamOrganize(roomId:number): void{
    this.router.navigate(['mfe2/participant-add', roomId]);

  }

  

}
