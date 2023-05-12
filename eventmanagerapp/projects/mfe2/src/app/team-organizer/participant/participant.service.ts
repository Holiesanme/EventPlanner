import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Participant } from './participant';

@Injectable({providedIn: 'root'})
export class ParticipantService {
  private apiServerUrl = 'http://localhost:8083';


  constructor(private http: HttpClient){}

  public getParticipants(): Observable<Participant[]> {
    return this.http.get<Participant[]>(`${this.apiServerUrl}/participant/all`);
  }

  public getParticipantsByRoom(id: number): Observable<Participant[]> {
    return this.http.get<Participant[]>(`${this.apiServerUrl}/participant/getbyroom/${id}`);

  }

  public addParticipant(participant: Participant): Observable<Participant> {
    return this.http.post<Participant>(`${this.apiServerUrl}/participant/add`, participant);
  }

  public updateParticipant(participant: Participant): Observable<Participant> {
    return this.http.put<Participant>(`${this.apiServerUrl}/participant/update`, participant);
  }

  public deleteParticipant(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/participant/delete/${id}`);
  }


}
