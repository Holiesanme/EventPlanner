import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from './room';

@Injectable({providedIn: 'root'})
export class RoomService {
  private apiServerUrl = 'http://localhost:8081';

  constructor(private http: HttpClient){}

  public getRoom(roomId: number): Observable<Room> {
    return this.http.get<Room>(`${this.apiServerUrl}/room/find/${roomId}`);
  }

  public addRoom(room: Room): Observable<Room> {
    return this.http.post<Room>(`${this.apiServerUrl}/room/add`, room);
  }

  public updateRoom(room: Room): Observable<Room> {
    return this.http.put<Room>(`${this.apiServerUrl}/room/update`, room);
  }
}
