import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Quote } from './quote';

@Injectable({providedIn: 'root'})
export class QuoteService {
  private apiServerUrl = 'http://localhost:8083';

  constructor(private http: HttpClient){}

  public getQuote(): Observable<Quote> {
    return this.http.get<Quote>(`${this.apiServerUrl}/inspquote/random`);
  }

 
}
